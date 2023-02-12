package com.apicreditos.values;

import com.apicreditos.enums.TipoTrabajo;
import com.apicreditos.ValueObject;

public class InformacionFinanciera implements ValueObject<InformacionFinanciera.Props> {
    private final DatosBancarios datosBancarios;
    private final TipoTrabajo tipoTrabajo;
    private final Long sueldo;

    public InformacionFinanciera(DatosBancarios datosBancarios, TipoTrabajo tipoTrabajo, Long sueldo) {
        this.datosBancarios = datosBancarios;
        this.tipoTrabajo = tipoTrabajo;
        this.sueldo = sueldo;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public DatosBancarios datosBancarios() {
                return datosBancarios;
            }

            @Override
            public TipoTrabajo tipoTrabajo() {
                return tipoTrabajo;
            }

            @Override
            public Long sueldo() {
                return sueldo;
            }
        };
    }

    public interface Props {
        DatosBancarios datosBancarios();
        TipoTrabajo tipoTrabajo();
        Long sueldo();
    }

}
