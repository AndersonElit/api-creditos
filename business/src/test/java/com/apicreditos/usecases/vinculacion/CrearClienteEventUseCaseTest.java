package com.apicreditos.usecases.vinculacion;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Cliente;
import com.apicreditos.enums.EstadoCredito;
import com.apicreditos.events.ClienteCreado;
import com.apicreditos.events.ClienteVinculado;
import com.apicreditos.events.VinculacionCreada;
import com.apicreditos.gateways.VinculacionRepository;
import com.apicreditos.usecases.CrearClienteEventUseCase;
import com.apicreditos.values.UsuarioId;
import com.apicreditos.values.VinculacionId;
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

        ClienteVinculado event = new ClienteVinculado(VinculacionId.of(ID_VINCULACION), EstadoCredito.INICIO, cliente);

        event.setAggregateRootId(ID_AGREGADO);

        Mockito.when(repository.saveEvent(ArgumentMatchers.any()))
                .thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArgument(0)));

        Flux<DomainEvent> result = useCase.apply(Mono.just(event));

        StepVerifier.create(result)
                .expectNextCount(2)
                .verifyComplete();

    }
}