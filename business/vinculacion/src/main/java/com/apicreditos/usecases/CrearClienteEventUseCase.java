package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Vinculacion;
import com.apicreditos.events.ClienteVinculado;
import com.apicreditos.gateways.VinculacionRepository;
import com.apicreditos.values.VinculacionId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

public class CrearClienteEventUseCase implements Function<Mono<ClienteVinculado>, Flux<DomainEvent>> {

    private final VinculacionRepository repository;

    public CrearClienteEventUseCase(VinculacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<ClienteVinculado> clienteVinculadoMono) {
        return clienteVinculadoMono.flatMapIterable(event -> {
            Vinculacion vinculacion = Vinculacion.from(VinculacionId.of(event.getVinculacionId().value()), List.of(event));
            vinculacion.crearCliente(event.getCliente());
            return vinculacion.getUncommittedChanges();
        }).flatMap(
                domainEvent -> repository.saveEvent(domainEvent)
        );
    }
}
