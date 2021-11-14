package com.pb.buchinskyi.pw7;

public class Atelier {

    public enum Size {
        XXS("Детский", 32),
        XS("Детский", 34),
        S("Подростоковый", 36),
        M("Подростоковый", 38),
        L("Взрослый", 40);

        private String description;
        private int EuroSize;

        Size(String description, int EuroSize) {
            this.description = description;
            this.EuroSize = EuroSize;
        }

        public String getDescription() {
            return description;
        }

        public int getEuroSize() {
            return EuroSize;
        }

        @Override//Юху! Переопрелеоио в энуме ту стринг, для более удобного вывода информации на эран
        public String toString() {
            return "Размер:" + " (" + name() + '\\' + getEuroSize() + ") - " + getDescription();
        }

    }

    public interface ManClothes {
        void dressMan();
    }

    public interface WomenClothes {
        void dressWomen();
    }

    public static abstract class Clothes {
        protected Size size;
        protected int cost;
        protected String color;

        protected Clothes() {
            size = Size.S;
            color = "It taste like a rainbow";
            cost = 1;
        }

        protected Clothes(Size size, int cost, String color) {
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

    public static class Tshirt extends Atelier.Clothes implements ManClothes, WomenClothes {
        public Tshirt() {
            super();
        }

        public Tshirt(Size size, int cost, String color) {
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

    public static class Pants extends Clothes implements ManClothes, WomenClothes {
        public Pants() {
            super();
        }

        public Pants(Size size, int cost, String color) {
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

    public static class Skirt extends Clothes implements WomenClothes {
        public Skirt() {
            super();
        }

        public Skirt(Size size, int cost, String color) {
            super(size, cost, color);
        }

        @Override
        public void dressWomen() {
            System.out.println("Юбка." + this);
        }
    }

    public static class Tie extends Clothes implements ManClothes {

        public Tie() {
            super();
        }

        public Tie(Size size, int cost, String color) {
            super(size, cost, color);
        }

        @Override
        public void dressMan() {
            System.out.println("Галстук." + this);
        }

    }

    public static void main(String[] args) {
        Clothes[] cloth = new Clothes[]{
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
        for (Clothes c : clothes) {
            if (c instanceof ManClothes)
                ((ManClothes) c).dressMan();
        }
    }

    public static void dressWomen(Clothes[] clothes)//Одеваем женщин и льстим что девушке=)
    {
        System.out.println("\nОдеваем девушку:");
        for (Clothes c : clothes) {
            if (c instanceof WomenClothes)
                ((WomenClothes) c).dressWomen();
        }
    }
}
