package com.apicreditos.entities;

import com.apicreditos.AggregateEvent;
import com.apicreditos.AggregateRoot;
import com.apicreditos.values.VinculacionId;

import java.time.LocalDate;

public class Vinculacion extends AggregateEvent<VinculacionId> {
    protected Cliente cliente;
    protected Asesor asesor;
    protected Oficina oficina;
    protected LocalDate fechaViculacion;

    public Vinculacion(VinculacionId entityId, Cliente cliente, Asesor asesor, Oficina oficina, LocalDate fechaViculacion) {
        super(entityId);
        this.cliente = cliente;
        this.asesor = asesor;
        this.oficina = oficina;
        this.fechaViculacion = fechaViculacion;
        crearCliente(cliente);
        asignarAsesor(asesor);
        asignarOficina(oficina);
    }

    public Vinculacion(VinculacionId entityId, Cliente cliente, LocalDate fechaViculacion) {
        super(entityId);
        this.cliente = cliente;
        this.fechaViculacion = fechaViculacion;
    }

    public Vinculacion(VinculacionId id) {
        super(id);
    }

    public Vinculacion(VinculacionId entityId, Asesor asesor) {
        super(entityId);
        this.asesor = asesor;
    }

    private void crearCliente(Cliente cliente) {

    }

    private void asignarAsesor(Asesor asesor) {

    }

    private void asignarOficina(Oficina oficina) {

    }

}
