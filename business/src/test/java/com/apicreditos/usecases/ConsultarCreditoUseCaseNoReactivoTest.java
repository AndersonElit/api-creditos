package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.command.ConsultarCreditoCommand;
import com.apicreditos.events.CreditoConsultado;
import com.apicreditos.gateways.CreditoRepositoryNoReactivo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ConsultarCreditoUseCaseNoReactivoTest {

    @Mock
    private CreditoRepositoryNoReactivo repository;

    private ConsultarCreditoUseCaseNoReactivo useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarCreditoUseCaseNoReactivo(repository);
    }

    @Test
    void apply() {

        String CREDITO_ID = "credito_id";

        ConsultarCreditoCommand command = new ConsultarCreditoCommand(CREDITO_ID);
        CreditoConsultado creditoConsultado = new CreditoConsultado();
        creditoConsultado.setAggregateRootId(CREDITO_ID);

        Mockito.when(repository.buscarPorIdNoReactivo(CREDITO_ID))
                .thenReturn(List.of(creditoConsultado));

        List<DomainEvent> result = useCase.apply(command);

        Assertions.assertEquals(command.getCreditoId(), result.get(0).aggregateRootId());

    }
}