package com.apicreditos.values;

import com.apicreditos.ValueObject;

public class InformacionAdicional implements ValueObject<InformacionAdicional.Props> {
    private final Boolean desplazado;
    private final Boolean cabezaHogar;
    private final Boolean afrodescendiente;

    public InformacionAdicional(Boolean desplazado, Boolean cabezaHogar, Boolean afrodescendiente) {
        this.desplazado = desplazado;
        this.cabezaHogar = cabezaHogar;
        this.afrodescendiente = afrodescendiente;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Boolean desplazado() {
                return desplazado;
            }

            @Override
            public Boolean cabezaHogar() {
                return cabezaHogar;
            }

            @Override
            public Boolean afrodescendiente() {
                return afrodescendiente;
            }
        };
    }

    public interface Props {
        Boolean desplazado();
        Boolean cabezaHogar();
        Boolean afrodescendiente();
    }

}
