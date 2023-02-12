package com.apicreditos.values;

import com.apicreditos.ValueObject;

public class InformacionDemografica implements ValueObject<InformacionDemografica.Props> {
    private final Ubicacion ubicacion;
    private final Direccion direccion;

    public InformacionDemografica(Ubicacion ubicacion, Direccion direccion) {
        this.ubicacion = ubicacion;
        this.direccion = direccion;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Ubicacion ubicacion() {
                return ubicacion;
            }

            @Override
            public Direccion direccion() {
                return direccion;
            }
        };
    }

    public interface Props {
        Ubicacion ubicacion();
        Direccion direccion();
    }

}
