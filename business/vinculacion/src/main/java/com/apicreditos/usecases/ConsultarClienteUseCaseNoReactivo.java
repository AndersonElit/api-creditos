package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.UseCaseForCommandNoReactivo;
import com.apicreditos.command.ConsultarClienteCommand;
import com.apicreditos.entities.Vinculacion;
import com.apicreditos.gateways.VinculacionRepositoryNoReactivo;
import com.apicreditos.values.VinculacionId;

import java.util.List;

public class ConsultarClienteUseCaseNoReactivo implements UseCaseForCommandNoReactivo<ConsultarClienteCommand> {

    private VinculacionRepositoryNoReactivo repository;

    public ConsultarClienteUseCaseNoReactivo(VinculacionRepositoryNoReactivo repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(ConsultarClienteCommand command) {
        List<DomainEvent> events = repository.buscarPorIdNoReactivo(command.getVinculacionId());
        Vinculacion vinculacion = Vinculacion.from(VinculacionId.of(command.getVinculacionId()), events);
        vinculacion.consultarCliente();
        return vinculacion.getUncommittedChanges();
    }

}
