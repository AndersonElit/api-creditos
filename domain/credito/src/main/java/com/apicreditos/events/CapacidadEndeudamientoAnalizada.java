package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.enums.EstadoCredito;

public class CapacidadEndeudamientoAnalizada extends DomainEvent {

    private final EstadoCredito estadoCredito;
    private final Double score;

    public CapacidadEndeudamientoAnalizada(EstadoCredito estadoCredito, Double score) {
        super("CapacidadEndeudamientoAnalizada");
        this.estadoCredito = estadoCredito;
        this.score = score;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

    public Double getScore() {
        return score;
    }

}
