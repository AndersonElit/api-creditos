package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Oficina;

public class OficinaAsignada extends DomainEvent {

    private final Oficina oficina;

    public OficinaAsignada(Oficina oficina) {
        super("OficinaAsignada");
        this.oficina = oficina;
    }

    public Oficina getOficina() {
        return oficina;
    }

}
