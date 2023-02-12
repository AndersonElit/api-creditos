package com.apicreditos.values;

import com.apicreditos.ValueObject;

public class Correo implements ValueObject<String> {
    private final String correo;

    public Correo(String correo) {
        this.correo = correo;
        verificarCorreo(correo);
    }

    @Override
    public String value() {
        return correo;
    }

    private void verificarCorreo(String correo) {
        if(!correo.contains("@")) {
            throw new IllegalArgumentException("Correo no valido.");
        }
    }
}
