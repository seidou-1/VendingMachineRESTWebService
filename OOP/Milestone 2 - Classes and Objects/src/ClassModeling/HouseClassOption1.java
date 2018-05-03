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
public class HouseClassOption1 {
    
    //****************These are the static fields****************************
    private String terrain;
    private String latitude;
    private String longitude;
    //***********************************************************************
    
    //****************These are the Instance Methods\Non Static**************
    
    HouseClassOption1(){ //This is the constructor
        
    }
    
    public String getTerrain(){
        return terrain;
    }
    
    public void setTerrain(String whatsTheTerrain){
        this.terrain = whatsTheTerrain;
    }
    
    public String getLatitude(){
        return latitude;
    }
    
    public void setLatitude(String whatsTheLatitude){
        this.latitude = whatsTheLatitude;
    }
    
    public String getLongitude(){
        return longitude;
    }
    
    public void setLongitude(String whatsTheLongitude){
        this.longitude = whatsTheLongitude;
    }
    
    public void coordinates (){
         System.out.println("Your terrain is " + terrain + " and your " + " coordinates are " + (latitude + longitude));
        
    }
    
  
            
            
            //, String whatsTheTerrain, String whatstheLatitude, String whatsTheLongitude
            
            
            
}
