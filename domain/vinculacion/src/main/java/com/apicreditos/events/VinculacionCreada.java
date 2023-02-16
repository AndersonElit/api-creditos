package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Asesor;
import com.apicreditos.entities.Cliente;
import com.apicreditos.entities.Oficina;

import java.time.LocalDate;

public class VinculacionCreada extends DomainEvent {

    private final Cliente cliente;
    private final Asesor asesor;
    private final Oficina oficina;

    public VinculacionCreada(Cliente cliente, Asesor asesor, Oficina oficina) {
        super("VinculacionCreada");
        this.cliente = cliente;
        this.asesor = asesor;
        this.oficina = oficina;
    }



    public Cliente getCliente() {
        return cliente;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public Oficina getOficina() {
        return oficina;
    }
}
