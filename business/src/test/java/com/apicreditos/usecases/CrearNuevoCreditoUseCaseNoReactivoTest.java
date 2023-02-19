package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.command.CrearNuevoCreditoCommand;
import com.apicreditos.enums.EstadoCredito;
import com.apicreditos.events.CreditoCreado;
import com.apicreditos.gateways.CreditoRepositoryNoReactivo;
import com.apicreditos.values.InformacionCreditoAprobado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CrearNuevoCreditoUseCaseNoReactivoTest {

    @Mock
    private CreditoRepositoryNoReactivo repository;

    private CrearNuevoCreditoUseCaseNoReactivo useCase;

    @BeforeEach
    void setUp() {
        useCase = new CrearNuevoCreditoUseCaseNoReactivo(repository);
    }

    @Test
    void apply() {

        String ID_CREDITO = "id-credito";
        String ID_VINCULACION = "id-vinculacion";

        CrearNuevoCreditoCommand command = new CrearNuevoCreditoCommand(ID_CREDITO, ID_VINCULACION, new InformacionCreditoAprobado(),
                EstadoCredito.INICIO);

        CreditoCreado event = new CreditoCreado();
        event.setAggregateRootId(ID_CREDITO);

        Mockito.when(repository.crearNuevoCreditoNoReactivo(ArgumentMatchers.any(CreditoCreado.class)))
                .thenAnswer(invocationOnMock -> {
                    return invocationOnMock.getArgument(0);
                });

        List<DomainEvent> result = useCase.apply(command);

        Assertions.assertEquals(event.aggregateRootId(), result.get(0).aggregateRootId());

    }
}