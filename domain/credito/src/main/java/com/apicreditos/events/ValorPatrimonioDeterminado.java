package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.enums.EstadoCredito;

public class ValorPatrimonioDeterminado extends DomainEvent {

    private final EstadoCredito estadoCredito;
    private final Double score;

    public ValorPatrimonioDeterminado(EstadoCredito estadoCredito, Double score) {
        super("ValorPatrimonioDeterminado");
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
