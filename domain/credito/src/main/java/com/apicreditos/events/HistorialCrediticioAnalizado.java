package com.apicreditos.events;

import com.apicreditos.DomainEvent;

public class HistorialCrediticioAnalizado extends DomainEvent {
    private final String clienteId;
    private final Double score;

    public HistorialCrediticioAnalizado(String type, String clienteId, Double score) {
        super(type);
        this.clienteId = clienteId;
        this.score = score;
    }

    public String getClienteId() {
        return clienteId;
    }

    public Double getScore() {
        return score;
    }

}
