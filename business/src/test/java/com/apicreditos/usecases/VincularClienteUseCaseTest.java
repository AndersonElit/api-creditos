package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.command.VincularClienteCommand;
import com.apicreditos.entities.Asesor;
import com.apicreditos.entities.Cliente;
import com.apicreditos.entities.Oficina;
import com.apicreditos.events.VinculacionCreada;
import com.apicreditos.gateways.VinculacionRepository;
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
class VincularClienteUseCaseTest {

    @Mock
    private VinculacionRepository repository;

    private VincularClienteUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new VincularClienteUseCase(repository);
    }

    @Test
    void apply() {

        VincularClienteCommand command = new VincularClienteCommand("123456789", new Cliente(new UsuarioId("12345")),
                new Asesor(new UsuarioId("6789")), new Oficina(new OficinaId("98765")));

        VinculacionCreada event = new VinculacionCreada(new Cliente(new UsuarioId("12345")), new Asesor(new UsuarioId("6789")),
                new Oficina(new OficinaId("98765")));
        event.setAggregateRootId("123456789");

        Mockito.when(repository.vincularClienteNoReactivo(ArgumentMatchers.any(VinculacionCreada.class)))
                .thenAnswer(invocationOnMock -> {
                    return  invocationOnMock.getArgument(0);
                });

        List<DomainEvent> result = useCase.apply(command);

        Assertions.assertEquals(event.aggregateRootId(), result.get(0).aggregateRootId());

    }
}