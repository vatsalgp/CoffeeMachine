package coffeemachine;

public class Main {
    public static void main(final String[] args) {
        boolean active = true;
        while (active) {
            System.out.println("What do you want to do ?");
            System.out.println("1. Buy coffee");
            System.out.println("2. Fill ingredients");
            System.out.println("3. Take out the money");
            System.out.println("4. Check remaining ingredients");
            System.out.println("5. Exit");
            switch (CoffeeMachine.getDigit()) {
                case 1:
                    CoffeeMachine.buyCoffee();
                    break;
                case 2:
                    CoffeeMachine.fillCoffee();
                    break;
                case 3:
                    CoffeeMachine.takeCoffee();
                    break;
                case 4:
                    CoffeeMachine.printCoffeeStorage();
                    break;
                default:
                    active = false;
            }
            System.out.println();
        }
    }
}
