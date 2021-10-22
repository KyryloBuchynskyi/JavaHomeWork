package com.pb.buchinskyi.hw4;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CapitalLetter {

    public static void main(String[] args) {
        String tmp =strGen();
        System.out.println("Капитальная строка: " + capital(tmp));
        //Строка для проверки
        //Мама мыла РаМу а рАМа мокла оТ мАмы. такая грустная История эта. а ты как Пишешь свой код ? 0_о                      ?...
    }

    public static String capital(String s) { //через рекурсию режем строку на подстроки через пробел и делаем 1-ю бкуву заглавной
        int index = s.indexOf(" ");
        if (index == -1)
            return s;
        else
            return capFirstLet(s.substring(0, index)) + " " + capital(s.substring(index + 1));
    }

    public static String capFirstLet(String s) {//Делаем первую букву заглавной
        if (s == null || s.length() == 0)
            return s;

        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static String strGen() {
        System.out.print("Введите, пожалуйста, строку: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
            try {
                return reader.readLine();
            } catch (Exception e) {
                System.out.print("Произошла ошибка, введите, пожалуйста, еще раз: ");
            }
    }
}
