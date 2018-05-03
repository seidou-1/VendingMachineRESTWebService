/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefactoredRPS;

import java.util.Random;

/**
 *
 * @author laptop
 */
public class Computer {
 
    private String rockString = "rock";
 
    private String paperString = "paper";
 
    private String scissorsString = "scissors";
 
    private int computerChoice;
    
    private Person person;
    private Container container;

    public Container getContainer() {
        return container;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getRock() {
        return rockString;
    }

    public String getPaper() {
        return paperString;
    }

    public String getScissors() {
        return scissorsString;
    }

    public static Random getRandomizer() {
        return randomizer;
    }

    public int getComputerSelects() {
        return computerChoice;
    }
    
    
    private static final Random randomizer = new Random();
 
    
    Person forUserInput = new Person();
    
    public String computerSelection(){
        
        System.out.println(" Ok my turn.... \n I picked: \n ");
        computerChoice = randomizer.nextInt(3);
        
        switch (computerChoice) {
        
            case 0:
                        return this.rockString;
                         
            case 1: 
                        return this.paperString;
            case 2:
                        return this.scissorsString; 
            default:
                        return "Should not reach here"; 
          
                }
        
        
        
        
         
        
        
        
        
        
        
        
        
        
    }
    
}
