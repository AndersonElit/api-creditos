package com.apicreditos;

public abstract class Entity<I extends Identity> {

    protected I id;

    protected Entity(I id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return id.equals(obj);
    }

    public I identity() {
        return id;
    }

}
