package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Asesor;
import com.apicreditos.entities.Cliente;
import com.apicreditos.entities.Oficina;

import java.time.LocalDate;

public class VinculacionCreada extends DomainEvent {

    public VinculacionCreada() {
        super("VinculacionCreada");
    }

}
