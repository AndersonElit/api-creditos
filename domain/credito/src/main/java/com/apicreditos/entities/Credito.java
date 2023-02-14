package com.apicreditos.entities;

import com.apicreditos.AggregateRoot;
import com.apicreditos.enums.EstadoCredito;
import com.apicreditos.values.*;

public class Credito extends AggregateRoot<CreditoId> {

    protected VinculacionId vinculacionId;
    protected InformacionCreditoAprobado informacionCreditoAprobado;
    protected EstadoCredito estadoCredito;

    private Credito(CreditoId id) {
        super(id);
    }

    public Credito(CreditoId id, VinculacionId vinculacionId) {
        super(id);
        vincularCliente(vinculacionId);

    }

    private void vincularCliente(VinculacionId vinculacionId) {
        this.estadoCredito = EstadoCredito.VINCULACIONCLIENTE;
        this.vinculacionId = vinculacionId;
    }

    public Credito(CreditoId id, VinculacionId vinculacionId, InformacionCreditoAprobado informacionCreditoAprobado, EstadoCredito estadoCredito) {
        super(id);
        this.vinculacionId = vinculacionId;
        this.informacionCreditoAprobado = informacionCreditoAprobado;
        this.estadoCredito = estadoCredito;
    }

    private void analizarHistorialCrediticio(Identificacion identificacion) {
        cambiarEstadoEnAnalisis();
    }

    private void capacidadEndeudamiento(InformacionFinanciera informacionFinanciera) {
        cambiarEstadoEnAnalisis();
    }

    private void valorPatrimonio() {
        cambiarEstadoEnAnalisis();
    }

    private void consultaCentralesDeRiesgo(Identificacion identificacion) {
        cambiarEstadoEnAnalisis();
    }

    private void calcularScore() {
        Double score = 0.0;
        if(score >= 70) {
            cambiarEstadoAprobado();
        } else {
            cambiarEstadoRechazado();
        }
    }

    private void cambiarEstadoEnAnalisis() {
        this.estadoCredito = EstadoCredito.ENANALISIS;
    }

    private void cambiarEstadoAprobado() {
        this.estadoCredito = EstadoCredito.APROBADO;
    }

    private void cambiarEstadoRechazado() {
        this.estadoCredito = EstadoCredito.RECHAZADO;
    }

    public InformacionCreditoAprobado informacionCreditoAprobado() {
        if(estadoCredito.compareTo(EstadoCredito.APROBADO) == 0) {
            return informacionCreditoAprobado;
        } else {
            throw new IllegalArgumentException("El credito no esta en estado aprobado.");
        }
    }



}
