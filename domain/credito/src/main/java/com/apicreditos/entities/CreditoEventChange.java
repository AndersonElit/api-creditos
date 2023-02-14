package com.apicreditos.entities;

import com.apicreditos.EventChange;
import com.apicreditos.events.*;

public class CreditoEventChange extends EventChange {

    public CreditoEventChange(Credito credito) {
        apply((ClienteVinculado event) -> {
            credito.vinculacionId = event.getVinculacionId();
        });
        apply((CapacidadEndeudamientoAnalizada event) -> {
            credito.estadoCredito = event.getEstadoCredito();
        });
        apply((CentralesDeRiesgoConsultadas event) -> {
            credito.estadoCredito = event.getEstadoCredito();
        });
        apply((HistorialCrediticioAnalizado event) -> {
            credito.estadoCredito = event.getEstadoCredito();
        });
        apply((ValorPatrimonioDeterminado event) -> {
            credito.estadoCredito = event.getEstadoCredito();
        });
        apply((ScoreCalculado event) -> {
            credito.estadoCredito = event.getEstadoCredito();
        });
        apply((CreditoAprobado event) -> {
            credito.estadoCredito = event.getEstadoCredito();
            credito.informacionCreditoAprobado = event.getInformacionCreditoAprobado();
        });
        apply((CreditoRechazado event) -> {
            credito.estadoCredito = event.getEstadoCredito();
        });
    }
}
