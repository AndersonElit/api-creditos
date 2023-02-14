package com.apicreditos.gateways;

import com.apicreditos.DomainEvent;

public interface VinculacionRepository {
    DomainEvent vincularClienteNoReactivo(DomainEvent event);

}
