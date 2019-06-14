package Model;

/**
 *
 * @author Brian Schaffeld
 */
public class InHousePart extends Part {

    private int machineId;

    public InHousePart(int partId, String partName, double partPrice, int partStock, int partMin, int partMax, int machineId) {
        super(partId, partName, partPrice, partStock, partMin, partMax);
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
