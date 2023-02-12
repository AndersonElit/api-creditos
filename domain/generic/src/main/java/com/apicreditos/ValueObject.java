package com.apicreditos;

import java.io.Serializable;

public interface ValueObject<T> extends Serializable {
    T value();
}
