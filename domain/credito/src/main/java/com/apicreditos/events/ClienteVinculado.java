package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.enums.EstadoCredito;
import com.apicreditos.values.VinculacionId;

public class ClienteVinculado extends DomainEvent {
    private final VinculacionId vinculacionId;
    private final EstadoCredito estadoCredito;

    public ClienteVinculado(VinculacionId vinculacionId, EstadoCredito estadoCredito) {
        super("ClienteVinculado");
        this.vinculacionId = vinculacionId;
        this.estadoCredito = estadoCredito;
    }

    public VinculacionId getVinculacionId() {
        return vinculacionId;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

}
