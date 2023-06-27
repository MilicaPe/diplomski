package com.ftn.sbnz.model;

public enum Intensity {
    BLAGO(1),
    UMERENO(2),
    IZRAZENO(3),
    TESKO(4),
    DUBOKO(5);

    private final int value;

    Intensity(int value) {
        this.value = value;
    }

    public static Intensity valueOf(int value) {
        switch (value) {
            case 5:
                return Intensity.DUBOKO;
            case 4:
                return Intensity.TESKO;
            case 3:
                return Intensity.IZRAZENO;
            case 2:
                return Intensity.UMERENO;
            default:
                return Intensity.BLAGO;
        }
    }
}
