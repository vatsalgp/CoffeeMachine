package coffeemachine;

import java.util.Scanner;

class CoffeeMachine {
    final static Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static int money = 550;

    static void printCoffeeStorage() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + "ml of water");
        System.out.println(milk + "ml of milk");
        System.out.println(coffee + "g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    static void buyCoffee() {
        int neededWater = 0;
        int neededMilk = 0;
        int neededCoffee = 0;
        int neededMoney = 0;
        System.out.println("\nWhat do you want to buy ?");
        System.out.println("1. Espresso");
        System.out.println("2. Latte");
        System.out.println("3. Cappuccino");
        System.out.println("4. Back to main menu");
        switch (getDigit()) {
            case 1:
                neededWater = 250;
                neededMilk = 10;
                neededCoffee = 16;
                neededMoney = 4;
                break;
            case 2:
                neededWater = 350;
                neededMilk = 75;
                neededCoffee = 20;
                neededMoney = 7;
                break;
            case 3:
                neededWater = 200;
                neededMilk = 100;
                neededCoffee = 12;
                neededMoney = 6;
                break;
            default:
                return;
        }
        System.out.println("How many cups ?");
        final int neededCups = getInt();
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

        final int maxCups = Math.min(Math.min(water / neededWater, milk / neededMilk), coffee / neededCoffee);
        water -= neededWater * neededCups;
        milk -= neededMilk * neededCups;
        coffee -= neededCoffee * neededCups;
        cups -= neededCups;
        money += neededMoney * neededCups;
        System.out.print("\nYes, I can make that amount of coffee");
        if (maxCups > neededCups)
            System.out.print(" (and even " + (maxCups - neededCups) + " more than that)");
        System.out.println();
        makeCoffee();
    }

    static void fillCoffee() {
        System.out.println("\nHow many ml of water do you want to add ?");
        water += getInt();
        System.out.println("How many ml of milk do you want to add ?");
        milk += getInt();
        System.out.println("How many grams of coffee beans do you want to add ?");
        coffee += getInt();
        System.out.println("How many cups of coffee do you want to add ?");
        cups += getInt();
    }

    static void takeCoffee() {
        System.out.println("\nI gave you $" + money);
        money = 0;
    }

    private static void makeCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    static int getDigit() {
        while (true) {
            System.out.print(": ");
            final String string = scanner.nextLine();
            if (string.length() > 0) {
                final char ch = string.charAt(0);
                if (Character.isDigit(ch))
                    return Character.getNumericValue(ch);
            }
        }
    }

    private static int getInt() {
        while (true) {
            System.out.print(": ");
            final String[] words = scanner.nextLine().split(" ");
            if (words.length > 0) {
                final String firstWord = words[0];
                if (firstWord.matches("[0-9]+"))
                    return Integer.parseInt(firstWord);
            }
        }
    }
}