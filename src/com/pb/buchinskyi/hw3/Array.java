package com.pb.buchinskyi.hw3;

/*
2. Создайте класс Array в пакете hw3.Программа должна позволить пользователю ввести одномерный массив целых чисел размерностью 10 элементов.
Вывести на экран введенный массив.
Подсчитать сумму всех элементов массива и вывести ее на экран.
Подсчитать и вывести на экран количество положительных элементов.
Произвести сортировку этого массива от меньшего к большему по алгоритму сортировки пузырьком. (https://en.wikipedia.org/wiki/Bubble_sort)
Вывести на экран отсортированный массив.
 */

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] mas = initial(10);
        System.out.println("Введенный массив:");
        print(mas); // вывод на экран массив
        printSum(mas); // сумма элементов массива
        printPositiveCount(mas); // подсчет положительных чисел массива
        System.out.println("Массив до сортировки:");
        print(mas); //вывод на экран
        Sort(mas); // сортировка
        System.out.println("Массив после сортировки:");
        print(mas); // вывод на экран
    }

    public static int[] initial(int length) /*Инициализируем массив*/ {
        if (length > 1) {
            int[] tmp;
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            tmp = new int[length];
            for (int i = 0; i < length; i++) {
                System.out.printf("Mas[%d] = ", i);
                try {
                    tmp[i] = scanner.nextInt();
                } catch (Exception e) {
                    scanner.next();
                    tmp[i] = 0;
                }
            }
            return tmp;
        } else {
            System.exit(0);
        }
        return null;
    }

    public static void print(int[] mas) /*Вывод на экран всего массива*/{
        System.out.print("[");
        for (int tmp:mas) {
            System.out.print(tmp + "\t");
        }
        System.out.println("]");
    }

    public static void printSum(int[] mas) /*Вывод на экран суммы элементов массива*/{
        int sum = 0;
        for (int tmp:mas) {
            sum+=tmp;
        }
        System.out.println("Сумма элементов массива = " + sum);
    }

    public static void printPositiveCount(int[] mas) /*Вывод на экран количесво положительных элементов массива*/{
        int count = 0;
        for (int tmp:mas) {
            if(tmp>0)
            count++;
        }
        System.out.println("Количество положительных элементов массива = " + count);
    }

    public static void Sort(int[] mas) /* Пузырьковая сортировка массива*/{
        boolean bool;
        do {
            bool = false;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    int tmp = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = tmp;
                    bool = true;
                }
            }
        }
        while (bool);
    }
}


