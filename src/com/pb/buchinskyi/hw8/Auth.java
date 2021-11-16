package com.pb.buchinskyi.hw8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Auth {
    private String login;
    private String password;

    public Auth()
    {
        login = "Empty";
        password = "Empty";
    }
//Проверяет параметр login, длинна должна быть от 5 до 20 символов. Login должен содержать только латинские буквы и цифры
    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException
    {
        //Проверяет параметр login, длинна должна быть от 5 до 20 символов. Login должен содержать только латинские буквы и цифры
        Pattern patternLog = Pattern.compile("[a-zA-Z]{5,20}");
        Matcher matcherLog = patternLog.matcher(login);
        if(!matcherLog.matches())
            throw new WrongLoginException("Логин должен содержать от 5 до 20 символов латинского алфавита");

        //Проверяет параметр password, длинна более 5, только латинские буквы и цифры и знак подчеркивания.
        Pattern patternPas = Pattern.compile("[a-zA-Z0-9_]{5,}");
        Matcher matcherPas = patternPas.matcher(confirmPassword);
        if(!matcherPas.matches())
            throw new WrongPasswordException("Пароль должен быть от 5 символов латинского алфавита, цифр и знака '_'");

        if (!password.equals(confirmPassword))
            throw new WrongPasswordException("Пароли не совпадают");

        this.login = login;
        this.password = password;
    }

    public void signIn(String login, String password) throws WrongLoginException
    {
        if (this.login.equals(login)&&this.password.equals(password))
            System.out.println("Вы успешно вошли на сайт");
        else
            throw new WrongLoginException("Данные учетной записи введены не корректно");
    }
}
