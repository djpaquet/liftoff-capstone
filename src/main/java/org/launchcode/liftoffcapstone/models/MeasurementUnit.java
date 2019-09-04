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
    NULL (" "),
    ;

    private final String name;


    MeasurementUnit(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }





}
