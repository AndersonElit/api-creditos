package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.enums.EstadoCredito;

public class CapacidadEndeudamientoAnalizada extends DomainEvent {

    private final EstadoCredito estadoCredito;

    public CapacidadEndeudamientoAnalizada(EstadoCredito estadoCredito) {
        super("CapacidadEndeudamientoAnalizada");
        this.estadoCredito = estadoCredito;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

}
