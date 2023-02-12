package com.apicreditos.events;

import com.apicreditos.DomainEvent;

public class CentralesDeRiesgoConsultadas extends DomainEvent {
    private final Double score;

    public CentralesDeRiesgoConsultadas(String type, Double score) {
        super(type);
        this.score = score;
    }

}
