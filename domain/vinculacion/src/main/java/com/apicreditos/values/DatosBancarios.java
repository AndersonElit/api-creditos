package com.apicreditos.values;

import com.apicreditos.enums.Banco;
import com.apicreditos.enums.TipoCuenta;
import com.apicreditos.ValueObject;

public class DatosBancarios implements ValueObject<DatosBancarios.Props> {
    private final Banco banco;
    private final TipoCuenta tipoCuenta;
    private final String numeroCuenta;

    public DatosBancarios(Banco banco, TipoCuenta tipoCuenta, String numeroCuenta) {
        this.banco = banco;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Banco banco() {
                return banco;
            }

            @Override
            public TipoCuenta tipoCuenta() {
                return tipoCuenta;
            }

            @Override
            public String numeroCuenta() {
                return numeroCuenta;
            }
        };
    }

    public interface Props {
        Banco banco();
        TipoCuenta tipoCuenta();
        String numeroCuenta();
    }

}
