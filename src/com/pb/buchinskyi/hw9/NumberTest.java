package com.pb.buchinskyi.hw9;

public class NumberTest {
    public static void main(String[] args) {
        FileNumbers f = new FileNumbers("files/numbers.txt", "files/odd-numbers.txt");
        f.createNumbersFile(1,99);
        f.createOddNumbersFile();
    }
}
