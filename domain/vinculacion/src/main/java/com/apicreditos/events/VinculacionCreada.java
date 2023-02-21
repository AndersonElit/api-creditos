package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Asesor;
import com.apicreditos.entities.Cliente;
import com.apicreditos.entities.Oficina;

import java.time.LocalDate;

public class VinculacionCreada extends DomainEvent {

    private String vinculacionId;

    public VinculacionCreada() {
        super("VinculacionCreada");
    }

    public VinculacionCreada(String vinculacionId) {
        super("VinculacionCreada");
        this.vinculacionId = vinculacionId;
    }

    public String getVinculacionId() {
        return vinculacionId;
    }

}
