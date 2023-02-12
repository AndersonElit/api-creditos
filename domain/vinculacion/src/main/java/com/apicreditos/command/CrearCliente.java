package com.apicreditos.command;

import com.apicreditos.Command;

public class CrearCliente extends Command {
    private String idCliente;
    private String IdAsesor;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdAsesor() {
        return IdAsesor;
    }

    public void setIdAsesor(String idAsesor) {
        IdAsesor = idAsesor;
    }
}
