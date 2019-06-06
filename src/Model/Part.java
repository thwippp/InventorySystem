/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
/**
 *
 * @author bscha
 */
abstract class Part {

    // Instance Variables
    // protected so that subclasses can use these variables
    protected int partId;
    protected String partName;
    protected double partPrice;
    protected int partStock;
    protected int partMin;
    protected int partMax;
    
    
    // Constructor

    public Part(int partId, String partName, double partPrice, int partStock, int partMin, int partMax) {
        this.partId = partId;
        this.partName = partName;
        this.partPrice = partPrice;
        this.partStock = partStock;
        this.partMin = partMin;
        this.partMax = partMax;
    }
    
    // Setter Methods
    public void setPartId(int partId){
        this.partId = partId;
    }
    
    public void setPartName(String partName){
        this.partName = partName;
    }
    
    public void setPartPrice(double partPrice){
        this.partPrice = partPrice;                
    }
    
    public void setPartStock(int partStock){
        this.partStock = partStock;
    }
    
    public void setPartMin(int partMin){
        this.partMin = partMin;
    }
    
    public void setPartMax(int partMax){
        this.partMax = partMax;
    }
    
    
    // Getter Methods
    public int getPartId(){
        return this.partId;
    }
    
    public String getPartName(){
        return this.partName;        
    }
    
    public double getPartPrice(){
        return this.partPrice;
    }
    
    public int getPartStock(){
        return this.partStock;
    }
    
    public int getPartMin(){
        return this.partMin;
    }
    
    public int getPartMax(){
        return this.partMax;
    }
}
