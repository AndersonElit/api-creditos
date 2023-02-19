package com.apicreditos.usecases;

import com.apicreditos.Command;
import com.apicreditos.DomainEvent;
import com.apicreditos.command.VincularClienteCommand;
import com.apicreditos.entities.Vinculacion;
import com.apicreditos.UseCaseForCommandNoReactivo;
import com.apicreditos.gateways.VinculacionRepository;
import com.apicreditos.values.VinculacionId;

import java.util.List;

public class VincularClienteUseCase implements UseCaseForCommandNoReactivo {

    private VinculacionRepository repository;

    public VincularClienteUseCase(VinculacionRepository repository) {
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
