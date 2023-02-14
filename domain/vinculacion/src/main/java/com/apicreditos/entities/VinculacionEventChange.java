package com.apicreditos.entities;

import com.apicreditos.EventChange;
import com.apicreditos.events.AsesorAsignado;
import com.apicreditos.events.ClienteCreado;
import com.apicreditos.events.OficinaAsignada;

public class VinculacionEventChange extends EventChange {

    public VinculacionEventChange(Vinculacion vinculacion) {
        apply((ClienteCreado event) -> {
            vinculacion.cliente = event.getCliente();
            vinculacion.fechaViculacion = event.getFechaVinculacion();
        });
        apply((AsesorAsignado event) -> {
            vinculacion.asesor = event.getAsesor();
        });
        apply((OficinaAsignada event) -> {
            vinculacion.oficina = event.getOficina();
        });
    }
}
