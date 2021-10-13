package com.pb.buchinskyi.hw2;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand1 = 0, operand2 = 0; // переменные для ввода чисел
        String sign = "";  // Знак операции
        Scanner in = new Scanner(System.in);  // Класс для работы с консолью
        boolean wrongIn = false;  // Выделываюсь. Хочу, что бы не вылетало при вводе буквы

        do {
            System.out.print("Первое число = ");
            if (in.hasNextInt()) // проверка что введено число
            {
                operand1 = in.nextInt();
                wrongIn = false;
            } else {
                in.next(); // Чистим нашу консоль ввода, забирая из нее все данные, иначе введенный символ останется и зациклит все
                wrongIn = true;
                System.out.println("Введите, пожалуйста, целое число");
            }
        } while (wrongIn);

        wrongIn = false;
        do {
            System.out.print("Второе число = ");
            if (in.hasNextInt()) // проверка что введено число
            {
                operand2 = in.nextInt();
                wrongIn = false;
            } else {
                in.next(); // Чистим нашу консоль ввода, забирая из нее все данные, иначе введенный символ останется и зациклит все
                wrongIn = true;
                System.out.println("Введите, пожалуйста, целое число");
            }
        } while (wrongIn);

        wrongIn = true;
        do {
            System.out.print("Знак математической операции = ");
                sign = in.next();
                if (sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/")) // проверяем, что введена только одна из операций + - / * (как оказалось тут операция сравнения проверяет адреса наших обьектов в памяти, потому исползуем встроенную функцию сравнения данных
                    wrongIn = false;
                else
                    System.out.println("Введите, пожалуйста, операцию из списка [+-/*]");

        } while (wrongIn);

        // собственно, наши мат вычисления
        System.out.printf("%d %s %d = ", operand1, sign, operand2); // вывожу на экран итоговую формулу без расчета
        switch (sign) {
            case "+":
                System.out.println(operand1 + operand2);
                break;
            case "-":
                System.out.println(operand1 - operand2);
                break;
            case "*":
                System.out.println(operand1 * operand2);
                break;
            case "/":
                if (operand2 != 0) // вылавливаем ошибку деления на 0
                    System.out.println(operand1 / operand2);
                else
                    System.out.println("Error: Divide by zero!!!"); // Докладываем об ошибке деления на 0
                break;
            default:
                System.out.println("Error: Unexpected sing"); // На всяк случай, хоть я заранее и проверяю тип операции
        }
    }
}
