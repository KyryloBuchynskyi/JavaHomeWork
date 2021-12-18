package com.pb.buchinskyi.hw11;

import org.omg.CORBA.FixedHolder;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

public class Person implements Serializable {
    private final static long serialVersionUID = 42;

    private String FIO;
    private Calendar DOB;
    private String address;

    private HashSet<String> phones = new HashSet<>();

    private Date redact;

    public Person(String FIO, Calendar DOB, String address) {
        this.FIO = FIO;
        this.DOB = DOB;
        this.address = address;

        redact = new Date();
    }

    public Person(String FIO, Calendar DOB, String address, String... phones) {
        this(FIO, DOB, address);

        for (String phone : phones) {
            this.phones.add(phone);
        }
    }

    public String getFIO() {
        return FIO;
    }

    public Calendar getDOB() {
        return DOB;
    }

    public String getAddress() {
        return address;
    }

    public HashSet<String> getPhones() {
        return phones;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setDOB(Calendar DOB) {
        this.DOB = DOB;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void addPhones(String... phones) {
        for (String s : phones) {
            this.phones.add(s);
        }
    }

    public void deletePhone(String phone) {
        phones.remove(phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getFIO(), person.getFIO()) && Objects.equals(getDOB(), person.getDOB()) && Objects.equals(getAddress(), person.getAddress()) && Objects.equals(getPhones(), person.getPhones());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFIO(), getDOB(), getAddress(), getPhones());
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        int i = 0;
        if (phones != null)
            for (String phone : phones) {
                str.append("\t\t");
                str.append(++i);
                str.append(") ");
                str.append(phone);
                str.append("\n");
            }
        SimpleDateFormat s = new SimpleDateFormat("dd.MM.YYYY");
        return "FIO: " + FIO +
                "\n\t DOB: " + s.format(DOB.getTime()) +
                "\n\t address: " + address +
                "\n\t phones: \n" + str.toString() +
                "\t last redact: " + redact + "\n";
    }
}
