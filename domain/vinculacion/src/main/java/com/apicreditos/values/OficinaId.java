package com.apicreditos.values;

import com.apicreditos.Identity;

public class OficinaId extends Identity {

    public OficinaId() {
    }

    public OficinaId(String id) {
        super(id);
    }

    public static OficinaId of(String id) {
        return new OficinaId(id);
    }

}
