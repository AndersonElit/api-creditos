package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.UseCaseForCommand;
import com.apicreditos.command.ConsultarCreditoCommand;
import com.apicreditos.entities.Credito;
import com.apicreditos.gateways.CreditoRepository;
import com.apicreditos.values.CreditoId;

import java.util.List;

public class ConsultarCreditoUseCase implements UseCaseForCommand<ConsultarCreditoCommand> {

    private final CreditoRepository repository;

    public ConsultarCreditoUseCase(CreditoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(ConsultarCreditoCommand command) {

        List<DomainEvent> events = repository.buscarPorIdNoReactivo(command.getCreditoId());
        Credito credito = Credito.from(CreditoId.of(command.getCreditoId()), events);
        credito.consultarCredito();
        return credito.getUncommittedChanges();

    }

}
