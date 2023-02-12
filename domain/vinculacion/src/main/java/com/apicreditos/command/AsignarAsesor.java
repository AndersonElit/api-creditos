package com.apicreditos.command;

import com.apicreditos.Command;

public class AsignarAsesor extends Command {
    private String IdAsesor;
    private String idCliente;

    public String getIdAsesor() {
        return IdAsesor;
    }

    public void setIdAsesor(String idAsesor) {
        IdAsesor = idAsesor;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

}
