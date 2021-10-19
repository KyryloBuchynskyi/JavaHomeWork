package com.pb.buchinskyi.hw3;

import java.util.Random;
import java.util.Scanner;

/*
1. Написать программу игру “Bingo”.
Создайте класс Bingo в пакете hw3.
Программа должна загадать целое число в диапазоне от 0 до 100 и предложить пользователю его отгадать.
При вводе числа пользователем, программа проверяет на соответствие с загаданным число и если числа совпали вывести сообщение о том, что число отгадано.
Если числа не совпали, тогда следует вывести надпись о том, что задуманное число является больше или меньше вводимого.
Также программа ведет подсчет попыток, и выводит это количество после того как число угадали.
Предусмотреть возможность досрочного завершения программы, в случае если пользователь не желает продолжать угадывать число.
 */

public class Bingo {
    public static void main(String[] args) {
        String answer; // ввод пользователя
        Scanner scanner = new Scanner(System.in);//вычитка с консоли
        int tries;//кол-во попыток
        int pcNum = generateNumber();//получаем случайное число 0 - 100
        int count = 0;//кол-во попыток
        System.out.println("Игра в 'Кальмара'");
        Rules();//выводим правила на экран
        System.out.println("Хотите начать?");
        do {
            try {
                System.out.print("Ваш ответ:");
                tries = scanner.nextInt();
                count++;

                if (tries > pcNum) {
                    System.out.println("Загадайте меньшее число");
                } else if (tries < pcNum) {
                    System.out.println("Загадайте большее число");
                } else {
                    System.out.println("Bingo!");
                    System.out.println("Количество попыток(умерших) = " + count);
                    System.out.println("Общий бюджет увеличин на = " + count * 1000000 + " Грн");
                    break;
                }
            } catch (Exception e) {
                answer = scanner.next();
                switch (answer) {
                    case "Y":
                        break;
                    case "N":
                    case "Exit": {
                        System.out.println("Игра для вас закончилась!");
                        return;
                    }
                    case "Help": {
                        Rules();
                        break;
                    }
                    default: {
                        System.out.println("Тише, не паникуй - выпускаю");
                        return;
                    }

                }
            }

        } while (true);

    }

    public static int generateNumber()//генератор случайных чисел [0 ; 100]
    {
        return new Random().nextInt(101);
    }

    public static void Rules()//правила игры
    {
        System.out.println("Правила:");
        System.out.println("1. Вам нужно угадать целое число, загаданное ПК");
        System.out.println("2. Если вы угадаете - игра завершится с надписью 'Bingo'. Вы - победитель.");
        System.out.println("3. Если загаданное число, будет больше - вы увидите фразу 'Загадайте большее число'");
        System.out.println("4. Если загаданное число, будет меньше - вы увидите фразу 'Загадайте меньшее число'");
        System.out.println("5. Для окончания игры:");
        System.out.println("      - Угадайте число");
        System.out.println("      - Напишите N/Exit");
        System.out.println("      - Напишите любой текст, не соответствующий числу");
        System.out.println("6. Помните, что отказавшись, игрок выбывает из игры...");
        System.out.println("7. Для вызова справки напишите Help");
        System.out.println("8. Для начала напишите Y или любое число");
    }

}
