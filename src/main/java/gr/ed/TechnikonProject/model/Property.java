package gr.ed.TechnikonProject.model;

import gr.ed.TechnikonProject.enums.PropertyType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
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

    @Column(columnDefinition = "enum('DETACHED_HOUSE','MAISONETTE','APPARTMENT')")
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    private int propertyE9;
    private String propertyAddress;
    private LocalDate propertyConstructionYear;
    private String propertyVATOwner;

    public int getPropertyId() {
        return propertyId;
    }

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

    public LocalDate getPropertyConstructionYear() {
        return propertyConstructionYear;
    }

    public void setPropertyConstructionYear(LocalDate propertyConstructionYear) {
        this.propertyConstructionYear = propertyConstructionYear;
    }

    public String getPropertyVATOwner() {
        return propertyVATOwner;
    }

    public void setPropertyVATOwner(String propertyVATOwner) {
        this.propertyVATOwner = propertyVATOwner;
    }

    public Owner getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(Owner propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    public void setPropertyRepairs(List<PropertyRepair> propertyRepairs) {
        this.propertyRepairs = propertyRepairs;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return "Property{" + "propertyE9=" + propertyE9 + ", propertyAddress=" + propertyAddress + ", propertyConstructionYear=" + propertyConstructionYear + ", propertyType=" + propertyType + '}';
    }

}
