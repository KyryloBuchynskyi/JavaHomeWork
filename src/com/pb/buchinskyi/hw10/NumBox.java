package com.pb.buchinskyi.hw10;

public class NumBox<T extends Number> {
    private T[] mas;
    private int index;

    public NumBox(int length) {
        mas = (T[]) new Number[length];
    }

    public void add(T num) throws Exception {
        if (index < mas.length) {
            mas[length() - 1] = num;
            index++;
        } else throw new Exception("The stockpile is full my Lord");
    }

    public T get(int index) throws Exception {
        if (index < mas.length)
            return mas[index];
        throw new Exception("Out of the range");
    }

    int length() {
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == null)
                return i+1;
        }
        return mas.length;
    }

    public double average() {
        return sum() / length();
    }

    public double sum() {
        double sum = 0;
        for (int i = 0; i < length(); i++)
            sum += mas[i].doubleValue();
        return sum;
    }

    public T max() {
        if (length() == 0)
            return null;
        T max = mas[0];
        for (int i = 1; i < length(); i++) {
            if (max.doubleValue() < mas[i].doubleValue())
                max = mas[i];
        }
        return max;
    }
}
