package Model;

/**
 *
 * @author Brian Schaffeld
 */
public class OutsourcedPart extends Part {

    // Instance variables
    private String companyName;

    // NB created this constructor because it didn't like mine
    public OutsourcedPart(int partId, String partName, double partPrice, int partStock, int partMin, int partMax, String companyName) {
        super(partId, partName, partPrice, partStock, partMin, partMax);
        setCompanyName(companyName);
    }

    // Setters
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // Getters
    public String getCompanyName() {
        return this.companyName;
    }

}
