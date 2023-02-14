package com.apicreditos.usecases;

import com.apicreditos.Command;
import com.apicreditos.DomainEvent;
import com.apicreditos.command.VincularCliente;
import com.apicreditos.entities.Vinculacion;
import com.apicreditos.UseCaseForCommand;
import com.apicreditos.gateways.VinculacionRepository;
import com.apicreditos.values.VinculacionId;

import java.util.List;

public class VincularClienteUseCase implements UseCaseForCommand {

    private final VinculacionRepository repository;

    public VincularClienteUseCase(VinculacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(Command command) {
        VincularCliente vincularCliente = (VincularCliente) command;
        Vinculacion vinculacion = new Vinculacion(
                VinculacionId.of(vincularCliente.getVinculacionId()),
                vincularCliente.getCliente(),
                vincularCliente.getAsesor(),
                vincularCliente.getOficina()
        );
        return vinculacion.getUncommittedChanges().stream().map(event -> {
            return repository.vincularClienteNoReactivo(event);
        }).toList();
    }

}
