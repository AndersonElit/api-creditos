package com.apicreditos.entities;

import com.apicreditos.AggregateRoot;
import com.apicreditos.command.VincularCliente;
import com.apicreditos.enums.EstadoCredito;
import com.apicreditos.events.*;
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

    public Credito(CreditoId id, VinculacionId vinculacionId, InformacionCreditoAprobado informacionCreditoAprobado, EstadoCredito estadoCredito) {
        super(id);
        this.vinculacionId = vinculacionId;
        this.informacionCreditoAprobado = informacionCreditoAprobado;
        this.estadoCredito = estadoCredito;
        subscribe(new CreditoEventChange(this));
    }

    private void vincularCliente(VinculacionId vinculacionId) {
        this.estadoCredito = EstadoCredito.VINCULACIONCLIENTE;
        this.vinculacionId = vinculacionId;
        appendChange(new ClienteVinculado(vinculacionId));
    }

    private void analizarHistorialCrediticio(Identificacion identificacion) {
        cambiarEstadoEnAnalisis();
        //appendChange(new HistorialCrediticioAnalizado(this.estadoCredito, ));
    }

    private void capacidadEndeudamiento(InformacionFinanciera informacionFinanciera) {
        cambiarEstadoEnAnalisis();
        //appendChange(new CapacidadEndeudamientoAnalizada(this.estadoCredito, ));
    }

    private void valorPatrimonio() {
        cambiarEstadoEnAnalisis();
        //appendChange(new ValorPatrimonioDeterminado(this.estadoCredito, ));
    }

    private void consultaCentralesDeRiesgo(Identificacion identificacion) {
        cambiarEstadoEnAnalisis();
        //appendChange(new CentralesDeRiesgoConsultadas(this.estadoCredito, ));
    }

    private void calcularScore() {
        Double score = 0.0;
        if(score >= 70) {
            cambiarEstadoAprobado();
            appendChange(new ScoreCalculado(this.estadoCredito, score));
        } else {
            cambiarEstadoRechazado();
            appendChange(new ScoreCalculado(this.estadoCredito, score));
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
