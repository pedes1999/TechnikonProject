package gr.ed.TechnikonProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerId;

    @Column(unique = true, length = 10)
    private String ownerVat;
    
    private String ownerName;
    private String ownerSurname;
    private String ownerAddress;
    
    @Column(unique = true, length = 10)
    private String ownerPhoneNumber;
    
    @Column(unique = true)
    private String ownerEmail;
    
    @Column(unique = true)
    private String ownerUsername;
    
    private String ownerPwd;

    @OneToMany(mappedBy = "propertyOwner")
    private List<Property> properties;

    public Owner() {

    }

    public Owner(int ownerId, String ownerVat, String ownerName, String ownerSurname, String ownerAddress, String ownerPhoneNumber, String ownerEmail, String ownerUsername, String ownerPwd, List<Property> properties) {
        this.ownerId = ownerId;
        this.ownerVat = ownerVat;
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.ownerAddress = ownerAddress;
        this.ownerPhoneNumber = ownerPhoneNumber;
        this.ownerEmail = ownerEmail;
        this.ownerUsername = ownerUsername;
        this.ownerPwd = ownerPwd;
        this.properties = properties;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerVat() {
        return ownerVat;
    }

    public void setOwnerVat(String ownerVat) {
        this.ownerVat = ownerVat;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getOwnerPwd() {
        return ownerPwd;
    }

    public void setOwnerPwd(String ownerPwd) {
        this.ownerPwd = ownerPwd;
    }


    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;

    }

    @Override
    public  final String toString() {
        return "Owner{" + "ownerId=" + ownerId + ", ownerVat=" + ownerVat + ", ownerName=" 
                + ownerName + ", ownerSurname=" + ownerSurname + ", ownerAddress=" + ownerAddress 
                + ", ownerPhoneNumber=" + ownerPhoneNumber + ", ownerEmail=" + ownerEmail 
                + ", ownerUsername=" + ownerUsername + ", ownerPwd=" + ownerPwd + ", properties=" + properties + '}';
    }
 
    
}
