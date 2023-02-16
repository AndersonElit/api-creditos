package com.apicreditos.entities;

import com.apicreditos.EventChange;
import com.apicreditos.events.AsesorAsignado;
import com.apicreditos.events.ClienteCreado;
import com.apicreditos.events.OficinaAsignada;
import com.apicreditos.events.VinculacionCreada;

import java.time.LocalDate;

public class VinculacionEventChange extends EventChange {

    public VinculacionEventChange(Vinculacion vinculacion) {
        apply((VinculacionCreada event) -> {
            vinculacion.fechaViculacion = LocalDate.now();
            vinculacion.cliente = event.getCliente();
            vinculacion.asesor = event.getAsesor();
            vinculacion.oficina = event.getOficina();
        });
        apply((ClienteCreado event) -> {
            vinculacion.cliente = event.getCliente();
        });
        apply((AsesorAsignado event) -> {
            vinculacion.asesor = event.getAsesor();
        });
        apply((OficinaAsignada event) -> {
            vinculacion.oficina = event.getOficina();
        });
    }
}
