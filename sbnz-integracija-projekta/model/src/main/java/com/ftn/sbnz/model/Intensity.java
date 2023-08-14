package com.ftn.sbnz.model;

import javax.persistence.criteria.CriteriaBuilder;

public enum Intensity {
    BLAGO(0),
    UMERENO(1),
    IZRAZENO(2),
    TESKO(3),
    DUBOKO(4);

    private final int value;

    Intensity(int value) {
        this.value = value;
    }

    public static Intensity valueOf(int value) {
        switch (value) {
            case 4:
                return Intensity.DUBOKO;
            case 3:
                return Intensity.TESKO;
            case 2:
                return Intensity.IZRAZENO;
            case 1:
                return Intensity.UMERENO;
            default:
                return Intensity.BLAGO;
        }
    }
}
