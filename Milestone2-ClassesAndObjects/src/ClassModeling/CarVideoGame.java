/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassModeling;

/**
 *
 * @author laptop
 */
public class CarVideoGame {
    
    private String game;
    private int topSpeed;
    private String primaryWeapon;

    public CarVideoGame() {
    }
    
    

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

//Making top speed read only so when it's instantiated it can't be set
    
//    public void setTopSpeed(int topSpeed) {
//        this.topSpeed = topSpeed;
//    }

    public String getPrimaryWeapon() {
        return primaryWeapon;
    }

    public void setPrimaryWeapon(String primaryWeapon) {
        this.primaryWeapon = primaryWeapon;
    }
    
    
    
}
