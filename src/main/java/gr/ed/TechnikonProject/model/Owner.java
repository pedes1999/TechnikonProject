package gr.ed.TechnikonProject.model;

import gr.ed.TechnikonProject.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerId;

    @Column(nullable = false, unique = true, length = 10)
    private String ownerVat;
    @Column(length = 25)
    private String ownerName;
    @Column(length = 25)
    private String ownerSurname;
    @Column(length = 25)
    private String ownerAddress;

    @Column(unique = true, length = 10)
    private String ownerPhoneNumber;

    @Column(unique = true, length = 25)
    private String ownerEmail;

    @Column(unique = true, length = 20)
    private String ownerUsername;

    @Column(length = 20)
    private String ownerPwd;

    @OneToMany(mappedBy = "propertyOwner", orphanRemoval = true)
    private List<Property> properties;

    @Column(columnDefinition = "enum('OWNER', 'ADMIN')")
    @Enumerated(EnumType.STRING)
    private Role userRole;

    public Owner() {
    }

    public Owner(String ownerVat, String ownerName, String ownerSurname, String ownerAddress, String ownerPhoneNumber, String ownerEmail, String ownerUsername, String ownerPwd, Role isAdmin) {
        this.ownerVat = ownerVat;
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.ownerAddress = ownerAddress;
        this.ownerPhoneNumber = ownerPhoneNumber;
        this.ownerEmail = ownerEmail;
        this.ownerUsername = ownerUsername;
        this.ownerPwd = ownerPwd;
        this.userRole = isAdmin;
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

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.ownerVat);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Owner other = (Owner) obj;
        return Objects.equals(this.ownerVat, other.ownerVat);
    }

    @Override
    public final String toString() {

        return "Owner{" + "\n ownerId=" + ownerId + ",\n ownerVat=" + ownerVat + ",\n ownerName=" + ownerName + ",\n ownerSurname=" + ownerSurname + ",\n ownerAddress=" + ownerAddress + ",\n ownerPhoneNumber=" + ownerPhoneNumber + ",\n ownerEmail=" + ownerEmail + ",\n ownerUsername=" + ownerUsername + ",\n ownerPwd=" + ownerPwd + "\n" + '}';

    }

}
