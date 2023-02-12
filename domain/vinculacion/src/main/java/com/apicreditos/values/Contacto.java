package com.apicreditos.values;

import com.apicreditos.ValueObject;

public class Contacto implements ValueObject<Contacto.Props> {
    private final Correo correo;
    private final Celular celular;

    public Contacto(Correo correo, Celular celular) {
        this.correo = correo;
        this.celular = celular;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Correo correo() {
                return correo;
            }

            @Override
            public Celular celular() {
                return celular;
            }
        };
    }


    public interface Props {
        Correo correo();
        Celular celular();
    }
}
