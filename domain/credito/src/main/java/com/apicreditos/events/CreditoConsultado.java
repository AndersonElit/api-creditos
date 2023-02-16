package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Credito;

public class CreditoConsultado extends DomainEvent {

    private final Credito credito;

    public CreditoConsultado(Credito credito) {
        super("CreditoConsultado");
        this.credito = credito;
    }

    public Credito getCredito() {
        return credito;
    }

}
