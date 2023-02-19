package com.apicreditos.gateways;

import com.apicreditos.DomainEvent;

import java.util.List;

public interface CreditoRepositoryNoReactivo {
    DomainEvent crearNuevoCreditoNoReactivo(DomainEvent event);
    List<DomainEvent> buscarPorIdNoReactivo(String agregateRootId);
}
