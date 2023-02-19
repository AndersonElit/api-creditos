package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.UseCaseForCommand;
import com.apicreditos.command.ConsultarCreditoCommand;
import com.apicreditos.entities.Credito;
import com.apicreditos.gateways.CreditoRepository;
import com.apicreditos.values.CreditoId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ConsultarCreditoUseCase extends UseCaseForCommand<ConsultarCreditoCommand> {

    private final CreditoRepository repository;

    public ConsultarCreditoUseCase(CreditoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<ConsultarCreditoCommand> consultarCreditoCommandMono) {

        return consultarCreditoCommandMono.flatMapMany(command -> repository.findById(command.getCreditoId())
                .collectList()
                .flatMapIterable(events -> {
                    Credito credito = Credito.from(CreditoId.of(command.getCreditoId()), events);
                    credito.consultarCredito();
                    return credito.getUncommittedChanges();
                }).flatMap(event -> repository.saveEvent(event))
        );

    }

}
