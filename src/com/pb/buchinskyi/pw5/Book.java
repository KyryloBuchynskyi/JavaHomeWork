package com.pb.buchinskyi.pw5;

import java.time.Year;
import java.util.Objects;

/*
Класс Book хранит такую информацию о книге:
- название
- автор книги
- год издания
 */
public class Book {
    // Скрытые поля класса
    private String name;
    private String author;
    private int year;

    // 3 конструктора, под потребности нашей задачи
    public Book() {
        setName();
        setAuthor();
        setYear();
    }

    public Book(String name) {
        setName(name);
        setAuthor();
        setYear();
    }

    public Book(String name, String author, int year) {
        setName(name);
        setAuthor(author);
        setYear(year);
    }

    //геттеры на поля класса
    public String getName() {
        return name.isEmpty() ? "" : name;
    }

    public String getAuthor() {
        return author.isEmpty() ? "" : author;
    }

    public int getYear() {
        return year;
    }

    //сеттеры на поля класса. По 2 на каждое поле (с параметром и без)
    public void setName(String name) {
        if (name.isEmpty())
            this.setName();
        else
            this.name = name;
    }

    public void setName() {
        this.name = "Story about nothing";
    }

    public void setAuthor(String author) {
        if (author.isEmpty())
            this.setAuthor();
        else
            this.author = author;
    }

    public void setAuthor() {
        this.author = "Mr. Incognito";
    }

    public void setYear(int year) {
        if (year > Year.now().getValue() || year < 0)
            this.setYear();
        else
            this.year = year;
    }

    public void setYear() {
        this.year = Year.now().getValue();
    }

    //Балуюсь
    // Но, с пользой. В дальшейшем использую в реализации класса ридеров
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    // Использую, что возвращать новый обьект класса при добавлении книг
    @Override
    protected Book clone() throws CloneNotSupportedException {
        return new Book(this.name, this.author, this.year);
    }

    //Для более удобного вывода всех полей класса, переопределяю Стринг, что бы не писать до функций
    @Override
    public String toString() {
        return "Книга: '" + name + '\'' +
                " Автор: '" + author + '\'' +
                ", Дата издания: " + year;
    }

    // В итоге, использую только тут=\
    public void Print() {
        System.out.println(this);
    }
}
