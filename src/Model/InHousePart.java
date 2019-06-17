package Model;

/**
 *
 * @author Brian Schaffeld
 */
public class InHousePart extends Part {

    private int machineId;

    public InHousePart(String partName, double partPrice, int partStock, int partMin, int partMax, int machineId) {
        super(partName, partPrice, partStock, partMin, partMax);
        setMachineId(machineId);
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
