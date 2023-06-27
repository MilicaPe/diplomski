package com.ftn.sbnz.model;

public enum Gender {
    FEMALE(0),
    MALE(1);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

    public static Gender valueOf(int value) {
        switch (value) {
            case 1:
                return Gender.MALE;
            default:
                return Gender.FEMALE;
        }
    }

}
