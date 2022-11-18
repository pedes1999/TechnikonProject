package gr.ed.TechnikonProject.model;

import gr.ed.TechnikonProject.enums.PropertyType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyId;

    @ManyToOne
    private Owner propertyOwner;

    @OneToMany(mappedBy = "repairProperty")
    private List<PropertyRepair> propertyRepairs;

    private Integer propertyE9;
    private String propertyAddress;
    private int propertyConstructionYear;
    private PropertyType propertyType;
    
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

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public void setPropertyOwner(Owner propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    public void setPropertyRepairs(List<PropertyRepair> propertyRepairs) {
        this.propertyRepairs = propertyRepairs;
    }

    public void setPropertyE9(Integer propertyE9) {
        this.propertyE9 = propertyE9;
    }

    public int getPropertyConstructionYear() {
        return propertyConstructionYear;
    }

    public void setPropertyConstructionYear(int propertyConstructionYear) {
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
