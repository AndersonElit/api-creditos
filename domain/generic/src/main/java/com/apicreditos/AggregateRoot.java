package com.apicreditos;

public abstract class AggregateRoot<I extends Identity> extends Entity<I> {

    protected AggregateRoot(I id) {
        super(id);
    }

}
