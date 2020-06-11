import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            switch (scanner.next()) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillCoffee();
                    break;
                case "take":
                    takeCoffee();
                    break;
                case "remaining":
                    printCoffeeStorage();
                    break;
                default:
                    System.exit(1);
            }
            System.out.println();
        }
    }

    static void printCoffeeStorage() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    static void buyCoffee() {
        System.out.println("\nWhat do you want to buy?");
        System.out.println("1 - espresso");
        System.out.println("2 - latte");
        System.out.println("3 - cappuccino");
        System.out.println("back - to main menu");
        int neededWater = 0;
        int neededMilk = 0;
        int neededCoffee = 0;
        int neededMoney = 0;
        switch (scanner.next()) {
            case "1":
                neededWater = 250;
                neededMilk = 10;
                neededCoffee = 16;
                neededMoney = 4;
                break;
            case "2":
                neededWater = 350;
                neededMilk = 75;
                neededCoffee = 20;
                neededMoney = 7;
                break;
            case "3":
                neededWater = 200;
                neededMilk = 100;
                neededCoffee = 12;
                neededMoney = 6;
                break;
            default:
                return;
        }
        System.out.println("Please enter how many cups:");
        int neededCups = scanner.nextInt();
        if (neededWater * neededCups > water) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (neededMilk * neededCups > milk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (neededCoffee * neededCups > coffee) {
            System.out.println("Sorry, not enough coffee!");
            return;
        }
        if (cups < 0) {
            System.out.println("Sorry, out of cups!");
            return;
        }

        int additionalCups = min(water / neededWater, milk / neededMilk, coffee / neededCoffee) - neededCups;
        water -= neededWater * neededCups;
        milk -= neededMilk * neededCups;
        coffee -= neededCoffee * neededCups;
        cups -= neededCups;
        money += neededMoney * neededCups;
        System.out.print("\nYes, I can make that amount of coffee");
        if (additionalCups > 0)
            System.out.print(" (and even " + additionalCups + " more than that)");
        System.out.println();
        makeCoffee();
    }

    static void fillCoffee() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee += scanner.nextInt();
        System.out.println("Write how many cups of coffee do you want to add:");
        cups += scanner.nextInt();
    }

    static void takeCoffee() {
        System.out.println("\nI gave you $" + money);
        money = 0;
    }

    static void makeCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    static int min(int a, int b, int c) {
        return min(a, min(b, c));
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }

    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static int money = 550;
    final static Scanner scanner = new Scanner(System.in);
}
