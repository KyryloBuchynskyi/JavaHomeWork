package com.pb.buchinskyi.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    public Pants()
    {
        super();
    }

    public Pants(Size size, int cost, String color)
    {
        super(size, cost, color);
    }
    @Override
    public void dressMan() {
        System.out.println("Штаны." + this);
    }

    @Override
    public void dressWomen() {
        System.out.println("Штаны." + this);
    }
}
