package com.apicreditos.values;

import com.apicreditos.enums.Sexo;
import com.apicreditos.ValueObject;

import java.time.LocalDate;
import java.time.Period;

public class InformacionBasica implements ValueObject<InformacionBasica.Props> {

    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Sexo sexo;
    private final LocalDate fechaNacimiento;

    public InformacionBasica(Nombre nombre, Identificacion identificacion, Sexo sexo, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        if(!verificarEdadUsuario(fechaNacimiento)) {
            throw new IllegalArgumentException("El usuario es menor de edad.");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Nombre nombre() {
                return nombre;
            }

            @Override
            public Identificacion identificacion() {
                return identificacion;
            }

            @Override
            public Sexo sexo() {
                return sexo;
            }

            @Override
            public LocalDate fechaNacimiento() {
                return fechaNacimiento;
            }
        };
    }

    public interface Props {
        Nombre nombre();
        Identificacion identificacion();
        Sexo sexo();
        LocalDate fechaNacimiento();
    }

    private Boolean verificarEdadUsuario(LocalDate fechaNacimiento) {
        Integer edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        if(edad >= 18) {
            return true;
        } else {
            return false;
        }
    }

}
