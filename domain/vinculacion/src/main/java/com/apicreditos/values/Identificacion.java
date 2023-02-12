package com.apicreditos.values;

import com.apicreditos.enums.TipoIdentificacion;
import com.apicreditos.ValueObject;

public class Identificacion implements ValueObject<Identificacion.Props> {
    private TipoIdentificacion tipoIdentificacion;
    private String numeroIdentificacion;

    @Override
    public Props value() {
        return new Props() {
            @Override
            public TipoIdentificacion tipoIdentificacion() {
                return tipoIdentificacion;
            }

            @Override
            public String numeroIdentificacion() {
                return numeroIdentificacion;
            }
        };
    }


    public interface Props {
        TipoIdentificacion tipoIdentificacion();
        String numeroIdentificacion();
    }

}
