import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Meal meal = new Meal();

        System.out.println("pleas specify your order: ");
        System.out.println("pleas chose a burger:\n Hamburger:\nDelux:\nCheeseburger");
        Scanner s  = new Scanner(System.in);
        String burger = s.nextLine();
        System.out.println("pleas chose the drink:\nCoke\nJuice\nCoffee");
        String drink = s.nextLine();
        System.out.println("please chose size of the drink: small\nmedium\nlarge");
        String size = s.nextLine();
        System.out.println("please chose a fires or salad:");
        String sideItem = s.nextLine();

        Meal.mealCreator(burger, drink, size, sideItem);


    }
}
