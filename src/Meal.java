import java.util.Scanner;

class Meal {
    private String type;
    private double price;

    public Meal() {
        price = 25;
        System.out.println("Regular burger, small coke, fries");
        System.out.println("prize: " + price);
    }

    public double getPrice() {
        return price;
    }

    public static void mealCreator(String  burger, String drink, String size, String sideItem) {
        Meal burger1 = switch (burger){
            case "Hamburger" -> new HamBurger();
            case "Delux" -> new DeluxBurger();
            case "Cheeseburger" -> new CheeseBurger();
            default -> new Burger();
        };
        Meal drink1 = switch (drink){
            case "Coke", "coke" -> new Coke(size);
            case "Juice", "juice" -> new Juice(size);
            case "Coffee", "coffee" ->new Coffee(size);
            default -> new Drink();
        };
       Meal sideItem1 = new SideItem(sideItem);

        System.out.println("yours mela: " + burger1.getClass().getSimpleName() + " " +
                drink1.getClass().getSimpleName() + " " +
                sideItem1.getClass().getSimpleName());
        System.out.println("total cost of the meal = " + (burger1.getPrice() + drink1.getPrice() +
                sideItem1.getPrice()));
    }

    public double totalPrice = 0;

    public double burgerAdderMaker(int extraToppings, double price) {

        String extraTopping;
        for (int i = extraToppings; i > 0; i--) {
            System.out.println("Pick a burger topping\nA: Ananas\nB: Beckon\nC: Cheese\n" +
                    "D: Double meet\nE: Extra sous\nF: Fire paprika\nG: Guacamole");

            Scanner s = new Scanner(System.in);
            extraTopping = s.nextLine();
            switch (extraTopping) {
                case "A", "a", "E", "e", "F", "f" -> price += 1.5;
                case "B", "b", "C", "c", "G", "g" -> price += 2.2;
                case "D", "d" -> price += 3.5;
            }
        }
        return price;
    }

}
class Burger extends Meal{

//    private String type;
//    private double price;
//    private int extraToppings;

    public Burger() {
    }
//    public double getPrice() {
//        return price;
//    }

    @Override
    public double burgerAdderMaker(int extraToppings, double price) {
        return super.burgerAdderMaker(extraToppings, price);
    }
}

class CheeseBurger extends Meal{
    private String type;
    private double price;
    private int extraToppings;

    public CheeseBurger() {
        type = "Cheeseburger";
        extraToppings = 3;
        price = 17.5 + burgerAdderMaker(extraToppings, price);
    }

    public double getPrice() {
        return price;
    }

}

class DeluxBurger extends Meal{
    private String type;
    private double price;
    private int extraToppings;

    public DeluxBurger() {
        type = "DeLux Burger";
        price = 25.5 + burgerAdderMaker(extraToppings, price);
        extraToppings = 5;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public double burgerAdderMaker(int extraToppings, double price) {
        return super.burgerAdderMaker(extraToppings, price);
    }
}
class HamBurger extends Meal{
    private String type;
    private double price;
    private int extraToppings;

    public HamBurger() {
        type = "Hamburger";
        price = 15.5 + burgerAdderMaker(extraToppings, price);
        extraToppings = 3;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public double burgerAdderMaker(int extraToppings, double price) {
        return super.burgerAdderMaker(extraToppings, price);
    }
}

class Drink extends Meal{
    private String type;
    private String size;
    private double price;

    public Drink() {
        System.out.println("Default drink");
    }

    public Drink(String type, String size) {
        drinkMaker(type, size);
    }

    public Drink(String type, String size, double price) {
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public Meal drinkMaker(String type, String size) {
        return switch (type){
            case "Coke", "coke" -> new Coke(size);
            case "Juice", "juice" -> new Juice(size);
            case "Coffee", "coffee" ->new Coffee(size);
            default -> new Drink();
        };
    }
    public double drinkPrice(String size){
        return price;
        };
}

//    public Drink(String type, String size) {
//        this.type = type;
//        this.size = size;
//
//        int sizzer = switch(size) {
//            case "small", "Small" -> 1;
//            case "medium", "Medium" -> 2;
//            case "large", "Large" -> 3;
//        };
//        prize = sizzer * switch(type) {
//            case "coke", "Coke" -> 2.5;
//            case "juice", "Juice" ->2.3;
//            case "coffee", "Coffee" ->2.75;
//        };

//        public static Drink drinkMaker(String type, String size) {
//            if(size == "small" || size == "Small"){
//                 return switch (type) {
//                    case "coke", "Coke" -> new Drink ("Coke", "Small", 2.5);
//                    case "juice", "Juice" ->new Drink ("Juice", "Small", 2.2);
//                    case "coffee", "Coffee" ->new Drink ("Coffee", "Small", 2.75);
//                };
//                case "medium" -> return switch(type){
//
//                }
//            }

class Coke extends Meal{
    private String size;
    private double price;

    public Coke(String size) {
        price = drinkPrice(size);
    }

    public double getPrice() {
        return price;
    }
    public double drinkPrice(String size){
        price = switch(size){
            case "Small", "small" -> 3.0;
            case "Medium", "medium" -> 4.5;
            case "Large", "large" -> 5.0;
            default -> 0;
        };
        return price;
    }
}

class Juice extends Meal{
    private String size;
    private double price;

    public Juice(String size) {
        price = drinkPrice(size);
    }

    public double getPrice() {
        return price;
    }
    public double drinkPrice(String size){
        price = switch(size){
            case "Small", "small" -> 2.5;
            case "Medium", "medium" -> 3.5;
            case "Large", "large" -> 4.5;
            default -> 0;
        };
        return price;
    }
}

class Coffee extends Meal{
    private String type;
    private String size;
    private double price;

    public Coffee(String size) {
        price = drinkPrice(size);
    }
    public double getPrice() {
        return price;
    }
    public double drinkPrice(String size){
        price = switch(size){
            case "Small", "small" -> 4.5;
            case "Medium", "medium" -> 5.5;
            case "Large", "large" -> 6.5;
            default -> 0;
        };
        return price;
    }
}
class SideItem extends Meal {
    private String type;
    private double price;

    public SideItem(String type) {
        price = sideItemMaker(type);
    }
    public double sideItemMaker(String type) {
        return price = switch (type) {
            case "fries", "Fries" -> 5.5;
            case "salad", "Salad" -> 6.5;
            default -> 0.0;
        };
    }
    public double getPrice() {
        return price;
    }
}

