package com.ftn.sbnz.model.helper;

public enum SymptomType {
    USLOV_ANK(0),
    ANK(1),
    GAD(2),
    USLOV_PAN(3),
    PAN(4),
    PAN_POR(5),
    USLOV_SOC(6),
    SOC(7),
    SOC_FOB(8);

    private final int value;

    SymptomType(int value) {
        this.value = value;
    }

    public static SymptomType valueOf(int value) {
        switch (value) {

            case 1:
                return SymptomType.ANK;
            case 2:
                return SymptomType.GAD;
            case 3:
                return SymptomType.USLOV_PAN;
            case 4:
                return SymptomType.PAN;
            case 5:
                return SymptomType.PAN_POR;
            case 6:
                return SymptomType.USLOV_SOC;
            case 7:
                return SymptomType.SOC;
            case 8:
                return SymptomType.SOC_FOB;
            default:
                return SymptomType.USLOV_ANK;
        }
    }
}
