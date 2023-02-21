package com.apicreditos.usecases.vinculacion;

import com.apicreditos.DomainEvent;
import com.apicreditos.command.ConsultarClienteCommand;
import com.apicreditos.events.ClienteConsultado;
import com.apicreditos.gateways.VinculacionRepository;
import com.apicreditos.usecases.ConsultarClienteUseCase;
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

        Mockito.when(repository.findById(VINCULACION_ID))
                .thenReturn(Flux.just(clienteConsultado));

        Mockito.when(repository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArgument(0)));

        Flux<DomainEvent> flux = useCase.apply(Mono.just(command));

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

    }
}