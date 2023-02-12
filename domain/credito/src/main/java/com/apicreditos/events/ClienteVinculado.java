package com.apicreditos.events;

import com.apicreditos.DomainEvent;

public class ClienteVinculado extends DomainEvent {
    private final String vinculacionId;
    private final String clienteId;

    public ClienteVinculado(String type, String vinculacionId, String clienteId) {
        super(type);
        this.vinculacionId = vinculacionId;
        this.clienteId = clienteId;
    }

    public String getVinculacionId() {
        return vinculacionId;
    }

    public String getClienteId() {
        return clienteId;
    }

}
