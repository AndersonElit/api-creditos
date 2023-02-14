package com.apicreditos.events;

import com.apicreditos.DomainEvent;

import java.time.LocalDate;

public class VinculacionCreada extends DomainEvent {

    private final LocalDate fechaVinculacion;

    public VinculacionCreada(LocalDate fechaVinculacion) {
        super("VinculacionCreada");
        this.fechaVinculacion = fechaVinculacion;
    }

}
