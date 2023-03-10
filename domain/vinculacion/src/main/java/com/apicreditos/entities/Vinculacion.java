package com.apicreditos.entities;

import com.apicreditos.AggregateEvent;
import com.apicreditos.DomainEvent;
import com.apicreditos.events.*;
import com.apicreditos.values.VinculacionId;

import java.time.LocalDate;
import java.util.List;

public class Vinculacion extends AggregateEvent<VinculacionId> {
    protected Cliente cliente;
    protected Asesor asesor;
    protected Oficina oficina;
    protected LocalDate fechaViculacion;

    public Vinculacion(VinculacionId id) {
        super(id);
        subscribe(new VinculacionEventChange(this));
        appendChange(new VinculacionCreada()).apply();
    }

    public static Vinculacion from(VinculacionId vinculacionId, List<DomainEvent> events) {
        var vinculacion = new Vinculacion(vinculacionId);
        events.forEach(vinculacion::applyEvent);
        return vinculacion;
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

    public void consultarCliente() {
        appendChange(new ClienteConsultado()).apply();
    }

}
