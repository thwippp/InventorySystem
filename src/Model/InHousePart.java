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
public class InHousePart extends Part {

    private int machineId;  // make final?

    // NB created this constructor because it didn't like mine
    public InHousePart(int partId, String partName, double partPrice, int partStock, int partMin, int partMax) {
        super(partId, partName, partPrice, partStock, partMin, partMax);  // don't know where this comes from
    }

//    public InHousePart(int partId, String partName, double partPrice, int partStock, int partMin, int partMax){
//        this.partId = partId;
//        this.partName = partName;
//        this.partPrice = partPrice;
//        this.partStock = partStock;
//        this.partMin = partMin;
//        this.partMax = partMax;        
//    }
//    public InHousePart(){
//        this.partId = 0;
//        this.partName = "";
//        this.partPrice = 0.0;
//        this.partStock = 0;
//        this.partMin = 0;
//        this.partMax = 0;   
//    }
    // Setters
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    // Getters
    public int getMachineId() {
        return this.machineId;
    }

}
