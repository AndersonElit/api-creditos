package com.apicreditos.entities;

import com.apicreditos.AggregateRoot;
import com.apicreditos.values.VinculacionId;

public class Vinculacion extends AggregateRoot<VinculacionId> {
    protected Cliente cliente;
    protected Asesor asesor;
    protected Oficina oficina;

    public Vinculacion(VinculacionId id, Cliente cliente, Asesor asesor, Oficina oficina) {
        super(id);
        this.cliente = cliente;
        this.asesor = asesor;
        this.oficina = oficina;
        crearCliente(cliente);
        asignarAsesor(asesor);
        asignarOficina(oficina);
    }

    private Vinculacion(VinculacionId id) {
        super(id);
    }

    private void crearCliente(Cliente cliente) {

    }

    private void asignarAsesor(Asesor asesor) {

    }

    private void asignarOficina(Oficina oficina) {

    }

}
