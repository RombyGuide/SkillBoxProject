package BasketProducts_10;

public class Main {
    public static void main(String[] args) {
        Basket firstBasket = new Basket();
        firstBasket.add("Milk", 40, 4, 2.5);
        firstBasket.print("Milk");
        System.out.println(firstBasket.getTotalPrice());
        System.out.println(firstBasket.getTotalWeight() + "\n");

        Basket secondBasket = new Basket();
        secondBasket.add("Apple juice", 100);
        secondBasket.add("Lime juice", 100);
        secondBasket.print("Juice");
        System.out.println(secondBasket.getTotalPrice());

        System.out.println("\n" + "Кол-во корзин: " + Basket.getCount());
        System.out.println("Общая цена всех корзин: " + Basket.getTotalCost() + " руб.");
        System.out.println("Общее количество товара всех корзин: " + Basket.getTotalAmount() + " товаров" + "\n");
        System.out.println("Средняя цена товара всех корзин: " + Basket.averagePrice() + " руб.");
        System.out.println("Средняя стоимость корзины: " + Basket.averageCost() + " руб.");
    }
}
