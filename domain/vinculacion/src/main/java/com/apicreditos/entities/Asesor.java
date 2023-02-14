package com.apicreditos.entities;

import com.apicreditos.enums.Estado;
import com.apicreditos.values.*;

public class Asesor extends Usuario {

    private Contrato contrato;

    public Asesor(UsuarioId id, InformacionBasica informacionBasica, InformacionDemografica informacionDemografica, InformacionAdicional informacionAdicional,
                  Contacto contacto, Estado estado, Contrato contrato) {
        super(id, informacionBasica, informacionDemografica, informacionAdicional, contacto, estado);
        this.contrato = contrato;
    }

    public Asesor(UsuarioId id) {
        super(id);
    }
}
