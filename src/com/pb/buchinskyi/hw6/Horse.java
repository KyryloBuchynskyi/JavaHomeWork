package com.pb.buchinskyi.hw6;

import java.util.Objects;

public class Horse extends Animal {

    private String horseshoesChanges;//дата смены подков

    public Horse() {
        super();
        setHorseshoesChanges("no horseshoes");
    }

    public Horse(String food, String location, String horseshoesChanges) {
        setFood(food);
        setLocation(location);
        setHorseshoesChanges(horseshoesChanges);
    }

    @Override
    public void makeNoise() {
        System.out.println("Horse say Igo-go=)");
    }

    @Override
    public void eat() {
        System.out.printf("Horse eat %s\n", getFood());
    }

    @Override
    public void sleep() {
        System.out.println("Horse sleep at the barn");
    }

    public String getHorseshoesChanges() {
        return horseshoesChanges;
    }

    public void setHorseshoesChanges(String horseshoesChanges) {
        this.horseshoesChanges = horseshoesChanges.isEmpty() ? "no horseshoes" : horseshoesChanges;
    }

    @Override
    public String toString() {
        return "Horse on location " + getLocation() + " ,eat " + getFood() +
                " and changed its horseshoes = " + getHorseshoesChanges();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horse)) return false;
        Horse horse = (Horse) o;
        return getHorseshoesChanges().equals(horse.getHorseshoesChanges());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHorseshoesChanges());
    }
}
