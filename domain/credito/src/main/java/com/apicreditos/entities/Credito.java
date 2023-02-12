package com.apicreditos.entities;

import com.apicreditos.AggregateRoot;
import com.apicreditos.values.CreditoId;
import com.apicreditos.values.VinculacionId;

public class Credito extends AggregateRoot<CreditoId> {

    protected VinculacionId vinculacionId;

    private Credito(CreditoId id) {
        super(id);
    }

    public Credito(CreditoId id, VinculacionId vinculacionId) {
        super(id);
        this.vinculacionId = vinculacionId;
    }
}
