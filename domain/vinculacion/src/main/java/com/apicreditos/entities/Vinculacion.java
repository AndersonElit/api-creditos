package com.apicreditos.entities;

import com.apicreditos.AggregateRoot;
import com.apicreditos.values.VinculacionId;

public class Vinculacion extends AggregateRoot<VinculacionId> {
    protected Cliente cliente;
    protected Asesor asesor;

    public Vinculacion(VinculacionId id, Cliente cliente, Asesor asesor) {
        super(id);
        this.cliente = cliente;
        this.asesor = asesor;
    }

    private Vinculacion(VinculacionId id) {
        super(id);
    }

}
