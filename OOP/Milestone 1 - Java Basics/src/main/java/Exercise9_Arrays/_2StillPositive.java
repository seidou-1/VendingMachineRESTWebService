/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise9_Arrays;

/**
 *
 * @author laptop
 */
public class _2StillPositive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] numbers = {389, -447, 26, -485, 712, -884, 94, -64, 868, -776, 227, -744, 422, -109, 259, -500, 278, -219, 799, -311};
        
        System.out.println("Gotta stay positive...! ");
        for (int i = 0; i < numbers.length; i++) {
            
            if (numbers[i] > 0) {
                
                
                System.out.print(numbers[i] + " " );
                
            }
            
        } 
            
    }

}
    

