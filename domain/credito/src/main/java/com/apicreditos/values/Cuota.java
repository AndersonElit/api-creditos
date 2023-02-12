package com.apicreditos.values;

import com.apicreditos.ValueObject;

import java.time.LocalDate;

public class Cuota implements ValueObject<Cuota.Props> {
    private Integer numeroCuota;
    private Long valorCuota;
    private LocalDate fechaPagoCuota;

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer numeroCuota() {
                return numeroCuota;
            }

            @Override
            public Long valorCuota() {
                return valorCuota;
            }

            @Override
            public LocalDate fechaPagoCuota() {
                return fechaPagoCuota;
            }
        };
    }

    public interface Props {
        Integer numeroCuota();
        Long valorCuota();
        LocalDate fechaPagoCuota();
    }

}
