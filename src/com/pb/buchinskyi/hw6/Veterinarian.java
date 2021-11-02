package com.pb.buchinskyi.hw6;

/*
Создайте класс Veterinarian (Ветеринар), в котором определите метод void treatAnimal(Animal animal).
Пусть этот метод печатает на экран food и location пришедшего на прием животного.
 */
public class Veterinarian {

    //Количество пациентов
    private int eCount;

    public Veterinarian() {
        eCount = 0;
    }

    //Лечим выводом на экран еды и локации =)
    public void treatAnimal(Animal animal) {
        eCount++;
        System.out.printf("Animal №%d\n\tlocation = %s\n\tfood\t = %s\n\n", eCount, animal.getLocation(), animal.getFood());
    }

}
