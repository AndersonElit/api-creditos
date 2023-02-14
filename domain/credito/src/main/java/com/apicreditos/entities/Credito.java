package com.apicreditos.entities;

import com.apicreditos.AggregateRoot;
import com.apicreditos.enums.EstadoCredito;
import com.apicreditos.events.*;
import com.apicreditos.values.*;

import java.time.LocalDate;

public class Credito extends AggregateRoot<CreditoId> {

    protected VinculacionId vinculacionId;
    protected InformacionCreditoAprobado informacionCreditoAprobado;
    protected EstadoCredito estadoCredito;
    protected LocalDate fechaCreacion;

    private Credito(CreditoId id) {
        super(id);
    }

    public Credito(CreditoId id, VinculacionId vinculacionId) {
        super(id);
        vincularCliente(vinculacionId);

    }

    public Credito(CreditoId id, VinculacionId vinculacionId, InformacionCreditoAprobado informacionCreditoAprobado, EstadoCredito estadoCredito) {
        super(id);
        subscribe(new CreditoEventChange(this));
        appendChange(new CreditoCreado(this.fechaCreacion)).apply();
    }

    public void vincularCliente(VinculacionId vinculacionId) {
        this.estadoCredito = EstadoCredito.VINCULACIONCLIENTE;
        this.vinculacionId = vinculacionId;
        appendChange(new ClienteVinculado(vinculacionId)).apply();
    }

    public void analizarHistorialCrediticio() {
        cambiarEstadoEnAnalisis();
        appendChange(new HistorialCrediticioAnalizado(this.estadoCredito)).apply();
    }

    public void capacidadEndeudamiento() {
        cambiarEstadoEnAnalisis();
        appendChange(new CapacidadEndeudamientoAnalizada(this.estadoCredito)).apply();
    }

    public void valorPatrimonio() {
        cambiarEstadoEnAnalisis();
        appendChange(new ValorPatrimonioDeterminado(this.estadoCredito)).apply();
    }

    public void consultaCentralesDeRiesgo() {
        cambiarEstadoEnAnalisis();
        appendChange(new CentralesDeRiesgoConsultadas(this.estadoCredito)).apply();
    }

    public void calcularScore() {
        Double score = 0.0;
        if(score >= 70) {
            cambiarEstadoAprobado();
            appendChange(new ScoreCalculado(this.estadoCredito, score)).apply();
        } else {
            cambiarEstadoRechazado();
            appendChange(new ScoreCalculado(this.estadoCredito, score)).apply();
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
