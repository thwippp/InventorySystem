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

    private int machineId;

    public InHousePart(int partId, String partName, double partPrice, int partStock, int partMin, int partMax, int machineId) {
        super(partId, partName, partPrice, partStock, partMin, partMax);
        this.machineId = machineId;
    }

    // Setters
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    // Getters
    public int getMachineId() {
        return this.machineId;
    }

}
