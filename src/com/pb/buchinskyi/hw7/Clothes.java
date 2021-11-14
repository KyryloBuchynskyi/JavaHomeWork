package com.pb.buchinskyi.hw7;

public abstract class Clothes {
    protected Size size;
    protected int cost;
    protected String color;

    protected Clothes()
    {
        size = Size.S;
        color = "It taste like a rainbow";
        cost = 1;
    }

    protected Clothes(Size size, int cost, String color)
    {
        this.size = size;
        this.color = color;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return
                "\n\t" + size +
                "\n\tЦена:\t" + cost +
                "\n\tЦвет:\t" + color;
    }
}
