package com.apicreditos.usecases;

import com.apicreditos.Command;
import com.apicreditos.DomainEvent;
import com.apicreditos.command.VincularCliente;
import com.apicreditos.entities.Vinculacion;
import com.apicreditos.UseCaseForCommand;
import com.apicreditos.values.VinculacionId;

import java.util.List;

public class VincularClienteUseCase implements UseCaseForCommand {

    @Override
    public List<DomainEvent> apply(Command command) {
        VincularCliente vincularCliente = (VincularCliente) command;
        Vinculacion vinculacion = new Vinculacion(
                VinculacionId.of(vincularCliente.getVinculacionId()),
                vincularCliente.getCliente(),
                vincularCliente.getAsesor(),
                vincularCliente.getOficina(),
                vincularCliente.getFechaVinculacion()
        );
        return vinculacion.getUncommittedChanges();
    }

}
