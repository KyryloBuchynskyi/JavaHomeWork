package com.pb.buchinskyi.hw7;

public class Atelier {
    public static void main(String[] args) {
        Clothes [] cloth = new Clothes[]{
        new Tshirt(Size.S, 100, "Зеленый"),
        new Tshirt(Size.L, 200, "Красный"),
        new Tshirt(Size.XXS, 300, "Белый"),
        new Pants(Size.XS, 400, "Черный"),
        new Pants(Size.S, 300, "Зеленый"),
        new Skirt(Size.XXS, 150, "Черный"),
        new Skirt(Size.L, 200, "Розовый"),
        new Skirt(Size.S, 240, "Красный в черную клеточку"),
        new Tie(Size.S, 1000, "Черный"),
        new Tie(Size.XS, 10000, "Коричневый")};

        dressMan(cloth);
        dressWomen(cloth);
    }

    public static void dressMan(Clothes[] clothes)//Одеваем мужчин
    {
        System.out.println("\nОдеваем мужчину:");
        for (Clothes c:clothes) {
            if(c instanceof ManClothes)
                ((ManClothes)c).dressMan();
        }
    }
    public static void dressWomen(Clothes[] clothes)//Одеваем женщин и льстим что девушке=)
    {
        System.out.println("\nОдеваем девушку:");
        for (Clothes c:clothes) {
            if(c instanceof WomenClothes)
                ((WomenClothes)c).dressWomen();
        }
    }
}
