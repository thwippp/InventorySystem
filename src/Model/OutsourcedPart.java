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
public class OutsourcedPart extends Part {

    // Instance variables
    private String companyName;

    // NB created this constructor because it didn't like mine
    public OutsourcedPart(int partId, String partName, double partPrice, int partStock, int partMin, int partMax, String companyName) {
        super(partId, partName, partPrice, partStock, partMin, partMax);  // don't know where this comes from
        this.companyName = companyName;
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
