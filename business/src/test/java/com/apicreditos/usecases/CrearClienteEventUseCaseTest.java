package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Cliente;
import com.apicreditos.events.ClienteCreado;
import com.apicreditos.events.VinculacionCreada;
import com.apicreditos.gateways.VinculacionRepository;
import com.apicreditos.values.UsuarioId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearClienteEventUseCaseTest {

    @Mock
    private VinculacionRepository repository;

    private CrearClienteEventUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CrearClienteEventUseCase(repository);
    }

    @Test
    void apply() {

        String ID_AGREGADO = "id-agregado";
        String ID_VINCULACION = "id-vinculacion";
        String ID_CLIENTE = "id-cliente";
        Cliente cliente = new Cliente(UsuarioId.of(ID_CLIENTE));

        VinculacionCreada event = new VinculacionCreada(ID_VINCULACION, new Cliente(UsuarioId.of(ID_CLIENTE)));
        event.setAggregateRootId(ID_AGREGADO);

        ClienteCreado clienteCreado = new ClienteCreado(cliente);
        clienteCreado.setAggregateRootId(ID_VINCULACION);

        Mockito.when(repository.findById(ID_VINCULACION)).thenReturn(Flux.just(clienteCreado));

        Mockito.when(repository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArgument(0)));

        Flux<DomainEvent> result = useCase.apply(Mono.just(event));

        StepVerifier.create(result)
                .expectNextMatches(u -> {
                    ClienteCreado u1 = (ClienteCreado) u;
                    Assertions.assertEquals(u1.aggregateRootId(), event.aggregateRootId());
                    return u.aggregateRootId().equals(event.aggregateRootId());
                })
                //.expectNextCount(1)
                .verifyComplete();

    }
}