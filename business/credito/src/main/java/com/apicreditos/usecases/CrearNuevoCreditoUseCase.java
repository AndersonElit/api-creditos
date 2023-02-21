package com.apicreditos.usecases;

import com.apicreditos.DomainEvent;
import com.apicreditos.UseCaseForCommand;
import com.apicreditos.command.CrearNuevoCreditoCommand;
import com.apicreditos.entities.Credito;
import com.apicreditos.gateways.CreditoRepository;
import com.apicreditos.values.CreditoId;
import com.apicreditos.values.VinculacionId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CrearNuevoCreditoUseCase extends UseCaseForCommand<CrearNuevoCreditoCommand> {

    private final CreditoRepository repository;

    public CrearNuevoCreditoUseCase(CreditoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(Mono<CrearNuevoCreditoCommand> crearNuevoCreditoCommandMono) {

        return crearNuevoCreditoCommandMono.flatMapIterable(command -> {
            Credito credito = new Credito(
                    CreditoId.of(command.getCreditoId()),
                    VinculacionId.of(command.getVinculacionId()),
                    command.getEstadoCredito()
            );
            credito.vincularCliente(VinculacionId.of(command.getVinculacionId()));
            credito.analizarHistorialCrediticio();
            credito.capacidadEndeudamiento();
            credito.valorPatrimonio();
            credito.consultaCentralesDeRiesgo();
            credito.calcularScore();
            return credito.getUncommittedChanges();
        }).flatMap(event -> repository.saveEvent(event));

    }
}
