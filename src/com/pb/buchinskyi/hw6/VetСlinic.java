package com.pb.buchinskyi.hw6;

import java.lang.reflect.Constructor;

/*
Создайте класс VetСlinic в его методе main создайте массив типа Animal, в который запишите животных всех имеющихся у вас типов.
В цикле отправляйте животных на прием к ветеринару.
Объект класса Veterinarian создайте с помощью рефлексии.
 */
public class VetСlinic {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Cat("cat food", "home", 7);
        animals[1] = new Dog("fresh meat", "yard", "you");
        animals[2] = new Horse("carrot", "barn", "02.11.2021");

        //человеческое решение
        /*
        Veterinarian vet = new Veterinarian();

        for (int i = 0; i<animals.length;i++)
        {
            vet.treatAnimal(animals[i]);
        }
        */

        //не человеческое решение
        //1. получили название класса
        /*
        Veterinarian vet = new Veterinarian();
        Class  clazz = vet.getClass();
        System.out.println(clazz.getName());
        */
        //com.pb.buchinskyi.hw6.Veterinarian
        //2. создаем наш класс по рефлексии
        try {
            Class clazz = Class.forName("com.pb.buchinskyi.hw6.Veterinarian");
            Constructor constructor = clazz.getConstructor();
            Object obj = constructor.newInstance();

            for (int i = 0; i < animals.length; i++) {
                ((Veterinarian) obj).treatAnimal(animals[i]);
            }
        } catch (Exception e) {
            System.out.println("Ошибка поиска класса");
        }

    }
}
