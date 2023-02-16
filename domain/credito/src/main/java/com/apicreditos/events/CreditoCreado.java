package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.enums.EstadoCredito;
import com.apicreditos.values.InformacionCreditoAprobado;
import com.apicreditos.values.VinculacionId;

import java.time.LocalDate;

public class CreditoCreado extends DomainEvent {

    public CreditoCreado() {
        super("CreditoCreado");
    }
}
