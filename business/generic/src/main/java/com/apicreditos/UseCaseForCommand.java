package com.apicreditos;

import com.apicreditos.Command;
import com.apicreditos.DomainEvent;

import java.util.List;

public interface UseCaseForCommand<R extends Command> {
    List<DomainEvent> apply(R command);
}
