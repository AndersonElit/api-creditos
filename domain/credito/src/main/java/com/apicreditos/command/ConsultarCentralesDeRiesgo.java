package com.apicreditos.command;

import com.apicreditos.Command;

public class ConsultarCentralesDeRiesgo extends Command {

    private String clienteId;
    private String numeroIdentificacionCliente;

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getNumeroIdentificacionCliente() {
        return numeroIdentificacionCliente;
    }

    public void setNumeroIdentificacionCliente(String numeroIdentificacionCliente) {
        this.numeroIdentificacionCliente = numeroIdentificacionCliente;
    }

}
