package com.grzywacz.traveloffice.hotels;

public enum Star {
    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5);

    public final int label;

    Star(int i) {
        this.label = i;
    }

    public static Star getStartByLabel(int label) {
       return switch (label) {
           case 1 -> ONE;
           case 2 -> TWO;
           case 3 -> THREE;
           case 4 -> FOUR;
           case 5 -> FIVE;
           default -> ONE;
       };
    }
}
