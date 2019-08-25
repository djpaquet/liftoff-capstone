package org.launchcode.liftoffcapstone.models;

public enum MeasurementUnit {

    TSP ("tsp"),
    TBS ("TBS"),
    CUP ("cup"),
    OZ ("oz"),
    LBS ("lbs"),
    PINTS ("pints"),
    QTS ("qts"),
    EACH ("each"),
    PINCH ("pinch"),
    ;

    MeasurementUnit(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }



}
