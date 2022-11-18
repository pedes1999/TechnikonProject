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
    private String ownerPhoneNumber;
    private String ownerEmail;
    private String ownerUsername;
    private String ownerPwd;
    @OneToMany(mappedBy = "propertyOwner")
    private List<Property> properties;

    public Owner(){
        
    }
    
    public Owner(String vat, String name, String surname, String address, String phoneNumber, String email, String username, String password) {
        this.ownerVat = vat;
        this.ownerName = name;
        this.ownerSurname = surname;
        this.ownerAddress = address;
        this.ownerPhoneNumber = phoneNumber;
        this.ownerEmail = email;
        this.ownerUsername = username;
        this.ownerPwd = password;
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

}
