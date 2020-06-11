import java.util.Scanner;

public class CoffeeMachine {
    static int min(int a, int b, int c){
        return min(a, min(b, c));
    }
    static int min(int a, int b){
        return a < b ? a : b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        int neededWater = 200 * cups;
        int neededMilk = 50 * cups;
        int neededCoffee = 15 * cups;
        boolean adequate = false;
        if (neededWater <= water && neededMilk <= milk && neededCoffee <= coffee) {
            adequate = true;
            water -= neededWater;
            milk -= neededMilk;
            coffee -= neededCoffee;
        }
        cups = min(water/200, milk/50, coffee/15);
        if (adequate) {
            System.out.print("Yes, I can make that amount of coffee");
            if (cups > 0) {
                System.out.print(" (and even " + cups + " more than that)");
            }
        } else {
            System.out.print("No, I can make only " + cups + " cup(s) of coffee");
        }
        System.out.println();
    }
}

