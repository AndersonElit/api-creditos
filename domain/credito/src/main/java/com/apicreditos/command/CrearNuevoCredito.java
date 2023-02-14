package com.apicreditos.command;

import com.apicreditos.Command;
import com.apicreditos.enums.EstadoCredito;
import com.apicreditos.values.InformacionCreditoAprobado;

public class CrearNuevoCredito extends Command {

    private String creditoId;
    private String vinculacionId;
    private InformacionCreditoAprobado informacionCreditoAprobado;
    private EstadoCredito estadoCredito;

    public CrearNuevoCredito() {
    }

    public String getCreditoId() {
        return creditoId;
    }

    public void setCreditoId(String creditoId) {
        this.creditoId = creditoId;
    }

    public String getVinculacionId() {
        return vinculacionId;
    }

    public void setVinculacionId(String vinculacionId) {
        this.vinculacionId = vinculacionId;
    }

    public InformacionCreditoAprobado getInformacionCreditoAprobado() {
        return informacionCreditoAprobado;
    }

    public void setInformacionCreditoAprobado(InformacionCreditoAprobado informacionCreditoAprobado) {
        this.informacionCreditoAprobado = informacionCreditoAprobado;
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

    public void setEstadoCredito(EstadoCredito estadoCredito) {
        this.estadoCredito = estadoCredito;
    }
}
