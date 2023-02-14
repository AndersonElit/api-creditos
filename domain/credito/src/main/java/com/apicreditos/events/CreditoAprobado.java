package com.apicreditos.events;

import com.apicreditos.DomainEvent;
import com.apicreditos.enums.EstadoCredito;
import com.apicreditos.values.InformacionCreditoAprobado;

import java.time.LocalDate;

public class CreditoAprobado extends DomainEvent {
    private final EstadoCredito estadoCredito;
    private final Double score;
    private final InformacionCreditoAprobado informacionCreditoAprobado;

    public CreditoAprobado(EstadoCredito estadoCredito, Double score, InformacionCreditoAprobado informacionCreditoAprobado) {
        super("CreditoAprobado");
        this.estadoCredito = estadoCredito;
        this.score = score;
        this.informacionCreditoAprobado = informacionCreditoAprobado;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

    public Double getScore() {
        return score;
    }

    public InformacionCreditoAprobado getInformacionCreditoAprobado() {
        return informacionCreditoAprobado;
    }

}
