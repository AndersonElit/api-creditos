package com.apicreditos.values;

import com.apicreditos.ValueObject;

public class Nombre implements ValueObject<Nombre.Props> {

    private final String primerNombre;
    private final String segundoNombre;
    private final String primerApellido;
    private final String segundoApellido;

    public Nombre(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String primerNombre() {
                return primerNombre;
            }

            @Override
            public String segundoNombre() {
                return segundoNombre;
            }

            @Override
            public String primerApellido() {
                return primerApellido;
            }

            @Override
            public String segundoApellido() {
                return segundoApellido;
            }
        };
    }

    public interface Props {
        String primerNombre();
        String segundoNombre();
        String primerApellido();
        String segundoApellido();
    }

}
