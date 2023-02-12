package com.apicreditos.command;

import com.apicreditos.Command;

public class VincularClienteCommand extends Command {

    private String vinculacionId;

    public String getVinculacionId() {
        return vinculacionId;
    }

    public void setVinculacionId(String vinculacionId) {
        this.vinculacionId = vinculacionId;
    }

}
