package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.UseCaseForCommand;
import com.apicreditos.command.ConsultarClienteCommand;
import com.apicreditos.entities.Vinculacion;
import com.apicreditos.gateways.VinculacionRepository;
import com.apicreditos.values.VinculacionId;

import java.util.List;

public class ConsultarClienteUseCase implements UseCaseForCommand<ConsultarClienteCommand> {

    private VinculacionRepository repository;

    public ConsultarClienteUseCase(VinculacionRepository repository) {
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
