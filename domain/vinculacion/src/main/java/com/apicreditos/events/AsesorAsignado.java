package com.apicreditos.events;

import com.apicreditos.DomainEvent;

public class AsesorAsignado extends DomainEvent {
    private final String IdAsesor;
    private final String idCliente;

    public AsesorAsignado( String idAsesor, String idCliente) {
        super("");
        IdAsesor = idAsesor;
        this.idCliente = idCliente;
    }

    public String getIdAsesor() {
        return IdAsesor;
    }

    public String getIdCliente() {
        return idCliente;
    }

}
