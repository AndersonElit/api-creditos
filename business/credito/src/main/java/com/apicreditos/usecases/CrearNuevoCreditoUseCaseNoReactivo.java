package com.apicreditos.usecases;

import com.apicreditos.Command;
import com.apicreditos.DomainEvent;
import com.apicreditos.UseCaseForCommandNoReactivo;
import com.apicreditos.command.CrearNuevoCreditoCommand;
import com.apicreditos.entities.Credito;
import com.apicreditos.gateways.CreditoRepositoryNoReactivo;
import com.apicreditos.values.CreditoId;
import com.apicreditos.values.VinculacionId;

import java.util.List;

public class CrearNuevoCreditoUseCaseNoReactivo implements UseCaseForCommandNoReactivo {

    private final CreditoRepositoryNoReactivo repository;

    public CrearNuevoCreditoUseCaseNoReactivo(CreditoRepositoryNoReactivo repository) {
        this.repository = repository;
    }


    @Override
    public List<DomainEvent> apply(Command command) {
        CrearNuevoCreditoCommand crearNuevoCredito = (CrearNuevoCreditoCommand) command;
        Credito credito = new Credito(
                CreditoId.of(crearNuevoCredito.getCreditoId()),
                VinculacionId.of(crearNuevoCredito.getVinculacionId()),
                crearNuevoCredito.getEstadoCredito()
        );
        credito.vincularCliente(VinculacionId.of(crearNuevoCredito.getVinculacionId()));
        credito.analizarHistorialCrediticio();
        credito.capacidadEndeudamiento();
        credito.valorPatrimonio();
        credito.consultaCentralesDeRiesgo();
        credito.calcularScore();
        return credito.getUncommittedChanges().stream().map(event -> {
            return repository.crearNuevoCreditoNoReactivo(event);
        }).toList();
    }

}
