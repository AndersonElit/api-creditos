package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.UseCaseForCommand;
import com.apicreditos.command.VincularClienteCommand;
import com.apicreditos.entities.Vinculacion;
import com.apicreditos.gateways.VinculacionRepository;
import com.apicreditos.values.VinculacionId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class VincularClienteUseCase extends UseCaseForCommand<VincularClienteCommand> {

    private final VinculacionRepository repository;

    public VincularClienteUseCase(VinculacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<VincularClienteCommand> vincularClienteCommandMono) {

        return vincularClienteCommandMono.flatMapIterable(command -> {
            Vinculacion vinculacion = new Vinculacion(
                    VinculacionId.of(command.getVinculacionId())
            );
            vinculacion.crearCliente(command.getCliente());
            vinculacion.asignarAsesor(command.getAsesor());
            vinculacion.asignarOficina(command.getOficina());
            return vinculacion.getUncommittedChanges();
        }).flatMap(event -> repository.saveEvent(event));
    }

}
