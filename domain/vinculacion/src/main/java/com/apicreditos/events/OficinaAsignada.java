package com.apicreditos.events;

import com.apicreditos.DomainEvent;

public class OficinaAsignada extends DomainEvent {
    private final String idOficina;
    private final String idCliente;

    public OficinaAsignada(String idOficina, String idCliente) {
        super("");
        this.idOficina = idOficina;
        this.idCliente = idCliente;
    }

    public String getIdOficina() {
        return idOficina;
    }

    public String getIdCliente() {
        return idCliente;
    }

}
