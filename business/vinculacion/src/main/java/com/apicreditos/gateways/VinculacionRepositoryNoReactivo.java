package com.apicreditos.gateways;

import com.apicreditos.DomainEvent;

import java.util.List;

public interface VinculacionRepositoryNoReactivo {
    DomainEvent vincularClienteNoReactivo(DomainEvent event);
    List<DomainEvent> buscarPorIdNoReactivo(String agregateRootId);
}
