public class UserInterface {
    public static void main(String[] args) {
        //creating beef burger with French fry and cheese
        System.out.println("Item 1: Beef burger with French fry and cheese...");
        System.out.println("-------------------------------------------------");
        Burger item1 = new Beef();
        item1 = new FrenchFires(item1);
        item1 = new DefaultCheese(item1);

        item1.serve();
        System.out.println("Total Price: " + item1.getPrice() + '\n');


        //creating veggi Burger with onion rings and Bottle of Water
        System.out.println("Item 2: Veggi Burger with onion rings and Bottle of Water...");
        System.out.println("------------------------------------------------------------");
        Burger item2 = new Veggi();
        item2 = new OnionRings(item2);
        item2 = new Water(item2);

        item2.serve();
        System.out.println("Total Price: " + item2.getPrice() + '\n');


        //creating a combo meal with Veggi burger, French Fry and Coke
        System.out.println("Item 3: A combo meal with Veggi burger, French Fry and Coke...");
        System.out.println("--------------------------------------------------------------");
        Burger item3 = new Veggi();
        item3 = new FrenchFires(item3);
        item3 = new Coke(item3);

        item3.serve();
        System.out.println("Total Price: " + item3.getPrice() + '\n');


        //creating a combo meal with Veggi burger, Onion Rings, Coffee and Water
        System.out.println("Item 4: A combo meal with Veggi burger, Onion Rings, Coffee and Water...");
        System.out.println("------------------------------------------------------------------------");
        Burger item4 = new Veggi();
        item4 = new OnionRings(item4);
        item4 = new Coffee(item4);
        item4 = new Water(item4);

        item4.serve();
        System.out.println("Total Price: " + item4.getPrice() + '\n');

        //creating a Beef burger only
        System.out.println("Item 4: Beef burger only...");
        System.out.println("---------------------------");
        Burger item5 = new Beef();

        item5.serve();
        System.out.println("Total Price: " + item5.getPrice() + '\n');

        /*
        price list:
        Beef: 30
        Chicken: 20
        Veggi: 10
        Cheese: 5
        Coffee: 15
        Coke: 5
        Water: 1
        Onion Rings: 5
        French Fries: 5
        */
    }
}
