package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.command.CrearNuevoCreditoCommand;
import com.apicreditos.enums.EstadoCredito;
import com.apicreditos.events.CreditoCreado;
import com.apicreditos.gateways.CreditoRepository;
import com.apicreditos.values.InformacionCreditoAprobado;
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

@ExtendWith(MockitoExtension.class)
class CrearNuevoCreditoUseCaseTest {

    @Mock
    private CreditoRepository repository;

    private CrearNuevoCreditoUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CrearNuevoCreditoUseCase(repository);
    }

    @Test
    void apply() {
        String ID_CREDITO = "id-credito";
        String ID_VINCULACION = "id-vinculacion";

        CrearNuevoCreditoCommand command = new CrearNuevoCreditoCommand(ID_CREDITO, ID_VINCULACION, new InformacionCreditoAprobado(),
                EstadoCredito.INICIO);

        CreditoCreado event = new CreditoCreado();
        event.setAggregateRootId(ID_CREDITO);

        Mockito.when(repository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArgument(0)));

        Flux<DomainEvent> flux = useCase.apply(Mono.just(command));

        StepVerifier.create(flux)
                .expectNextCount(1)
                /*.expectNextMatches(u -> {
                    CreditoCreado c = (CreditoCreado) u;
                    Assertions.assertEquals(c.aggregateRootId(), event.aggregateRootId());
                    return u.aggregateRootId().equals(event.aggregateRootId());
                })*/
                .verifyComplete();

    }
}