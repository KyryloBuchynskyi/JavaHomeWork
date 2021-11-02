package com.pb.buchinskyi.hw6;

/*
Dog, Cat, Horse переопределяют методы makeNoise, eat.
Добавьте переменные (поля) в классы Dog, Cat, Horse, характеризующие только этих животных.
В классах Dog, Cat, Horse переопределить методы toString, equals, hashCode.
 */

import java.util.Objects;

public class Dog extends Animal {

    private String bestFriend;

    public Dog() {
        super();
        setBestFriend("Whole the world");
    }

    public Dog(String food, String location, String bestFriend) {
        setFood(food);
        setLocation(location);
        setBestFriend(bestFriend);
    }

    @Override
    public void makeNoise() {
        System.out.println("Dog say Gaff");
    }

    @Override
    public void eat() {
        System.out.printf("Dog eat %s\n", getFood());
    }

    @Override
    public void sleep() {
        System.out.println("Dog doesn't sleep. Dog guards the owner");
    }

    public void setBestFriend(String bestFriend) {
        this.bestFriend = bestFriend.isEmpty() ? "Whole the world" : bestFriend;
    }

    public String getBestFriend() {
        return bestFriend;
    }

    @Override
    public String toString() {
        return "Dog on location " + getLocation() + " ,eat " + getFood() +
                " and has best friend = " + getBestFriend();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(getBestFriend(), dog.getBestFriend());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBestFriend());
    }
}
