package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int waterQuentity = 400;
    static int milkQuentity = 540;
    static int beanQuentity = 120;
    static int cupQuentity = 9;
    static int totalMoney = 550;

    public static void main(String[] args) {

        for (;;) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String option = scanner.nextLine();
            if (option.equals("exit")){
                break;
            }
            switch (option){
                case "buy" :
                    sellCoffee();
                    break;
                case "fill" :
                    replenished();
                    break;
                case "take" :
                    takeMoney();
                    break;
                case "remaining" :
                    detailOfMachine();
                    break;
            }
        }

    }


    private static void detailOfMachine() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(waterQuentity + " of water\n" +
                milkQuentity + " of milk\n" +
                beanQuentity + " of coffee beans\n" +
                cupQuentity + " of disposable cups\n" +
                "$" + totalMoney + " of money");
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + totalMoney);
        totalMoney = 0;

    }

    private static void replenished() {
        System.out.println("Write how many ml of water do you want to add:");
        waterQuentity += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milkQuentity += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beanQuentity += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cupQuentity += scanner.nextInt();
        scanner.nextLine();
    }

    private static void sellCoffee() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" :
                if (waterQuentity >= 250 && milkQuentity >= 0 && beanQuentity >= 16) {
                    makecoffee(250,0,16,4, 1);
                } else if (waterQuentity < 250) {
                    System.out.println("Sorry, not enough water");
                }
                else if (beanQuentity < 16) {
                    System.out.println("Sorry, not enough coffee beans");
                }
                break;
            case "2" :
                if (waterQuentity >= 350 && milkQuentity >= 75 && beanQuentity >= 20 ) {
                    makecoffee(350,75,20,7, 1);
                } else if (waterQuentity < 350) {
                    System.out.println("Sorry, not enough water");
                }
                else if (milkQuentity < 75) {
                    System.out.println("Sorry, not enough milk");
                }
                else {
                    System.out.println("Sorry, not enough coffee beans");
                }
                break;
            case "3" :
                if (waterQuentity >= 200 && milkQuentity >= 100 && beanQuentity >= 12 ) {
                    makecoffee(200,100,12,6, 1);
                } else if (waterQuentity < 200) {
                    System.out.println("Sorry, not enough water");
                }
                else if (milkQuentity < 100) {
                    System.out.println("Sorry, not enough milk");
                }
                else {
                    System.out.println("Sorry, not enough coffee beans");
                }
                break;
            case "exit" :
                break;

        }
    }

    private static void makecoffee(int water, int milk, int beans , int money, int cup) {
        if (cupQuentity > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            waterQuentity -= water;
            milkQuentity -= milk;
            beanQuentity -= beans;
            totalMoney += money;
            cupQuentity -= cup;
        } else System.out.println("Sorry, not enough disposable cups");

    }
}
