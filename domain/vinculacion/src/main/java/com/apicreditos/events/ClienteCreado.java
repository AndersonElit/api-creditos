package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Cliente;

import java.time.LocalDate;

public class ClienteCreado extends DomainEvent {

    private final Cliente cliente;

    public ClienteCreado(Cliente cliente) {
        super("ClienteCreado");
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
