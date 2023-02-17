package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.entities.Credito;

public class CreditoConsultado extends DomainEvent {

    public CreditoConsultado() {
        super("CreditoConsultado");
    }

}
