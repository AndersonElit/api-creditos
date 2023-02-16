package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.enums.EstadoCredito;
import com.apicreditos.values.InformacionCreditoAprobado;
import com.apicreditos.values.VinculacionId;

import java.time.LocalDate;

public class CreditoCreado extends DomainEvent {

    private final VinculacionId vinculacionId;
    private final EstadoCredito estadoCredito;

    public CreditoCreado(VinculacionId vinculacionId, EstadoCredito estadoCredito) {
        super("CreditoCreado");
        this.vinculacionId = vinculacionId;
        this.estadoCredito = estadoCredito;
    }

    public VinculacionId getVinculacionId() {
        return vinculacionId;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

}
