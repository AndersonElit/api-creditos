package com.apicreditos.values;

import com.apicreditos.Identity;

public class VinculacionId extends Identity {

    public VinculacionId(String id) {
        super(id);
    }

    public VinculacionId() {
    }

    public static VinculacionId of(String id) {
        return new VinculacionId(id);
    }


}
