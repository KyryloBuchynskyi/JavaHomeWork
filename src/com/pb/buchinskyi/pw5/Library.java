package com.pb.buchinskyi.pw5;
/*
Класс Library используется как демонстрация работы классов Book и Reader.
Имеет метод main() в котором создается массивы объектов Book и Reader, по 3 или более элементов в каждом.
Выполняются такие действия:
- печатаются все книги.
- печатаются все читатели.
- демонстрируется работа всех вариантов методов takeBook() и returnBook().
 */

import java.util.Calendar;

public class Library {
    public static void main(String[] args) {

        //Создаем книги в библиотеке
        Book[] books = new Book[5];
        books[0] = new Book("Война и мир. Том 1", "Лев Толстой", 1863);
        books[1] = new Book("Война и мир. Том 2", "Лев Толстой", 1864);
        books[2] = new Book("Война и мир. Том 3", "Лев Толстой", 1865);
        books[3] = new Book("Война и мир. Том 4", "Лев Толстой", 1866);
        books[4] = new Book("Война и мир. Том 5", "Лев Толстой", 1867);

        //Создаем юнных и неопытных чтецов
        Reader[] readers = new Reader[3];
        readers[0] = new Reader();
        readers[1] = new Reader("Пупки В.В.", 1, "Научной фантастики", Calendar.getInstance().getTime(), "+380731234567");
        readers[2] = new Reader("Иванов И.И.", 2, "Псевдо-фантастики", Calendar.getInstance().getTime(), "+380639876543");

        //выводим на экран все книги в библиотеке
        System.out.println("Книги в библиотеке: ");
        for (Book b : books)
            b.Print();

        //выводим на экран всех чтецов
        System.out.println("Пользователи библиотеки: ");
        for (Reader r : readers)
            r.PrintReader();

        //поехали тестить функционал
        // Вариант добавления/удаления с номерами книг
        System.out.println();

        readers[0].PrintBooks();
        readers[0].returnBook(1);
        readers[0].takeBook(3);
        readers[0].returnBook(2);
        readers[0].PrintBooks();

        // Вариант добавления/удаления с названиями книг
        System.out.println();

        readers[0].PrintBooks();
        readers[0].returnBook("Война");
        readers[0].takeBook("Властелин колец 1", "Властелин колец 2", "Властелин колец 3", "Властелин колец 4");
        readers[0].returnBook("Властелин колец 1", "Властелин колец 2", "Властелин колец 3");
        readers[0].PrintBooks();

        // Вариант добавления/удаления с полноценными книгами
        System.out.println();

        readers[1].PrintBooks();
        readers[1].returnBook(books[0]);
        readers[1].takeBook(books);
        readers[1].returnBook(books[0], books[1], books[2]);
        readers[1].PrintBooks();

        // Последнего читателя не использовал, так как нет необходимости - весь функционал протестирован на 2-х
    }
}
