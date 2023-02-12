package com.apicreditos.values;

import com.apicreditos.ValueObject;

public class Telefono implements ValueObject<String>  {
    private final String telefono;

    public Telefono(String telefono) {
        this.telefono = telefono;
        verificarTelefono(telefono);
    }

    @Override
    public String value() {
        return telefono;
    }

    private void verificarTelefono(String telefono) {
        if(telefono.length() != 10) {
            throw new IllegalArgumentException("Celular no valido.");
        }
    }

}
