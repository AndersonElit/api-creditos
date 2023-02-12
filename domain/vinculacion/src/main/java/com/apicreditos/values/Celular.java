package com.apicreditos.values;

import com.apicreditos.ValueObject;

public class Celular implements ValueObject<String> {
    private final String celular;

    public Celular(String celular) {
        this.celular = celular;
        verificarCelular(celular);
    }

    @Override
    public String value() {
        return celular;
    }

    private void verificarCelular(String celular) {
        if(celular.length() != 10) {
            throw new IllegalArgumentException("Celular no valido.");
        }
    }
}
