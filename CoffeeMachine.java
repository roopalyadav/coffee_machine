package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    
    public static void printStatus(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
    
    public static boolean isEnoughIngredients(int needWater, int needMilk, int needBeans) {
        
        boolean isEnoughIngredients = true;
        int needCups = 1;
        
        if (water < needWater) {
            System.out.println("Sorry, not enough water!");
            isEnoughIngredients = false;
        }
        if (milk < needMilk) {
            System.out.println("Sorry, not enough milk!");
            isEnoughIngredients = false;
        }
        if (beans < needBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            isEnoughIngredients = false;
        }
        if (cups < needCups) {
            System.out.println("Sorry, not enough disposable cups!");
            isEnoughIngredients = false;
        }
        
        return isEnoughIngredients;
    }
    
    public static void buy(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        
        String type = scanner.next();
        switch (type) {
            case "1":
                if (isEnoughIngredients(250, 0, 16)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    beans -= 16;
                    cups -= 1;
                    money += 4;
                }
                break;
            case "2":
                if (isEnoughIngredients(350, 75, 20)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups -= 1;
                    money += 7;
                }
                break;
            case "3":
                if (isEnoughIngredients(200, 100, 12)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups -= 1;
                    money += 6;
                }
                break;
            case "back":
                break;
            default:
                break;
        }
    }
    
    public static void fill(Scanner scanner) {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
    }
    
    public static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean enable = true;
        
        while (enable) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    buy(scanner);
                    break;
                case "fill":
                    fill(scanner);
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printStatus(water, milk, beans, cups, money);
                    break;
                case "exit":
                    enable = false;
                    break;
                default:
                    break;
            }
        }
        // System.out.println("Starting to make a coffee");
        // System.out.println("Grinding coffee beans");
        // System.out.println("Boiling water");
        // System.out.println("Mixing boiled water with crushed coffee beans");
        // System.out.println("Pouring coffee into the cup");
        // System.out.println("Pouring some milk into the cup");
        // System.out.println("Coffee is ready!");
    }
}
