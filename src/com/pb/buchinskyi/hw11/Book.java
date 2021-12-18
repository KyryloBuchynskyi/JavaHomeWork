package com.pb.buchinskyi.hw11;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

/*
Обеспечить следующий функционал:
+добавление элемента
+удаление элемента
+поиск элементов
+вывод всех записей с сортировкой по указанному полю (можно ограничиться двумя на выбор)
+редактирование элемента
+запись в файл всех данных
+загрузка из файла всех данных
 */

public class Book {
    private LinkedList<Person> person;

    public Book() {
        person = new LinkedList<>();
    }

    public Book(String FIO, Calendar DOB, String address) {
        this();
        addPerson(FIO, DOB, address);
    }

    public Book(String FIO, Calendar DOB, String address, String... phones) {
        this();
        addPerson(FIO, DOB, address, phones);
    }

    public void addPerson(String FIO, Calendar DOB, String address) {
        this.person.add(new Person(FIO, DOB, address));
    }

    public void addPerson(String FIO, Calendar DOB, String address, String... phones) {
        this.person.add(new Person(FIO, DOB, address, phones));
    }

    public boolean delPerson(String FIO)
    {
        boolean b = false;
        Iterator<Person> iterator= person.iterator();
        while (iterator.hasNext())
        {
            Person p = iterator.next();
            if(p.getFIO().compareTo(FIO)==0)
            {
                iterator.remove();
                b = true;
            }
        }

        return b;
    }
    public boolean delPerson(int index)
    {
        return person.remove(index)==null?false:true;
    }
    public Person getPerson(String FIO)
    {
        Iterator<Person> iterator= person.iterator();
        while (iterator.hasNext())
        {
            Person p = iterator.next();
            if(p.getFIO().compareTo(FIO)==0)
            {
                return p;
            }
        }
        return null;
    }
    public Person getPerson(int index)
    {
        return person.get(index);
    }
    public void print()
    {
        for (Person p: person) {
            System.out.println(p);
        }
    }
    public void sortFIO()
    {
        person.sort(Comparator.comparing(p -> p.getFIO()));
        print();
    }
    public void sortDOB()
    {
        person.sort(Comparator.comparing(p -> p.getDOB()));
        print();
    }
    public void changePersonFIO(int index, String FIO)
    {
        person.get(index).setFIO(FIO);
    }
    public void changePersonDOB(int index, Calendar DOB)
    {
        person.get(index).setDOB(DOB);
    }
    public void changePersonAddress(int index, String address)
    {
        person.get(index).setAddress(address);
    }
    public void changePerson(int index, Person p)
    {
        person.set(index, p);
    }
    public void addPhone(int index, String phone)
    {
        person.get(index).addPhones(phone);
    }
    public void deletePhone(int index, String phone)
    {
        person.get(index).deletePhone(phone);
    }
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Person p: person) {
            str.append(p);
        }
        return str.toString();
    }
    public void safe()
    {
        try {

            File file = Paths.get("files/person.data").toFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(person);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void load()
    {
        try {

            File file = Paths.get("files/person.data").toFile();
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            person = (LinkedList<Person>) objectInputStream.readObject();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
