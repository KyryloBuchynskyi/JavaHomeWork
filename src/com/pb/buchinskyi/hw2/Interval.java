package com.pb.buchinskyi.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        int operand1 = 0;// переменные для ввода чисел
        Scanner in = new Scanner(System.in);  // Класс для работы с консолью
        boolean wrongIn;  // Выделываюсь. Хочу, что бы не вылетало при вводе буквы

        do {
            System.out.print("Введите число = ");
            if (in.hasNextInt()) // проверка что введено число
            {
                operand1 = in.nextInt();
                wrongIn = false; // что бы выйти из цикла
            } else {
                in.next(); // Чистим нашу консоль ввода, забирая из нее все данные, иначе введенный символ останется и зациклит все
                wrongIn = true;
                System.out.println("Введите, пожалуйста, целое число");
            }
        } while (wrongIn);

        // Вариант решения через IF
        /*
        if (operand1 < 0)
            System.out.println("Число не входит ни в один из имеющихся промежутков");
        else if (operand1 < 15)
            System.out.println("Число в промежутке [0 - 14]");
        else if (operand1 < 36)
            System.out.println("Число в промежутке [15 - 35]");
        else if (operand1 < 51)
            System.out.println("Число в промежутке [36 - 50]");
        else if (operand1 < 101)
            System.out.println("Число в промежутке [51 - 100]");
        else
            System.out.println("Число не входит ни в один из имеющихся промежутков");
        */

        // Вариант решения через SWITCH (Вызов озвученный в лекции принят)
        switch (operand1) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                System.out.println("Число в промежутке [0 - 14]");
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                System.out.println("Число в промежутке [15 - 35]");
                break;
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
                System.out.println("Число в промежутке [36 - 50]");
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
                System.out.println("Число в промежутке [51 - 100]");
                break;
            default:
                System.out.println("Число не входит ни в один из имеющихся промежутков");
        }
    }
}
