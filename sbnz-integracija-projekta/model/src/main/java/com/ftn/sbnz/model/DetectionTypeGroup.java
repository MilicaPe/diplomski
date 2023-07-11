package com.ftn.sbnz.model;

public enum DetectionTypeGroup {
    EMOTION(0),
    MENTAL_STATE(1);

    private final int value;

    DetectionTypeGroup(int value) {
        this.value = value;
    }

    public static DetectionTypeGroup valueOf(int value) {
        switch (value) {
            case 1:
                return DetectionTypeGroup.MENTAL_STATE;
            default:
                return DetectionTypeGroup.EMOTION;
        }
    }
}
