package com.apicreditos.usecases.vinculacion;

import com.apicreditos.DomainEvent;
import com.apicreditos.command.VincularClienteCommand;
import com.apicreditos.entities.Asesor;
import com.apicreditos.entities.Cliente;
import com.apicreditos.entities.Oficina;
import com.apicreditos.events.VinculacionCreada;
import com.apicreditos.gateways.VinculacionRepositoryNoReactivo;
import com.apicreditos.usecases.VincularClienteUseCaseNoReactivo;
import com.apicreditos.values.OficinaId;
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
class VincularClienteUseCaseNoReactivoTest {

    @Mock
    private VinculacionRepositoryNoReactivo repository;

    private VincularClienteUseCaseNoReactivo useCase;

    @BeforeEach
    void setUp() {
        useCase = new VincularClienteUseCaseNoReactivo(repository);
    }

    @Test
    void apply() {

        String ID_VINCULACION = "id-vinculacion";
        String ID_CLIENTE = "id-cliente";
        String ID_ASESOR = "id-asesor";
        String ID_OFICINA = "id-oficina";

        VincularClienteCommand command = new VincularClienteCommand(ID_VINCULACION, new Cliente(new UsuarioId(ID_CLIENTE)),
                new Asesor(new UsuarioId(ID_ASESOR)), new Oficina(new OficinaId(ID_OFICINA)));

        VinculacionCreada event = new VinculacionCreada();
        event.setAggregateRootId(ID_VINCULACION);

        Mockito.when(repository.vincularClienteNoReactivo(ArgumentMatchers.any()))
                .thenAnswer(invocationOnMock -> {
                    return  invocationOnMock.getArgument(0);
                });

        List<DomainEvent> result = useCase.apply(command);

        Assertions.assertEquals(event.aggregateRootId(), result.get(0).aggregateRootId());

    }
}