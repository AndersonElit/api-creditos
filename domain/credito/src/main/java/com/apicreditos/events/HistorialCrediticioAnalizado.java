package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.enums.EstadoCredito;

public class HistorialCrediticioAnalizado extends DomainEvent {
    private final EstadoCredito estadoCredito;

    public HistorialCrediticioAnalizado(EstadoCredito estadoCredito) {
        super("HistorialCrediticioAnalizado");
        this.estadoCredito = estadoCredito;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

}
