package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.command.ConsultarClienteCommand;
import com.apicreditos.events.ClienteConsultado;
import com.apicreditos.gateways.VinculacionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConsultarClienteUseCaseTest {

    @Mock
    private VinculacionRepository repository;

    private ConsultarClienteUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarClienteUseCase(repository);
    }

    @Test
    void apply() {

        String VINCULACION_ID = "vinculacion_id";

        ConsultarClienteCommand command = new ConsultarClienteCommand(VINCULACION_ID);

        ClienteConsultado clienteConsultado = new ClienteConsultado();
        clienteConsultado.setAggregateRootId(VINCULACION_ID);

        Mockito.when(repository.buscarPorIdNoReactivo(VINCULACION_ID))
                .thenReturn(List.of(clienteConsultado));

        List<DomainEvent> result = useCase.apply(command);
        Assertions.assertEquals(command.getVinculacionId(), result.get(0).aggregateRootId());

    }
}