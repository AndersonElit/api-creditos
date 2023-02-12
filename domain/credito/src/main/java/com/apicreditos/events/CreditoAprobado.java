package com.apicreditos.events;

import com.apicreditos.DomainEvent;

import java.time.LocalDate;

public class CreditoAprobado extends DomainEvent {
    private final String clienteId;
    private final String asesorId;
    private final String montoAprobado;
    private final Integer numeroCuotas;
    private final LocalDate fechaPagoPrimeraCuota;

    public CreditoAprobado(String type, String clienteId, String asesorId, String montoAprobado, Integer numeroCuotas, LocalDate fechaPagoPrimeraCuota) {
        super(type);
        this.clienteId = clienteId;
        this.asesorId = asesorId;
        this.montoAprobado = montoAprobado;
        this.numeroCuotas = numeroCuotas;
        this.fechaPagoPrimeraCuota = fechaPagoPrimeraCuota;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getAsesorId() {
        return asesorId;
    }

    public String getMontoAprobado() {
        return montoAprobado;
    }

    public Integer getNumeroCuotas() {
        return numeroCuotas;
    }

    public LocalDate getFechaPagoPrimeraCuota() {
        return fechaPagoPrimeraCuota;
    }

}
