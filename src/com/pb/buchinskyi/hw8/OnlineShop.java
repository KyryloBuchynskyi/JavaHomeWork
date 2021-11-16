package com.pb.buchinskyi.hw8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OnlineShop {
    public static void main(String[] args) {
        Auth a = new Auth();
        boolean b;
        System.out.println("Зарегестрируйтесь, пожалуйста, на нашем сайте");
        do {
            if (!(b = signUp(a)))
                System.out.println("\nМиша, все плохо - давай по новой!)");
        }
        while (!b);

        System.out.println("Регистрация прошла успешно!");
        System.out.println("\nВойдите, пожалуйста, в ваш личный кабинет");
        do {
            if (!(b = signIn(a)))
                System.out.println("\nМиша, все плохо - давай по новой!)");
        }
        while (!b);
    }

    static public boolean signIn(Auth a) {
        System.out.println("Введите, пожалуйста, данные для входа:");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\tЛогин:\t");
            String login = reader.readLine();
            System.out.print("\tПароль:\t");
            String password = reader.readLine();
            a.signIn(login, password);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка ввода\t" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.print("Ошибка ридера");
        }
        return true;
    }

    static public boolean signUp(Auth a) {
        System.out.println("Введите, пожалуйста, регистрационные данные:");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\tЛогин:\t");
            String login = reader.readLine();
            System.out.print("\tПароль:\t");
            String password = reader.readLine();
            System.out.print("\tВведите пароль еще раз:\t");
            String rePassword = reader.readLine();
            a.signUp(login, password, rePassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка ввода\t" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.print("Ошибка ридера");
        }
        return true;
    }
}
