package com.apicreditos.usecases;

import com.apicreditos.Command;
import com.apicreditos.DomainEvent;
import com.apicreditos.command.VincularClienteCommand;
import com.apicreditos.entities.Vinculacion;
import com.apicreditos.UseCaseForCommandNoReactivo;
import com.apicreditos.gateways.VinculacionRepositoryNoReactivo;
import com.apicreditos.values.VinculacionId;

import java.util.List;

public class VincularClienteUseCaseNoReactivo implements UseCaseForCommandNoReactivo {

    private VinculacionRepositoryNoReactivo repository;

    public VincularClienteUseCaseNoReactivo(VinculacionRepositoryNoReactivo repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(Command command) {
        VincularClienteCommand vincularCliente = (VincularClienteCommand) command;
        Vinculacion vinculacion = new Vinculacion(
                VinculacionId.of(vincularCliente.getVinculacionId())
        );
        vinculacion.crearCliente(vincularCliente.getCliente());
        vinculacion.asignarAsesor(vincularCliente.getAsesor());
        vinculacion.asignarOficina(vincularCliente.getOficina());
        return vinculacion.getUncommittedChanges().stream().map(event -> {
            return repository.vincularClienteNoReactivo(event);
        }).toList();
    }

}
