package com.apicreditos.command;

import com.apicreditos.Command;

public class AsignarOficina extends Command {
    private String idOficina;
    private String idCliente;

    public String getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(String idOficina) {
        this.idOficina = idOficina;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

}
