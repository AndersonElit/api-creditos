package com.apicreditos;

import com.apicreditos.command.CrearNuevoCredito;
import com.apicreditos.entities.Credito;
import com.apicreditos.values.CreditoId;
import com.apicreditos.values.VinculacionId;

import java.util.List;

public class CrearNuevoCreditoUseCase implements UseCaseForCommand{

    @Override
    public List<DomainEvent> apply(Command command) {
        CrearNuevoCredito crearNuevoCredito = (CrearNuevoCredito) command;
        Credito credito = new Credito(
                CreditoId.of(crearNuevoCredito.getCreditoId()),
                VinculacionId.of(crearNuevoCredito.getVinculacionId()),
                crearNuevoCredito.getInformacionCreditoAprobado(),
                crearNuevoCredito.getEstadoCredito()
        );
        return credito.getUncommittedChanges();
    }

}
