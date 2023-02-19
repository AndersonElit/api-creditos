package com.apicreditos.gateways;

import com.apicreditos.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditoRepository {
    Flux<DomainEvent> findById(String aggregateId);
    Mono<DomainEvent> saveEvent(DomainEvent event);
}
