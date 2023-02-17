package com.apicreditos.gateways;

import com.apicreditos.DomainEvent;

import java.util.List;

public interface VinculacionRepository {
    DomainEvent vincularClienteNoReactivo(DomainEvent event);
    List<DomainEvent> buscarPorIdNoReactivo(String agregateRootId);
}
