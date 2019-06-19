package Model;

/**
 *
 * @author Brian Schaffeld
 */
public abstract class Part {

    // Instance Variables
    // Protected so that subclasses can use these variables
    protected int partId;
    protected String partName;
    protected double partPrice;
    protected int partStock;
    protected int partMin;
    protected int partMax;

    // Constructor
    public Part(String partName, double partPrice, int partStock, int partMin, int partMax) {
//        this.partId = partId;
        int nextId = Inventory.getPartIdAutoGen() + 1;
        setPartId(nextId);
        Inventory.setPartIdAutoGen(nextId);

        this.partName = partName;
        this.partPrice = partPrice;
        this.partStock = partStock;
        this.partMin = partMin;
        this.partMax = partMax;
    }

//    public Part(int partId, String partName, double partPrice, int partStock, int partMin, int partMax) {
//        this.partId = partId;
//        this.partName = partName;
//        this.partPrice = partPrice;
//        this.partStock = partStock;
//        this.partMin = partMin;
//        this.partMax = partMax;
//    }
    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public double getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(double partPrice) {
        this.partPrice = partPrice;
    }

    public int getPartStock() {
        return partStock;
    }

    public void setPartStock(int partStock) {
        this.partStock = partStock;
    }

    public int getPartMin() {
        return partMin;
    }

    public void setPartMin(int partMin) {
        this.partMin = partMin;
    }

    public int getPartMax() {
        return partMax;
    }

    public void setPartMax(int partMax) {
        this.partMax = partMax;
    }

}
