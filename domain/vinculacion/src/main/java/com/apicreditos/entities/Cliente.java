package com.apicreditos.entities;

import com.apicreditos.enums.Estado;
import com.apicreditos.values.*;

public class Cliente extends Usuario {

    private InformacionFinanciera informacionFinanciera;

    public Cliente(UsuarioId id, InformacionBasica informacionBasica, InformacionDemografica informacionDemografica,
                   InformacionAdicional informacionAdicional, Contacto contacto, Estado estado, InformacionFinanciera informacionFinanciera) {
        super(id, informacionBasica, informacionDemografica, informacionAdicional, contacto, estado);
        this.informacionFinanciera = informacionFinanciera;
    }

    public Cliente(UsuarioId id) {
        super(id);
    }

    public InformacionFinanciera informacionFinanciera() {
        return informacionFinanciera;
    }
}
