package com.example.lab11;

import java.io.Serializable;

public class CountryBean implements Serializable {
    private String code;
    private String name;
    private long population;

    private long surfaceArea;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(long surfaceArea) {
        this.surfaceArea = surfaceArea;
    }
}
