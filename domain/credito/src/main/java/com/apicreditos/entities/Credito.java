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

    public Credito(CreditoId id, VinculacionId vinculacionId, EstadoCredito estadoCredito) {
        super(id);
        subscribe(new CreditoEventChange(this));
        appendChange(new CreditoCreado()).apply();
    }

    public void vincularCliente(VinculacionId vinculacionId) {
        appendChange(new ClienteVinculado(vinculacionId, EstadoCredito.VINCULACIONCLIENTE)).apply();
    }

    public void analizarHistorialCrediticio() {
        appendChange(new HistorialCrediticioAnalizado(EstadoCredito.ENANALISIS)).apply();
    }

    public void capacidadEndeudamiento() {
        appendChange(new CapacidadEndeudamientoAnalizada(EstadoCredito.ENANALISIS)).apply();
    }

    public void valorPatrimonio() {
        appendChange(new ValorPatrimonioDeterminado(EstadoCredito.ENANALISIS)).apply();
    }

    public void consultaCentralesDeRiesgo() {
        appendChange(new CentralesDeRiesgoConsultadas(EstadoCredito.ENANALISIS)).apply();
    }

    public void calcularScore() {
        Double score = 75.0;
        if(score >= 70.0) {
            appendChange(new ScoreCalculado(EstadoCredito.APROBADO, score)).apply();
            appendChange(new CreditoAprobado(EstadoCredito.APROBADO, score, new InformacionCreditoAprobado())).apply();
        } else {
            appendChange(new ScoreCalculado(EstadoCredito.RECHAZADO, score)).apply();
            appendChange(new CreditoRechazado(EstadoCredito.RECHAZADO, score)).apply();
        }
    }

}
