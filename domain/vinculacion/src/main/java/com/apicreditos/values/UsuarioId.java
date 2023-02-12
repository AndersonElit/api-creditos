package com.apicreditos.values;

import com.apicreditos.Identity;

public class UsuarioId extends Identity {

    public UsuarioId() {
    }

    public UsuarioId(String id) {
        super(id);
    }

    public static UsuarioId of(String id) {
        return new UsuarioId(id);
    }

}
