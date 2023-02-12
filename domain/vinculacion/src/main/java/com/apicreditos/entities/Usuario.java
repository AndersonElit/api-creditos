package com.apicreditos.entities;

import com.apicreditos.enums.Estado;
import com.apicreditos.Entity;
import com.apicreditos.values.*;

public class Usuario extends Entity<UsuarioId> {

    private InformacionBasica informacionBasica;
    private InformacionDemografica informacionDemografica;
    private InformacionAdicional informacionAdicional;
    private Contacto contacto;
    private Estado estado;

    public Usuario(UsuarioId id, InformacionBasica informacionBasica, InformacionDemografica informacionDemografica, InformacionAdicional informacionAdicional, Contacto contacto, Estado estado) {
        super(id);
        this.informacionBasica = informacionBasica;
        this.informacionDemografica = informacionDemografica;
        this.informacionAdicional = informacionAdicional;
        this.contacto = contacto;
        this.estado = estado;
    }

    public InformacionBasica informacionBasica() {
        return informacionBasica;
    }
    public InformacionDemografica informacionDemografica() {
        return informacionDemografica;
    }
    public InformacionAdicional informacionAdicional() {
        return informacionAdicional;
    }

    public Contacto contacto() {
        return contacto;
    }

    public void editarInformacionBasica(InformacionBasica informacionBasica) {
        this.informacionBasica= informacionBasica;
    }

    public void editarInformacionDemografica(InformacionDemografica informacionDemografica) {
        this.informacionDemografica = informacionDemografica;
    }

    public void editarInformacionAdicional(InformacionAdicional informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public void editarContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public void cambiarEstadoActivo() {
        this.estado = Estado.ACTIVO;
    }

    public void cambiarEstadoInactivo() {
        this.estado = Estado.INACTIVO;
    }

}
