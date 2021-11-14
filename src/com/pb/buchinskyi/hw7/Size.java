package com.pb.buchinskyi.hw7;

public enum Size {
    XXS("Детский", 32),
    XS("Детский", 34),
    S("Подростоковый", 36),
    M("Подростоковый", 38),
    L("Взрослый", 40);

    private String description;
    private int EuroSize;

    Size(String description, int EuroSize) {
        this.description = description;
        this.EuroSize = EuroSize;
    }

    public String getDescription() { return description; }

    public int getEuroSize() { return EuroSize; }

    @Override//Юху! Переопрелеоио в энуме ту стринг, для более удобного вывода информации на эран
    public String toString() {
        return "Размер:" + " (" + name() + '\\' + getEuroSize() +  ") - " + getDescription();
    }
}
