package com.apicreditos.values;

import com.apicreditos.Identity;

public class CreditoId extends Identity {

    public CreditoId() {
    }

    public CreditoId(String id) {
        super(id);
    }

    public static CreditoId of(String id) {
        return new CreditoId(id);
    }
}
