package com.apicreditos.events;

import com.apicreditos.DomainEvent;

public class ValorPatrimonioDeterminado extends DomainEvent {

    private final Double score;

    public ValorPatrimonioDeterminado(String type, Double score) {
        super(type);
        this.score = score;
    }
}
