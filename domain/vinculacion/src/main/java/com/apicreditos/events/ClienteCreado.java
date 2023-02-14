package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Cliente;

import java.time.LocalDate;

public class ClienteCreado extends DomainEvent {

    private final Cliente cliente;
    private final LocalDate fechaVinculacion;

    public ClienteCreado(Cliente cliente, LocalDate fechaVinculacion) {
        super("ClienteCreado");
        this.cliente = cliente;
        this.fechaVinculacion = fechaVinculacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaVinculacion() {
        return fechaVinculacion;
    }

}
