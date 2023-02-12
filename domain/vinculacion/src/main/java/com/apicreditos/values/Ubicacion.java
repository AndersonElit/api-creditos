package com.apicreditos.values;

import com.apicreditos.ValueObject;

public class Ubicacion implements ValueObject<Ubicacion.Props> {
    private final String pais;
    private final String deparatamento;
    private final String ciudad;

    public Ubicacion(String pais, String deparatamento, String ciudad) {
        this.pais = pais;
        this.deparatamento = deparatamento;
        this.ciudad = ciudad;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String pais() {
                return pais;
            }

            @Override
            public String deparatamento() {
                return deparatamento;
            }

            @Override
            public String ciudad() {
                return ciudad;
            }
        };
    }

    public interface Props {
        String pais();
        String deparatamento();
        String ciudad();
    }

}
