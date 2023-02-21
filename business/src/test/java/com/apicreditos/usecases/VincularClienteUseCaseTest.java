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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

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

        String ID_VINCULACION = "id-vinculacion";
        String ID_CLIENTE = "id-cliente";
        String ID_ASESOR = "id-asesor";
        String ID_OFICINA = "id-oficina";

        VincularClienteCommand command = new VincularClienteCommand(ID_VINCULACION, new Cliente(new UsuarioId(ID_CLIENTE)),
                new Asesor(new UsuarioId(ID_ASESOR)), new Oficina(new OficinaId(ID_OFICINA)));

        VinculacionCreada event = new VinculacionCreada();
        event.setAggregateRootId(ID_VINCULACION);

        Mockito.when(repository.saveEvent(ArgumentMatchers.any()))
                .thenAnswer(invocationOnMock -> Mono.just(invocationOnMock.getArgument(0)));

        Flux<DomainEvent> flux = useCase.apply(Mono.just(command));

        StepVerifier.create(flux)
                .expectNextCount(4)
                .verifyComplete();

    }
}