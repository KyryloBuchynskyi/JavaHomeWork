package com.pb.buchinskyi.hw7;

public class Tie extends Clothes implements ManClothes {

    public Tie()
    {
        super();
    }

    public Tie(Size size, int cost, String color)
    {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук." + this);
    }
}