package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Cliente;
import com.apicreditos.values.VinculacionId;

public class ClienteVinculado extends DomainEvent {
    private final VinculacionId vinculacionId;

    public ClienteVinculado(VinculacionId vinculacionId) {
        super("ClienteVinculado");
        this.vinculacionId = vinculacionId;
    }

    public VinculacionId getVinculacionId() {
        return vinculacionId;
    }

}
