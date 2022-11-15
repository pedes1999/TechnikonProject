package gr.ed.TechnikonProject.model;

import gr.ed.TechnikonProject.enums.PropertyType;
import java.time.Year;

public class Property extends PersistentClass{
    private String propertyE9;
    private String propertyAddress;
    private Year propertyConstructionYear;
    private PropertyType propertyType;
    private String propertyVATOwner;

    public String getPropertyE9() {
        return propertyE9;
    }

    public void setPropertyE9(String propertyE9) {
        this.propertyE9 = propertyE9;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public Year getPropertyConstructionYear() {
        return propertyConstructionYear;
    }

    public void setPropertyConstructionYear(Year propertyConstructionYear) {
        this.propertyConstructionYear = propertyConstructionYear;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyVATOwner() {
        return propertyVATOwner;
    }

    public void setPropertyVATOwner(String propertyVATOwner) {
        this.propertyVATOwner = propertyVATOwner;
    }
    
    
}
