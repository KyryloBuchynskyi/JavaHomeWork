package com.pb.buchinskyi.hw6;

/*
В пакете hw6 создайте класс Animal и расширяющие его классы Dog, Cat, Horse.
Класс Animal содержит переменные food, location и методы makeNoise, eat, sleep.
Метод sleep, например, может выводить на консоль "Такое-то животное спит".
 */
public class Animal {
    private String food;
    private String location;

    public Animal() {
        setFood("strange food");
        setLocation("Never-land");
    }

    public void makeNoise() {
        System.out.println("Mysterious animal make strange noise");
    }

    public void eat() {
        System.out.printf("Mysterious animal  eat %s\n", getFood());
    }

    public void sleep() {
        System.out.println("Mysterious animal sleep");
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

    public void setFood(String food) {
        this.food = food.isEmpty() ? "strange food" : food;
    }

    public void setLocation(String location) {
        this.location = location.isEmpty() ? "Never-land" : location;
    }
}
