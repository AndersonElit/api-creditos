package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Cliente;
import com.apicreditos.enums.EstadoCredito;
import com.apicreditos.values.VinculacionId;

public class ClienteVinculado extends DomainEvent {
    private VinculacionId vinculacionId;
    private EstadoCredito estadoCredito;
    private Cliente cliente;

    public ClienteVinculado(VinculacionId vinculacionId, EstadoCredito estadoCredito, Cliente cliente) {
        super("ClienteVinculado");
        this.vinculacionId = vinculacionId;
        this.estadoCredito = estadoCredito;
        this.cliente = cliente;
    }

    public ClienteVinculado( VinculacionId vinculacionId, EstadoCredito estadoCredito) {
        super("ClienteVinculado");
        this.vinculacionId = vinculacionId;
        this.estadoCredito = estadoCredito;
    }

    public VinculacionId getVinculacionId() {
        return vinculacionId;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
