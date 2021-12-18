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
        System.out.println("Заполнили телефонную книгу");
        b.addPerson("Кирилл", new GregorianCalendar(1991,03,20),"Днепр, Добровольцев 6","+380931126981", "00000");
        b.addPerson("Славик", new GregorianCalendar(2000,04,21),"Днепр, Рабочая 36","+380631111111");
        b.addPerson("Алена", new GregorianCalendar(1996,05,21),"Днепр, Слобожанского 36");
        System.out.println("Вывели");
        b.print();
        System.out.println("Удалили того, кто на нулевом индексе");
        b.delPerson(0);
        System.out.println("Вывели");
        b.print();
        System.out.println("Отсоритировали по ФИО");
        b.sortFIO();
        System.out.println("Поменли имя");
        b.changePersonFIO(0,"Aly");
        System.out.println("Отсортировали по дате рождения");
        b.sortDOB();
        System.out.println("Кто на первом индексе");
        System.out.println(b.getPerson(1));
        System.out.println("Сохранили");
        b.safe();
        System.out.println("Загрузили");
        b.load();
        System.out.println("Вывели");
        b.print();
     }
}
