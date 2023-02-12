package com.apicreditos.command;

import com.apicreditos.Command;

public class AnalizarHistorialCrediticioCommand extends Command {
    private String idCliente;
    private String numeroIdentificacionCliente;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroIdentificacionCliente() {
        return numeroIdentificacionCliente;
    }

    public void setNumeroIdentificacionCliente(String numeroIdentificacionCliente) {
        this.numeroIdentificacionCliente = numeroIdentificacionCliente;
    }

}
