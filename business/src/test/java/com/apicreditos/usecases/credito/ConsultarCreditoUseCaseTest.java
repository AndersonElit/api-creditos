package com.apicreditos.usecases.credito;

import com.apicreditos.DomainEvent;
import com.apicreditos.command.ConsultarCreditoCommand;
import com.apicreditos.events.CreditoConsultado;
import com.apicreditos.gateways.CreditoRepository;
import com.apicreditos.usecases.ConsultarCreditoUseCase;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConsultarCreditoUseCaseTest {

    @Mock
    private CreditoRepository repository;

    private ConsultarCreditoUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarCreditoUseCase(repository);
    }

    @Test
    void apply() {

        String CREDITO_ID = "credito_id";
        ConsultarCreditoCommand command = new ConsultarCreditoCommand(CREDITO_ID);
        CreditoConsultado creditoConsultado = new CreditoConsultado();
        creditoConsultado.setAggregateRootId(CREDITO_ID);

        Mockito.when(repository.findById(CREDITO_ID))
                .thenReturn(Flux.just(creditoConsultado));

        Mockito.when(repository.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArgument(0)));

        Flux<DomainEvent> flux = useCase.apply(Mono.just(command));

        StepVerifier.create(flux)
                .expectNextCount(1)
                .verifyComplete();

    }
}