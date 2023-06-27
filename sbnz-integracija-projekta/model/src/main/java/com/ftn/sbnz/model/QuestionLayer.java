package com.ftn.sbnz.model;

public enum QuestionLayer {

    FIRST(0),
    SECOND(1),
    THIRD(2);

    private final int value;

    QuestionLayer(int value) {
        this.value = value;
    }

    public static QuestionLayer valueOf(int value) {
        switch (value) {
            case 2:
                return QuestionLayer.THIRD;
            case 1:
                return QuestionLayer.SECOND;
            default:
                return QuestionLayer.FIRST;
        }
    }
}
