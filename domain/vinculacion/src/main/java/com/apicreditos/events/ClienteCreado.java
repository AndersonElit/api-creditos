package com.apicreditos.events;

import com.apicreditos.DomainEvent;

public class ClienteCreado extends DomainEvent {

    private final String idCliente;

    public ClienteCreado(String idCliente) {
        super("");
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

}
