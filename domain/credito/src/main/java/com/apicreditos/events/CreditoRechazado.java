package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.enums.EstadoCredito;

public class CreditoRechazado extends DomainEvent {
    private final EstadoCredito estadoCredito;
    private final Double score;

    public CreditoRechazado(EstadoCredito estadoCredito, Double score) {
        super("CreditoRechazado");
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
