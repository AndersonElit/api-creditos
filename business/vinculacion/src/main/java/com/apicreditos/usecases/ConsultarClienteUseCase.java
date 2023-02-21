package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.UseCaseForCommand;
import com.apicreditos.command.ConsultarClienteCommand;
import com.apicreditos.entities.Vinculacion;
import com.apicreditos.gateways.VinculacionRepository;
import com.apicreditos.values.VinculacionId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ConsultarClienteUseCase extends UseCaseForCommand<ConsultarClienteCommand> {

    private final VinculacionRepository repository;

    public ConsultarClienteUseCase(VinculacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<ConsultarClienteCommand> consultarClienteCommandMono) {

        return consultarClienteCommandMono.flatMapMany(command -> repository.findById(command.getVinculacionId())
                .collectList()
                .flatMapIterable(events -> {
                    Vinculacion vinculacion = Vinculacion.from(VinculacionId.of(command.getVinculacionId()), events);
                    vinculacion.consultarCliente();
                    return vinculacion.getUncommittedChanges();
                }).flatMap(event -> repository.saveEvent(event)));

    }

}
