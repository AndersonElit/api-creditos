package com.apicreditos.events;

import com.apicreditos.DomainEvent;

public class CapacidadEndeudamientoAnalizada extends DomainEvent {

    private final Double score;

    public CapacidadEndeudamientoAnalizada(String type, Double score) {
        super(type);
        this.score = score;
    }

}
