package com.apicreditos;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class AggregateEvent<I extends Identity> extends AggregateRoot<I> {

    private final ChangeEventSubscriber changeEventSubscriber = new ChangeEventSubscriber();

    public AggregateEvent(I entityId) {
        super(entityId);
    }

    public List<DomainEvent> getUncommittedChanges() {
        return List.copyOf(this.changeEventSubscriber.changes());
    }

    protected ChangeEventSubscriber.ChangeApply appendChange(DomainEvent event) {
        String nameClass = this.id.getClass().getSimpleName();
        String aggregate = nameClass.replaceAll("(Identity|Id|ID)", "").toLowerCase();
        event.setAggregateName(aggregate);
        event.setAggregateRootId(this.id.value());
        return this.changeEventSubscriber.appendChange(event);
    }

    protected final void subscribe(EventChange eventChange) {
        this.changeEventSubscriber.subscribe(eventChange);
    }

    protected void applyEvent(DomainEvent domainEvent) {
        this.changeEventSubscriber.applyEvent(domainEvent);
    }

    public void markChangesAsCommitted() {
        this.changeEventSubscriber.changes().clear();
    }

    public void refundEvent() {
        this.changeEventSubscriber.changes().clear();
    }

    public <E extends DomainEvent> Optional<E> findEventUncommitted(Class<E> event) {
        Stream var10000 = this.changeEventSubscriber.changes().stream();
        Objects.requireNonNull(event);
        return var10000.filter(event::isInstance).map((e) -> {
            return e;
        }).findFirst();
    }

    public <E extends DomainEvent> Stream<E> findAllEventUncommitted(Class<E> event) {
        Stream var10000 = this.changeEventSubscriber.changes().stream();
        Objects.requireNonNull(event);
        return var10000.filter(event::isInstance).map((e) -> {
            return e;
        });
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public int hashCode() {
        return super.hashCode();
    }

}
