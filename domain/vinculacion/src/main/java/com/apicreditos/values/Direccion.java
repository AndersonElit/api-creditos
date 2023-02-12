package com.apicreditos.values;

import com.apicreditos.enums.TipoDireccion;
import com.apicreditos.ValueObject;

public class Direccion implements ValueObject<Direccion.Props> {
    private final String direccion;
    private final TipoDireccion tipoDireccion;

    public Direccion(String direccion, TipoDireccion tipoDireccion) {
        this.direccion = direccion;
        this.tipoDireccion = tipoDireccion;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String direccion() {
                return direccion;
            }

            @Override
            public TipoDireccion tipoDireccion() {
                return tipoDireccion;
            }
        };
    }

    public interface Props {
        String direccion();
        TipoDireccion tipoDireccion();
    }
}
