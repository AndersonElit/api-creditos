package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.enums.EstadoCredito;

public class CentralesDeRiesgoConsultadas extends DomainEvent {

    private final EstadoCredito estadoCredito;

    public CentralesDeRiesgoConsultadas(EstadoCredito estadoCredito) {
        super("CentralesDeRiesgoConsultadas");
        this.estadoCredito = estadoCredito;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

}
