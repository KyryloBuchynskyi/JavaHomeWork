package com.pb.buchinskyi.hw6;

/*
Dog, Cat, Horse переопределяют методы makeNoise, eat.
Добавьте переменные (поля) в классы Dog, Cat, Horse, характеризующие только этих животных.
В классах Dog, Cat, Horse переопределить методы toString, equals, hashCode.
 */

import java.util.Objects;

public class Cat extends Animal {

    private int lifeCount;

    public Cat() {
        super();
        setLifeCount(9);
    }

    public Cat(String food, String location, int lifeCount) {
        setFood(food);
        setLocation(location);
        setLifeCount(lifeCount);
    }

    public void setLifeCount(int lifeCount) {
        this.lifeCount = lifeCount > -1 ? lifeCount : 0;
    }

    public int getLifeCount() {
        return lifeCount;
    }

    @Override
    public void makeNoise() {
        System.out.println("Cat say Mau");
    }

    @Override
    public void eat() {
        System.out.printf("Cat eat %s\n", getFood());
    }

    @Override
    public void sleep() {
        System.out.println("Cat say good night");
    }

    @Override
    public String toString() {
        return "Cat on location " + getLocation() + " ,eat " + getFood() +
                " and has lifeCounter = " + getLifeCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return getLifeCount() == cat.getLifeCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLifeCount());
    }
}
