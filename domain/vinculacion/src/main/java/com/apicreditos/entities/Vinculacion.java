package com.apicreditos.entities;

import com.apicreditos.AggregateEvent;
import com.apicreditos.events.AsesorAsignado;
import com.apicreditos.events.ClienteCreado;
import com.apicreditos.events.OficinaAsignada;
import com.apicreditos.events.VinculacionCreada;
import com.apicreditos.values.VinculacionId;

import java.time.LocalDate;

public class Vinculacion extends AggregateEvent<VinculacionId> {
    protected Cliente cliente;
    protected Asesor asesor;
    protected Oficina oficina;
    protected LocalDate fechaViculacion;

    public Vinculacion(VinculacionId entityId, Cliente cliente, Asesor asesor, Oficina oficina) {
        super(entityId);
        subscribe(new VinculacionEventChange(this));
        appendChange(new VinculacionCreada(this.fechaViculacion)).apply();
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

    public void crearCliente(Cliente cliente) {
        appendChange(new ClienteCreado(cliente)).apply();
    }

    public void asignarAsesor(Asesor asesor) {
        appendChange(new AsesorAsignado(asesor)).apply();
    }

    public void asignarOficina(Oficina oficina) {
        appendChange(new OficinaAsignada(oficina)).apply();
    }

}
