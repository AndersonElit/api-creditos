package com.apicreditos.values;

import com.apicreditos.ValueObject;

import java.time.LocalTime;

public class HorarioAtencion implements ValueObject<HorarioAtencion.Props> {
    private final LocalTime horaInicio;
    private final LocalTime horaFin;

    public HorarioAtencion(LocalTime horaInicio, LocalTime horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public LocalTime horaInicio() {
                return horaInicio;
            }

            @Override
            public LocalTime horaFin() {
                return horaFin;
            }
        };
    }

    public interface Props {
        LocalTime horaInicio();
        LocalTime horaFin();
    }

}
