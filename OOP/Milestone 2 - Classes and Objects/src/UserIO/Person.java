/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserIO;

import java.util.Scanner;

/**
 *
 * @author laptop
 */
public class Person implements UserIO {

    Scanner myScanner = new Scanner(System.in);
    protected String userInput;
    protected double number;

    @Override
    public void print(String message) {

        System.out.println("You typed in: " + message);

    }

    @Override
    public double readDouble(String prompt) { //The prompt value should be passed in as a parameter 

        System.out.println(prompt);    //Display a prompt to the user and read in an integer
        userInput = myScanner.nextLine();
        number = Integer.parseInt(userInput); //The value that is read in should be the return value of the method
        return number;
    }

    @Override
    public double readDouble(String prompt, double min, double max) { //Display a prompt to the user and read in an integer between a max value and a min value.
        boolean valid;
        do {

            System.out.println(prompt + " " + min + " to " + max);
            userInput = myScanner.nextLine();
            number = Integer.parseInt(userInput);
            if (number >= min && number <= max) {
                valid = true;
            } else {
                System.out.println("Sorry, pick a valid number between " + min + " and " + max);
            }
            return number;

        } while (!valid);

    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);//this is for the user to see what's going on 
        userInput = myScanner.nextLine();
        float numberConverted = Float.parseFloat(userInput);
        System.out.println("The value you entered is: " + numberConverted);
        return numberConverted;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        boolean valid;
        do {

            System.out.println("Pick a value between " + min + " and " + max);
            userInput = myScanner.nextLine();
            System.out.println("You inputted " + userInput);
            float numberEntered = Float.parseFloat(userInput); //this converts a string into a double
            if (numberEntered >= min && numberEntered <= max) {
                valid = true;

            } else {
                System.out.println("Please pick a valid number between " + min + " and " + max);
            }
            return numberEntered;

        } while (!valid);

    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
//        return Integer.parseInt(myScanner.nextLine());

        userInput = myScanner.nextLine();
        int numberConverted = Integer.parseInt(userInput);
        return numberConverted;

    }

    @Override
    public int readInt(String prompt, int min, int max) {
        boolean valid;

        do {

            System.out.println(prompt + min + " and " + max);
            userInput = myScanner.nextLine();
            int numberConverted = Integer.parseInt(userInput);

            if (numberConverted >= min && numberConverted <= max) {
                valid = true;
                System.out.println("Great! you inputted " + userInput);
            } else {
                System.out.println("Try again. Pick a valid number between " + min + " and " + max);
            }

            return numberConverted;
        } while (!valid);
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        userInput = myScanner.nextLine();
        long numberConverted = Long.parseLong(userInput);
        return numberConverted;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        boolean valid;

        do {

            System.out.println(prompt);
            userInput = myScanner.nextLine();
            long numberConverted = Long.parseLong(userInput);

            if (numberConverted >= min && numberConverted <= 10) {
                valid = true;
                System.out.println("Ok you picked " + numberConverted);
            } else {
                System.out.println("Please try again. pick a number between " + min + " and " + max);
            }

            return numberConverted;
        } while (!valid);

    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        userInput = myScanner.nextLine();
        return userInput;
    }

}