package com.apicreditos.values;

import com.apicreditos.ValueObject;

import java.util.Set;

public class InformacionCreditoAprobado implements ValueObject<InformacionCreditoAprobado.Props> {
    private Long montoAprobado;
    private Integer numeroCuotas;
    private Set<Cuota> cuotas;
    private Integer fechaPagoPrimeraCuota;

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Long montoAprobado() {
                return montoAprobado;
            }

            @Override
            public Set<Cuota> cuotas() {
                return cuotas;
            }

            @Override
            public Integer fechaPagoPrimeraCuota() {
                return fechaPagoPrimeraCuota;
            }

            @Override
            public Integer numeroCuotas() {
                return cuotas.size();
            }
        };
    }

    public interface Props {
        Long montoAprobado();
        Set<Cuota> cuotas();
        Integer fechaPagoPrimeraCuota();
        Integer numeroCuotas();
    }

}
