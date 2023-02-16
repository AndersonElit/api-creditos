package com.apicreditos.command;

import com.apicreditos.Command;
import com.apicreditos.entities.Asesor;
import com.apicreditos.entities.Cliente;
import com.apicreditos.entities.Oficina;

public class VincularClienteCommand extends Command {
    private String vinculacionId;
    private Cliente cliente;
    private Asesor asesor;
    private Oficina oficina;

    public VincularClienteCommand() {
    }

    public VincularClienteCommand(String vinculacionId, Cliente cliente, Asesor asesor, Oficina oficina) {
        this.vinculacionId = vinculacionId;
        this.cliente = cliente;
        this.asesor = asesor;
        this.oficina = oficina;
    }

    public String getVinculacionId() {
        return vinculacionId;
    }

    public void setVinculacionId(String vinculacionId) {
        this.vinculacionId = vinculacionId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

}
