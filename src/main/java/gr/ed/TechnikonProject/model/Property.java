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

    private String propertyAddress;
    private LocalDate propertyConstructionYear;

    @Column(columnDefinition = "enum('DETACHED_HOUSE','MAISONETTE','APPARTMENT')")
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    public int getPropertyId() {
        return propertyId;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
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

    public LocalDate getPropertyConstructionYear() {
        return propertyConstructionYear;
    }

    public void setPropertyConstructionYear(LocalDate propertyConstructionYear) {
        this.propertyConstructionYear = propertyConstructionYear;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public final String toString() {
        return "Property{" + "propertyId=" + propertyId + ", propertyOwner=" + propertyOwner.getOwnerId() + " propertyAddress=" + propertyAddress + ", propertyConstructionYear=" + propertyConstructionYear + ", propertyType=" + propertyType + '}';
    }

}
