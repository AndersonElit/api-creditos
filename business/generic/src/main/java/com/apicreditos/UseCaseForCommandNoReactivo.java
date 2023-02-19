package com.apicreditos;

import java.util.List;

public interface UseCaseForCommandNoReactivo<R extends Command> {
    List<DomainEvent> apply(R command);
}
