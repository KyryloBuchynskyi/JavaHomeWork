package com.pb.buchinskyi.hw7;

public class Skirt extends Clothes implements WomenClothes {
    public Skirt()
    {
        super();
    }

    public Skirt(Size size, int cost, String color)
    {
        super(size, cost, color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Юбка." + this);
    }

}
