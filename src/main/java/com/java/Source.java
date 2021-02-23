package com.java;

public class Source {
private String name;

Source(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum SourceType {
        WAREHOUSE, FACTORY;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                '}';
    }
}
