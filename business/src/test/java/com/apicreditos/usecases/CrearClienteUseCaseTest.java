package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.command.CrearClienteCommand;
import com.apicreditos.entities.Cliente;
import com.apicreditos.events.ClienteCreado;
import com.apicreditos.gateways.VinculacionRepositoryNoReactivo;
import com.apicreditos.values.UsuarioId;
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
class CrearClienteUseCaseTest {

    @Mock
    private VinculacionRepositoryNoReactivo repository;

    private CrearClienteUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CrearClienteUseCase(repository);
    }

    @Test
    void apply() {
        String ID_VINCULACION = "id-vinculacion";
        String ID_CLIENTE = "id-cliente";
        Cliente cliente = new Cliente(UsuarioId.of(ID_CLIENTE));

        CrearClienteCommand command = new CrearClienteCommand(ID_VINCULACION, cliente);

        ClienteCreado clienteCreado = new ClienteCreado(cliente);
        clienteCreado.setAggregateRootId(ID_VINCULACION);

        /*Mockito.when(repository.buscarPorIdNoReactivo(ID_VINCULACION))
                .thenReturn(List.of(clienteCreado));*/

        Mockito.when(repository.vincularClienteNoReactivo(ArgumentMatchers.any(ClienteCreado.class)))
                .thenAnswer(interceptor -> {
                    return interceptor.getArgument(0);
                });

        List<DomainEvent> result = useCase.apply(command);

        Assertions.assertEquals(command.getVinculacionId(), result.get(0).aggregateRootId());
        Assertions.assertInstanceOf(ClienteCreado.class, result.get(0));

    }
}