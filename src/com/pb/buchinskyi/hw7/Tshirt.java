package com.pb.buchinskyi.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {
    public Tshirt()
    {
        super();
    }

    public Tshirt(Size size, int cost, String color)
    {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Футболка." + this);
    }

    @Override
    public void dressWomen() {
        System.out.println("Футболка." + this);
    }
}
