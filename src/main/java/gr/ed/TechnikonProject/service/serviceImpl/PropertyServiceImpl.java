package gr.ed.TechnikonProject.service.serviceImpl;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.exceptions.InvalidIdException;
import gr.ed.TechnikonProject.exceptions.InvalidPropertyException;
import gr.ed.TechnikonProject.exceptions.InvalidVatException;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.repository.OwnerRepository;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import gr.ed.TechnikonProject.service.PropertyService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class PropertyServiceImpl implements PropertyService {

    protected final OwnerRepository ownerRepository;
    protected final PropertyRepository propertyRepository;
    protected final PropertyRepairRepository propertyRepairRepository;

    public PropertyServiceImpl(OwnerRepository ownerRepository, PropertyRepository propertyRepository, PropertyRepairRepository propertyRepairRepository) {
        this.ownerRepository = ownerRepository;
        this.propertyRepository = propertyRepository;
        this.propertyRepairRepository = propertyRepairRepository;

    }

    /**
     * It checks if the property's data are valid and then add the owner in the
     * database
     *
     * @param property
     * @return if the property has been added
     */
    @Override
    public boolean addProperty(Property property) {
        if (!isPropertyValid(property)) {
            Logger.getLogger(PropertyServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidPropertyException(
                            "Error, invalid property value(s)! ("
                            + property.toString() + ")"));
            return false;
        }
        try {
            propertyRepository.create(property);
        } catch (Exception e) {
            Logger.getLogger(PropertyServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
            return false;
        }

        Logger.getLogger(PropertyServiceImpl.class.getName())
                .log(Level.INFO, "The property has been added successfully!");
        return true;

    }

    /**
     * It checks if the id is valid and if it exists in the database or not
     *
     * @param propertyId
     * @return an error message in case of invalid data or not existing property
     * in the database (giving the property id) , and the property if the id
     * exists
     */
    @Override
    public Property searchPropertyByPropertyId(int propertyId) {
        if (!isIdValid(propertyId)) {
            Logger.getLogger(PropertyServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidIdException(
                            "Error, invalid Id value! ("
                            + propertyId + ")"));
            return null;
        }
        Optional<Property> p = null;
        try {
            p = propertyRepository.read(propertyId);
            return p.get();
        } catch (Exception e) {
            Logger.getLogger(PropertyServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        if (!p.isPresent()) {
            Logger.getLogger(PropertyServiceImpl.class.getName()).log(Level.INFO, "Error,There are no properties with this id");
            return null;
        }
        return null;
    }

    /**
     * It checks if the given VAT number is valid and it returns the properties
     * of an owner
     *
     * @param ownerVat
     * @return A list of properties from a specific owner (fount by the VAT
     * number) or a message if the owner doesn't have properties
     */
    @Override
    public List<Property> getAllOwnerProperties(String ownerVat) {
        if (!isVatValid(ownerVat)) {
            Logger.getLogger(PropertyServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidVatException(
                            "Error, invalid Vat value! ("
                            + ownerVat + ")"));
            return null;
        }
        List<Property> ownerProperties = new ArrayList<>();
        try {
            ownerProperties = propertyRepository.readByVATNumber(ownerVat);
        } catch (Exception e) {
            Logger.getLogger(PropertyServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        if (ownerProperties.isEmpty()) {
            Logger.getLogger(PropertyServiceImpl.class.getName()).log(Level.INFO, "There are no Properties active for this user");
        }
        return ownerProperties;
    }

    /**
     * It checks if the given property is valid and then it updates the given
     * property's address
     *
     * @param property
     * @param propertyAddress
     * @return if the given address is valid or not and if the address of the
     * given property has been updated
     */
    @Override
    public boolean updatePropertyAddress(final Property property, String propertyAddress) {
        if (!isPropertyValid(property)) {
            Logger.getLogger(PropertyServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidPropertyException(
                            "Error, invalid property value(s)! ("
                            + property.toString() + ")"));
            return false;
        }
        boolean propertyAddressUpdated = true;

        try {
            propertyAddressUpdated = propertyRepository.updatePropertyAddress(property.getPropertyId(), propertyAddress);
        } catch (Exception ex) {
            Logger.getLogger(PropertyServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propertyAddressUpdated) {
            Logger.getLogger(PropertyServiceImpl.class.getName()).log(Level.WARNING, "The property Address was not updated");
        }
        return propertyAddressUpdated;
    }

    /**
     * It checks if the given property is valid and then it updates the given
     * property's construction year
     *
     * @param property
     * @param propertyConstructionYear
     * @return if the given property is valid or not and if the construction
     * year of the given property has been updated
     */
    @Override
    public boolean updatePropertyConstructionYear(final Property property, LocalDate propertyConstructionYear) {
        if (!isPropertyValid(property)) {
            Logger.getLogger(PropertyServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidPropertyException(
                            "Error, invalid property value(s)! ("
                            + property.toString() + ")"));
            return false;
        }
        boolean propertyConstYearUpdated = true;
        try {
            propertyConstYearUpdated = propertyRepository.updatePropertyConstructionYear(property.getPropertyId(), propertyConstructionYear);
        } catch (Exception ex) {
            Logger.getLogger(PropertyServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propertyConstYearUpdated) {

            Logger.getLogger(PropertyServiceImpl.class.getName()).log(Level.WARNING, "The property Construction Year was not updated!");
        }
        return propertyConstYearUpdated;
    }

    /**
     * It checks if the given property is valid and then it updates the given
     * property's type
     *
     * @param property
     * @param propertyType
     * @return if the given property is valid or not and if the type of the
     * given property has been updated
     */
    @Override
    public boolean updatePropertyType(final Property property, PropertyType propertyType) {
        if (!isPropertyValid(property)) {
            Logger.getLogger(PropertyServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidPropertyException(
                            "Error, invalid property value(s)! ("
                            + property.toString() + ")"));
            return false;
        }
        boolean propertyTypeUpdated = true;

        try {
            propertyTypeUpdated = propertyRepository.updatePropertyType(property.getPropertyId(), propertyType);
        } catch (Exception ex) {
            Logger.getLogger(PropertyServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propertyTypeUpdated) {
            Logger.getLogger(PropertyServiceImpl.class.getName()).log(Level.WARNING, "The property Construction Year was not updated!");
        }
        return propertyTypeUpdated;
    }

    /**
     *
     * @param property
     * @return if the property has been successfully deleted or not
     */
    @Override
    public boolean deleteProperty(Property property) {
        boolean propertyDeleted = true;
        try {
            propertyDeleted = propertyRepository.delete(property.getPropertyId());
        } catch (Exception e) {
            Logger.getLogger(PropertyServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);
        }
        if (!propertyDeleted) {
            Logger.getLogger(PropertyServiceImpl.class.getName())
                    .log(Level.WARNING, "Somthing went Wrong with Property Deletion!");
        }
        return propertyDeleted;
    }

    //Validation patterns
    private boolean isIdValid(int id) {
        return id > 0;
    }

    private boolean isVatValid(String vatNumber) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(vatNumber).matches();
    }

    private boolean isAddressValid(String address) {
        String regex = "[\\w\\s]*\\d*";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(address).matches();
    }

    private boolean isPropertyValid(Property property) {
        return (isAddressValid(property.getPropertyAddress()));
    }

}
