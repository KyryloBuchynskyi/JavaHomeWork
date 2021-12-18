package com.pb.buchinskyi.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.nio.file.Paths;
import java.util.GregorianCalendar;

/*
Создать в пакете hw11 консольное приложение "Телефонная книга".
Каждый элемент должен иметь:
ФИО
дата рождения
адрес

телефоны (количество не ограничено)


дата и время редактирования
 */
public class PhoneBook {
    public static void main(String[] args) {
        Book b = new Book();
        //Test

        b.addPerson("Кирилл", new GregorianCalendar(1991,03,20),"Днепр, Добровольцев 6","+380931126981", "00000");
        b.addPerson("Славик", new GregorianCalendar(2000,04,21),"Днепр, Рабочая 36","+380631111111");
        b.addPerson("Алена", new GregorianCalendar(1996,05,21),"Днепр, Слобожанского 36");
        b.print();
        b.delPerson(0);
        b.print();
        b.sortFIO();
        b.changePersonFIO(0,"Aly");
        b.sortDOB();

        b.safe();

        b.load();
        b.print();
     }
}
