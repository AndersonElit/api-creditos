package com.apicreditos.events;

import com.apicreditos.DomainEvent;

import java.time.LocalDate;

public class CreditoCreado extends DomainEvent {

    private final LocalDate fechaCreacion;

    public CreditoCreado(LocalDate fechaCreacion) {
        super("CreditoCreado");
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

}
