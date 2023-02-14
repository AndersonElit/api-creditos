package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.enums.EstadoCredito;

public class ValorPatrimonioDeterminado extends DomainEvent {

    private final EstadoCredito estadoCredito;

    public ValorPatrimonioDeterminado(EstadoCredito estadoCredito) {
        super("ValorPatrimonioDeterminado");
        this.estadoCredito = estadoCredito;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

}
