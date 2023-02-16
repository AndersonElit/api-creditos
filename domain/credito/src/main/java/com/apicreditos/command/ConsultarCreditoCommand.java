package com.apicreditos.command;

import com.apicreditos.Command;

public class ConsultarCreditoCommand extends Command {
    private String creditoId;

    public ConsultarCreditoCommand(String creditoId) {
        this.creditoId = creditoId;
    }

    public String getCreditoId() {
        return creditoId;
    }

    public void setCreditoId(String creditoId) {
        this.creditoId = creditoId;
    }

}
