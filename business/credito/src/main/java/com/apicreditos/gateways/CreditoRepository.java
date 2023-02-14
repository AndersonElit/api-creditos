package com.apicreditos.gateways;

import com.apicreditos.DomainEvent;

public interface CreditoRepository {
    DomainEvent crearNuevoCreditoNoReactivo(DomainEvent event);
}
