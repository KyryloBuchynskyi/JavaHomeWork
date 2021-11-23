package com.pb.buchinskyi.hw10;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class Main {
    public static void main(String[] args) {
        NumBox<Float> numBox = new NumBox(10);
        NumBox<Integer> numBox2 = new NumBox(10);
        try
        {
            numBox.add(1.0F);
            numBox.add(2.0F);
            numBox.add(3.1F);
            numBox.add(4.2F);
            numBox.add(15 / 2.9F);
            numBox.add(6F);
            numBox.add(7F);
            numBox.add(8F);
            numBox.add(9F);
            numBox.add(10F);

            numBox2.add(1);
            numBox2.add(2);
            numBox2.add(3);
            numBox2.add(4);
            numBox2.add(5);
            numBox2.add(6);
            numBox2.add(7);
            numBox2.add(8);
            numBox2.add(9);
            numBox2.add(10);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        test(numBox, "numBox");
        test(numBox2, "numBox2");
    }

    public static void test(NumBox numBox, String name) {
        try {
            System.out.println(name + ".length = " + numBox.length());

            System.out.print(name + "[ ");
            for (int i = 0; i < numBox.length(); i++)
                System.out.print(numBox.get(i) + " ");
            System.out.println("]");

            System.out.println(name + ".average = " + numBox.average());

            System.out.println(name + ".sum = " + numBox.sum());

            System.out.println(name + ".max = " + numBox.max());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
