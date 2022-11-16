package gr.ed.TechnikonProject.model;
import gr.ed.TechnikonProject.enums.PropertyType;
import java.time.Year;

public class Property{
    private Integer propertyE9;
    private String propertyAddress;
    private Year propertyConstructionYear;
    private PropertyType propertyType;
    private String propertyVATOwner;

    public int getPropertyE9() {
        return propertyE9;
    }

    public void setPropertyE9(int propertyE9) {
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

    @Override
    public String toString() {
        return "Property{" + "propertyE9=" + propertyE9 + ", propertyAddress=" + propertyAddress + ", propertyConstructionYear=" + propertyConstructionYear + ", propertyType=" + propertyType + ", propertyVATOwner=" + propertyVATOwner + '}';
    }
    
    
    
}
