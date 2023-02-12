package com.apicreditos.command;

import com.apicreditos.Command;

public class DeterminarCapacidadEndeudamiento extends Command {
    private String idCliente;
    private Long ingresos;
    private Long egresos;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIngresos() {
        return ingresos;
    }

    public void setIngresos(Long ingresos) {
        this.ingresos = ingresos;
    }

    public Long getEgresos() {
        return egresos;
    }

    public void setEgresos(Long egresos) {
        this.egresos = egresos;
    }

}
