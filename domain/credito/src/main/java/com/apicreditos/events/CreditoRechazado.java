package com.apicreditos.events;

import com.apicreditos.DomainEvent;

public class CreditoRechazado extends DomainEvent {
    private final String clienteId;
    private final String asesorId;
    private final Double score;

    public CreditoRechazado(String type, String clienteId, String asesorId, Double score) {
        super(type);
        this.clienteId = clienteId;
        this.asesorId = asesorId;
        this.score = score;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getAsesorId() {
        return asesorId;
    }

    public Double getScore() {
        return score;
    }
}
