package com.apicreditos.events;

import com.apicreditos.DomainEvent;

public class ScoreCalculado extends DomainEvent {
    private final Double score;

    public ScoreCalculado(String type, Double score) {
        super(type);
        this.score = score;
    }

    public Double getScore() {
        return score;
    }

}
