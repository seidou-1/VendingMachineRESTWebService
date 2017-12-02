
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laptop
 */
public class MiniZork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");//QUESTION 1

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) { 
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? "); //choice a - stick hand in orlook inside
            action = userInput.nextLine();

            if (action.equals("look inside")) { //look inside
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? "); // run away or keep looking
                action = userInput.nextLine();

                if (action.equals("keep looking")) { //keep looking
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {//run away
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) {  //stick hand in
                    System.out.println("You are in the presence of a beautiful letter");
                    System.out.println("What do you want to do; read it or rip it?");
                    action = userInput.nextLine();
                        if (action.equals("read it")) {
                            System.out.println("Its a letter from grandma Sally. She says you are in godo hands.");
                            }
                            else if (action.equals("rip it")) {
                                    System.out.println("You trust no letters. It could be poison. You're good now.");
                                    }
                    
                
            }
        } else if (action.equals("go to the house")) { 
                System.out.println("So you go to the house and you all of a sudden feel like napping or eating");
                System.out.println("what do you feel like doing?");
                action = userInput.nextLine();
                    if (action.equals("napping")) {
                        System.out.println("so you begin to nap. But you don't know if you should nap for 5 hrs or 2 hrs. How long should you nap?");
                        action = userInput.nextLine();
                        if (action.equals(5)) {
                            System.out.println("now you'll sleep for 5 hrs. Rest easy");
                            
                        } else if (action.equals (2)) {
                            System.out.println("now you'll sleep for 5 hrs. Rest easy");
                            
                        }
                
            } else if (action.equals ("eating")) {
                        System.out.println("Ok what do you want to eat... cake or steak?");
                        action = userInput.nextLine();
                        if (action.equals ("cake")) {
                            System.out.println("Yum yum. Enjoy your cake");
                        } else if (action.equals ("steak")) {
                            System.out.println("Steak is high in protein. Enjoy!");
                            
                        }
                
            }
        }
        
    }
    
}
