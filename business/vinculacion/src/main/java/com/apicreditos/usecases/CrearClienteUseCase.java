package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.UseCaseForCommandNoReactivo;
import com.apicreditos.command.CrearClienteCommand;
import com.apicreditos.entities.Vinculacion;
import com.apicreditos.gateways.VinculacionRepository;
import com.apicreditos.values.VinculacionId;

import java.util.List;

public class CrearClienteUseCase implements UseCaseForCommandNoReactivo<CrearClienteCommand> {

    private VinculacionRepository repository;

    public CrearClienteUseCase(VinculacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(CrearClienteCommand command) {
        List<DomainEvent> events = repository.buscarPorIdNoReactivo(command.getVinculacionId());
        Vinculacion vinculacion = Vinculacion.from(VinculacionId.of(command.getVinculacionId()), events);
        vinculacion.crearCliente(command.getCliente());
        return vinculacion.getUncommittedChanges().stream().map(event -> {
            return repository.vincularClienteNoReactivo(event);
        }).toList();
    }
}
