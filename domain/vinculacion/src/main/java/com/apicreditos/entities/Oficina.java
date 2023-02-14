package com.apicreditos.entities;

import com.apicreditos.Entity;
import com.apicreditos.values.*;

public class Oficina extends Entity<OficinaId> {

    private Ubicacion ubicacion;
    private Direccion direccion;
    private Correo correo;
    private Telefono telefono;
    private HorarioAtencion horarioAtencion;

    public Oficina(OficinaId id, Ubicacion ubicacion, Direccion direccion, Correo correo, Telefono telefono, HorarioAtencion horarioAtencion) {
        super(id);
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.horarioAtencion = horarioAtencion;
    }

    public Ubicacion ubicacion() {
        return ubicacion;
    }

    public Direccion direccion() {
        return direccion;
    }

    public Correo correo() {
        return correo;
    }

    public Telefono telefono() {
        return telefono;
    }

    public HorarioAtencion horarioAtencion() {
        return horarioAtencion;
    }
}
