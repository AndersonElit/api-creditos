package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Asesor;

public class AsesorAsignado extends DomainEvent {
    private final Asesor asesor;

    public AsesorAsignado(Asesor asesor) {
        super("AsesorAsignado");
        this.asesor = asesor;
    }

    public Asesor getAsesor() {
        return asesor;
    }

}
