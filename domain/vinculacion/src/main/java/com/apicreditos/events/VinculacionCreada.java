package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Asesor;
import com.apicreditos.entities.Cliente;
import com.apicreditos.entities.Oficina;

import java.time.LocalDate;

public class VinculacionCreada extends DomainEvent {

    private String vinculacionId;
    private Cliente cliente;

    public VinculacionCreada() {
        super("VinculacionCreada");
    }

    public VinculacionCreada(String vinculacionId, Cliente cliente) {
        super("VinculacionCreada");
        this.vinculacionId = vinculacionId;
        this.cliente = cliente;
    }

    public String getVinculacionId() {
        return vinculacionId;
    }
    public Cliente getCliente() {
        return cliente;
    }

}
