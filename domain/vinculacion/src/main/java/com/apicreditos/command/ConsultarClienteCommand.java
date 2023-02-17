package com.apicreditos.command;

import com.apicreditos.Command;

public class ConsultarClienteCommand extends Command {
    private String vinculacionId;

    public ConsultarClienteCommand() {
    }

    public ConsultarClienteCommand(String vinculacionId) {
        this.vinculacionId = vinculacionId;
    }

    public String getVinculacionId() {
        return vinculacionId;
    }

    public void setVinculacionId(String vinculacionId) {
        this.vinculacionId = vinculacionId;
    }

}
