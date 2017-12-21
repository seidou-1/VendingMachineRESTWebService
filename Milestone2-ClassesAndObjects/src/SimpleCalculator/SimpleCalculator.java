/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleCalculator;

import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class SimpleCalculator {
    //Instance variables go here

    public static boolean valid;

    public static boolean exit;

    public static String operation;

    private static int operator; //encapsulated

    static Scanner myScanner = new Scanner(System.in);

       SimpleCalculator() { //Created this constructor so all instance objects  will be constructed already calling this method
         design();
    }
    
    public String welcomeAndSelection() {
 
        while (!exit) {
 
            do {
                System.out.println("\n What operation do you want to perform (i.e. +, -, *, /, or EXIT)");
                operation = myScanner.nextLine(); //Switch is performed on this

                if (operation.equalsIgnoreCase("x") || operation.equals("*") || operation.equals("+") || operation.equals("-") || operation.equals("/") || operation.equalsIgnoreCase("exit")) {
                    valid = true;
                }
                if (!valid) {
                    System.out.println("\n Hey man pick the correct operation. " + operation + " is not an operation now is it? Now.. ");

                }

            } while (!valid /*|| operation.equalsIgnoreCase("exit")*/);

            if (operation.equalsIgnoreCase("exit")) { //Did they select exit? if so, call this method
                exit = true;
                SimpleCalculator.exit();

            } else {

                try {
                    System.out.println("Ok what is your first number? ");
                    String num1string = myScanner.nextLine();
                    int num1converted = Integer.parseInt(num1string); //One way of converting a string to an int
                    System.out.println("And your second number? ");
                    String num2string = myScanner.nextLine();
                    Integer num2converted = Integer.valueOf(num2string); //Second way of converting a string to an int

                    //do a try here
                    switch (operation) {
                        case "+":
                            operator = SimpleCalculator.adder(num1converted, num2converted);
                            break;

                        case "-":
                            operator = SimpleCalculator.substractor(num1converted, num2converted);
                            break;

                        case "*":
                        case "x":
                            operator = SimpleCalculator.multiplier(num1converted, num2converted);
                            break;

                        case "/":
                        case "÷":
                            operator = SimpleCalculator.divider(num1converted, num2converted);
                            break;

                        case "exit":
                        case "EXIT":

                        default:
                            System.out.println("Invalid operator. Try again.");

                    }
                } catch (Exception e) {
                    System.out.println("C'mon Man you Put " + e.getMessage() + " ? Try again! Let's play by the rules this time. ");
                }

            }

        }
        return operation;
        
    }

    public static int adder(int kit, int kat) { //the names of the variables a and b are irrelevant. We just need to pass something
        int output = kit + kat;
        System.out.println(kit + " + " + kat + " = " + output);
        return output; //never going to use this but i need a return for my case statements

    }

    public static int substractor(int yaba, int dabado) {
        int output = yaba - dabado;
        System.out.println(yaba + " - " + dabado + " = " + output);
        return output; //never going to use this but i need a return for my case statements
    }

    public static int multiplier(int captn, int crunch) {
        int output = captn * crunch;
        System.out.println(captn + " * " + crunch + " = " + output);
        return output; //never going to use this but i need a return for my case statements
    }

    public static int divider(int rolling, int stones) {
        int output = rolling / stones;
        System.out.println(rolling + " ÷ " + stones + " = " + output);
        return output; //never going to use this but i need a return for my case statements
    }

    public static void exit() {
        System.out.println("Have a nice day. Remember, keep your head up like pac. Goodbye! ");
    }

    public static void design() {
        System.out.println(" \n"
                + " _____________________   \n"
                + "|  _________________  |\n"
                + "| |               | | |\n"
                + "| |_________________| |\n"
                + "|  ___ ___ ___   ___  |\n"
                + "| | 7 | 8 | 9 | | + | |\n"
                + "| |___|___|___| |___| |\n"
                + "| | 4 | 5 | 6 | | - | |\n"
                + "| |___|___|___| |___| |\n"
                + "| | 1 | 2 | 3 | | x | |\n"
                + "| |___|___|___| |___| |\n"
                + "| | . | 0 | = | | / | |\n"
                + "| |___|___|___| |___| |\n"
                + "|_____________________|");

    }

}
