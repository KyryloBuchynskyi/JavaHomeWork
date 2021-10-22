package com.pb.buchinskyi.hw4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        System.out.println("Проверка двух строк на наличе анаграммы");
        String str1 = strGen();//"Аз есмь строка, живу я, мерой остр.";
        String str2 = strGen("вторую строку: ");//"За семь морей ростка я вижу рост.";
        System.out.println(isAnagram(str1, str2));
    }

    public static String isAnagram(String str1, String str2) {
        String delimeter = "[^a-zA-Zа-яА-Я]"; // Разделитель

        //стоит пояснить, что я тут делаю
        //1. Заменяю все символы кроме букв рус и англ алфавита на пробелы
        //2. Перевожу в нижний регистр
        //3. Убираю пробелы в конце строки
        //4. Убираю повторяющиеся пробеолы всередине, которые появляются при наличии нескольких знаков пунктуации или пробелов подряд
        String hash1 = noSpaces(str1.replaceAll(delimeter, " ").toLowerCase().trim());
        String hash2 = noSpaces(str2.replaceAll(delimeter, " ").toLowerCase().trim());

        //Проверка на эдентичность строк. Если они просто одинаковы - это не анаграмма
        if (hash1.equals(hash2))
            return "Строки идентичны";

        //Проверяем на наличие слов из строки 1 в строке 2
        //Для этого разделаю строку на отдельные слова через пробел
        String[] subStr1 = hash1.split(" ");
        String[] subStr2 = hash2.split(" ");

        //1. Если есть на каждое слово 1 строки совпадение во второй - будет тру
        boolean isA = true;
        for (String tmp1 : subStr1) {
            boolean isTmp = false;
            for (String tmp2 : subStr2)
                // есди хоть одно совпадние из второй строки - будет тру, на текущее слово 1й строки
                isTmp = isTmp || isEqual(tmp1, tmp2);
            isA = isA && isTmp; //Есть хоть для 1 слова из первой строки не будет совпадения - будет фолс
        }

        //Проверяем, что буквы идентичны (но в другом порядке)
        isA = isA && isEqual(hash1, hash2);

        //выводим на экран
        if (isA)
            return "Данные строки являются анаграммой";
        else
            return "Данные строки не являются анаграммой";
    }

    public static boolean isEqual(String str1, String str2) { //функция проверяет соответствие кажлой буквы в отсортированных словах
        //Делим слова на буквы
        char[] tmp1 = str1.toCharArray();
        char[] tmp2 = str2.toCharArray();
        //упорядочиваем буквы в массивах по алфавиту
        Arrays.sort(tmp1);
        Arrays.sort(tmp2);

        //Трай на тот случай если слова разного размера, а именно - первое слово больше (можно поменять на ИФ)
        try {
            for (int i = 0; i < tmp1.length; i++) {
                if (tmp1[i] != tmp2[i])
                    return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String noSpaces(String str) {//функция удаления повторяюзихся пробелов
        //контроль длинны слова. Если длинна не изменится после замены 2х пробелов - значит уже нет 2йных пробелов
        int length;
        do {
            length = str.length();
            str = str.replaceAll("  ", " ");
        } while (length != str.length());

        //возвращаем строку без 2йных пробелов
        return str;
    }

    public static String strGen() {//Запрос ввода строки
        System.out.print("Введите, пожалуйста, строку: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
            try {
                return reader.readLine();
            } catch (Exception e) {
                System.out.print("Произошла ошибка, введите, пожалуйста, еще раз: ");
            }
    }

    public static String strGen(String predtekst) {//Запрос ввода строки
        System.out.print("Введите, пожалуйста, " + predtekst);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
            try {
                return reader.readLine();
            } catch (Exception e) {
                System.out.print("Произошла ошибка, введите, пожалуйста, еще раз: ");
            }
    }

}
