package com.pb.buchinskyi.pw5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
Имеет перегруженные методы takeBook(), returnBook():


 */
public class Reader {
    //Привачу поля класса
    private String FIO;
    private int libraryCard;
    private String faculty;
    private Date dateOfBirth;
    private String phoneNumber;

    //с этой переменной вообще вопрос. Я так и не понял, нужно ли ее использовать в задаче или я перемудрил
    private Book[] books;

    //Пошли 2 конструктора
    public Reader() {
        this("Mr. Incognito", 0, "Faculty of Incognito", Calendar.getInstance().getTime(), "+380931231212");
    }

    public Reader(String FIO, int libraryCard, String faculty, Date dateOfBirth, String phoneNumber) {
        this.FIO = FIO;
        this.libraryCard = libraryCard;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        books = new Book[0];
    }

    //геттеры на все случаи жизни (кроме книг)
    public String getFIO() {
        return FIO;
    }

    public int getLibraryCard() {
        return libraryCard;
    }

    public String getFaculty() {
        return faculty;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Сеттеры на все случаи жизни (кроме книг)
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setLibraryCard(int libraryCard) {
        this.libraryCard = libraryCard;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Приватный геттер, что бы нельзя было достучаться извне класса. Только для личного пользования при добавлении книг
    // Нужен, так как приходится увеличивать массив в размерах
    private void addBook() {
        int length = this.books.length;
        Book[] tmp = new Book[length + 1];
        System.arraycopy(this.books, 0, tmp, 0, length);
        tmp[length] = new Book();
        books = tmp;
    }

    // то же самое, но добавление книги по названию и без автора года
    private void addBook(String s) {
        int length = this.books.length;
        Book[] tmp = new Book[length + 1];
        System.arraycopy(this.books, 0, tmp, 0, length);
        tmp[length] = new Book(s);
        books = tmp;
    }

    // полноценное добавлении книги
    private void addBook(Book book) {
        int length = this.books.length;
        Book[] tmp = new Book[length + 1];
        System.arraycopy(this.books, 0, tmp, 0, length);
        try {
            tmp[length] = book.clone();
        } catch (Exception e) {
            System.out.println("Not Clown");
        }
        books = tmp;
    }

    // По-сути, геттер, но приватный. Плюс, возвращаю тру или волс, в зависимости от того, нашел ли соответствующую книгу или нет
    private boolean retBook() {
        int length = books.length;
        if (length == 0) {
            System.out.println("I haven't any books");
            return false;
        }
        Book[] b = new Book[length - 1];
        boolean bool = true;
        Book emptyBook = new Book();
        try {
            for (int i = 0, j = 0; i < length; i++) {
                if (this.books[i].equals(emptyBook) && bool) {
                    bool = false;
                    continue;
                }
                b[j] = this.books[i];
                j++;
            }
        } catch (Exception e) {
            System.out.println("Sorry, i lost this book");
            return false;
        }
        books = b;
        return true;
    }

    // По-сути, геттер, но приватный. Плюс, возвращаю тру или волс, в зависимости от того, нашел ли соответствующую книгу или нет
    private boolean retBook(String s) {
        int length = books.length;
        if (length == 0) {
            System.out.println("I haven't any books");
            return false;
        }
        Book[] b = new Book[length - 1];

        Book emptyBook = new Book(s);
        boolean bool = true;
        try {
            for (int i = 0, j = 0; i < length; i++) {
                if (bool && this.books[i].equals(emptyBook)) {
                    bool = false;
                    continue;
                }
                b[j] = this.books[i];
                j++;
            }
        } catch (Exception e) {
            System.out.println("Sorry, i lost this book");
            return false;
        }
        books = b;
        return true;
    }

    // По-сути, геттер, но приватный. Плюс, возвращаю тру или волс, в зависимости от того, нашел ли соответствующую книгу или нет
    private boolean retBook(Book book) {
        int length = books.length;
        if (length == 0) {
            System.out.println("I haven't any books");
            return false;
        }
        Book[] b = new Book[length - 1];
        boolean bool = true;
        try {

            for (int i = 0, j = 0; i < length; i++) {
                if (bool && this.books[i].equals(book)) {
                    bool = false;
                    continue;
                }
                b[j] = this.books[i];
                j++;
            }
        } catch (Exception e) {
            System.out.println("Sorry, i lost this book");
            return false;
        }
        books = b;
        return true;
    }

    //Наконецто пошли задания
    /*
    - takeBook, который будет принимать количество взятых книг.
    Выводит на консоль сообщение
    "Петров В. В. взял 3 книги".
     */
    public void takeBook(int count) {
        for (int i = 0; i < count; i++)
            addBook();
        System.out.println(getFIO() + " взял " + count + " книг");
    }

    /*
    - takeBook, который будет принимать переменное количество названий книг.
    Выводит на консоль сообщение
    "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
     */
    public void takeBook(String... books) {
        System.out.print(getFIO() + " взял книги: ");
        for (String s : books) {
            addBook(s);
            System.out.print(s + ", ");
        }
        System.out.println("\b\b");
    }

    /*
    - takeBook, который будет принимать переменное количество объектов класса Book.
    Выводит на консоль сообщение
    "Петров В. В. взял книги: Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".
     */
    public void takeBook(Book... books) {
        System.out.print(getFIO() + " взял книги: ");
        for (Book s : books) {
            addBook(s);
            System.out.print(s.getName() + " (" + s.getAuthor() + " " + s.getYear() + "г.), ");
        }
        System.out.println("\b\b");
    }

    /*
    Аналогичным образом перегрузить метод returnBook().
    Должно быть 3 метода returnBook() которые выводит на консоль сообщения:
    - "Петров В. В. вернул 3 книги"
    - "Петров В. В. вернул книги: Приключения, Словарь, Энциклопедия".
    - "Петров В. В. вернул книги: Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".
     */
    public void returnBook(int count) {
        for (int i = 0; i < count; i++) {
            if (!retBook())
                return;
        }
        System.out.println(getFIO() + " вернул " + count + " книг");
    }

    public void returnBook(String... books) {
        System.out.print(getFIO() + " вернул книги: ");
        for (String s : books) {
            if (!retBook(s))
                return;
            System.out.print(s + ", ");
        }
        System.out.println("\b\b");
    }

    public void returnBook(Book... books) {
        System.out.print(getFIO() + " вернул книги: ");
        for (Book s : books) {
            if (!retBook(s))
                return;
            System.out.print(s.getName() + " (" + s.getAuthor() + " " + s.getYear() + "г.), ");
        }
        System.out.println("\b\b");
    }

    // Добавил для моего удоства, что бы из библиотеки принтить начинку читателя
    public void PrintReader() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Имя: " + getFIO() + "\n Читательский билет: " + getLibraryCard() + "\n Факультет: " + getFaculty() + "\n Дата рождения: " + dateFormat.format(getDateOfBirth()) + "\n Моб. тел.: " + getPhoneNumber() + "\n Количество книг: " + books.length);
    }

    // то же самое, только печать книг
    public void PrintBooks() {
        System.out.println("Книги " + getFIO() + " :");
        for (Book b : books)
            System.out.println(b);
    }
}
