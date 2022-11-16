package gr.ed.TechnikonProject.model;
import gr.ed.TechnikonProject.enums.PropertyType;
import java.time.Year;

public class Property{
    private Integer propertyIdE9;
    private String propertyAddress;
    private Year propertyConstructionYear;
    private PropertyType propertyType;
    private Owner propertyVATOwner;

    public int getpropertyIdE9() {
        return propertyIdE9;
    }

    public void setpropertyIdE9(int propertyIdE9) {
        this.propertyIdE9 = propertyIdE9;
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

    public Owner getPropertyVATOwner() {
        return propertyVATOwner;
    }

    public void setPropertyVATOwner(Owner propertyVATOwner) {
        this.propertyVATOwner = propertyVATOwner;
    }

    @Override
    public String toString() {
        return "Property{" + "propertyIdE9=" + propertyIdE9 + ", propertyAddress=" + propertyAddress + ", propertyConstructionYear=" + propertyConstructionYear + ", propertyType=" + propertyType + ", propertyVATOwner=" + propertyVATOwner + '}';
    }
    
    
    
}
