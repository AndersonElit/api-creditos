package com.apicreditos.usecases;

import com.apicreditos.Command;
import com.apicreditos.DomainEvent;
import com.apicreditos.UseCaseForCommand;
import com.apicreditos.command.CrearNuevoCredito;
import com.apicreditos.entities.Credito;
import com.apicreditos.gateways.CreditoRepository;
import com.apicreditos.values.CreditoId;
import com.apicreditos.values.VinculacionId;

import java.util.List;

public class CrearNuevoCreditoUseCase implements UseCaseForCommand {

    private final CreditoRepository repository;

    public CrearNuevoCreditoUseCase(CreditoRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<DomainEvent> apply(Command command) {
        CrearNuevoCredito crearNuevoCredito = (CrearNuevoCredito) command;
        Credito credito = new Credito(
                CreditoId.of(crearNuevoCredito.getCreditoId()),
                VinculacionId.of(crearNuevoCredito.getVinculacionId()),
                crearNuevoCredito.getInformacionCreditoAprobado(),
                crearNuevoCredito.getEstadoCredito()
        );
        return credito.getUncommittedChanges().stream().map(event -> {
            return repository.crearNuevoCreditoNoReactivo(event);
        }).toList();
    }

}
