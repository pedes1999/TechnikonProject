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

    @OneToMany(mappedBy = "repairProperty",orphanRemoval=true)
    private List<PropertyRepair> propertyRepairs;

    private String propertyAddress;
    private LocalDate propertyConstructionYear;

    @Column(columnDefinition = "enum('DETACHED_HOUSE','MAISONETTE','APPARTMENT')")
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    
    public Property() {}

    public Property(Owner propertyOwner, String propertyAddress, LocalDate propertyConstructionYear, PropertyType propertyType) {
        this.propertyOwner = propertyOwner;
        this.propertyAddress = propertyAddress;
        this.propertyConstructionYear = propertyConstructionYear;
        this.propertyType = propertyType;
    }
    
    

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

    public List<PropertyRepair> getPropertyRepairs() {
        return propertyRepairs;
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
        return "Property{" + "\n propertyId=" + propertyId + ",\n propertyOwner=" + propertyOwner.getOwnerId() + ",\n propertyAddress=" + propertyAddress + ",\n propertyConstructionYear=" + propertyConstructionYear + ",\n propertyType=" + propertyType + '}' + "\n\n";
    }

}
