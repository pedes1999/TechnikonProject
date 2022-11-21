package gr.ed.TechnikonProject.service.serviceImpl;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.OwnerRepository;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import gr.ed.TechnikonProject.service.OwnerService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OwnerServiceImpl implements OwnerService {

    protected final OwnerRepository ownerRepository;
    protected final PropertyRepository propertyRepository;
    protected final PropertyRepairRepository propertyRepairRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository, PropertyRepository propertyRepository, PropertyRepairRepository propertyRepairRepository) {
        this.ownerRepository = ownerRepository;
        this.propertyRepository = propertyRepository;
        this.propertyRepairRepository = propertyRepairRepository;
    }

    @Override
    public boolean addProperty(Property property) {
        try {
            propertyRepository.create(property);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
            return false;
        }
        return true;

    }

    @Override
    public boolean addPropertyRepair(PropertyRepair propertyRepair) {
        try {
            propertyRepairRepository.create(propertyRepair);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
            return false;
        }
        return true;

    }

    @Override
    public Property searchPropertyByPropertyId(int propertyId) {
        Property p = new Property();
        try {
            p = propertyRepository.readByPropertyId(propertyId);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return p;

    }

    @Override
    public List<Property> searchPropertyByVATNumber(Owner propertyOwner) {
        List<Property> propertyList = new ArrayList<>();
        try {
            propertyList = propertyRepository.readByVATNumber(propertyOwner);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        if (propertyList.isEmpty()) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, "There are no Properties with the given Vat Number");
        }
        return propertyList;

    }

    @Override
    public boolean updateRepairAcceptance(PropertyRepair propertyRepair, boolean repairAcceptance) {
        boolean acceptanceUpdated = true;
        try {
            acceptanceUpdated = propertyRepairRepository.updateRepairAcceptance(propertyRepair.getPropertyRepairId(), repairAcceptance);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }

        if (!acceptanceUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, "Repair acceptance was not Updated");
        }
        return true;

    }

    @Override
    public List<PropertyRepair> searchRepairsByDate(LocalDate date) {
        List<PropertyRepair> propertyRepairListDate = new ArrayList<>();
        try {
            propertyRepairListDate = propertyRepairRepository.readPerDate(date);
        } catch (Exception e) {
            Logger.getLogger(OwnerServiceImpl.class.getName()).log(Level.WARNING, e.getMessage(), e);
        }

        if (propertyRepairListDate.isEmpty()) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.INFO, null, "There are no Repairs for the Given Date");
        }
        return propertyRepairListDate;
    }

    @Override
    public List<PropertyRepair> searchRepairsByDate(LocalDate startDate, LocalDate endDate) {
        List<PropertyRepair> propertyRepairListRangeDates = new ArrayList<>();
        try {
            propertyRepairListRangeDates = propertyRepairRepository.readPerRangeOfDates(startDate, endDate);
        } catch (Exception e) {
            Logger.getLogger(OwnerServiceImpl.class.getName()).log(Level.WARNING, e.getMessage(), e);
        }

        if (propertyRepairListRangeDates.isEmpty()) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.INFO, null, "There are no Repairs for the Given Date");
        }
        return propertyRepairListRangeDates;
    }

    @Override
    public boolean updatePropertyAddress(final Property property, String propertyAddress) {
        boolean propertyAddressUpdated = true;
        try {
            propertyAddressUpdated = propertyRepository.updatePropertyAddress(property.getPropertyId(), propertyAddress);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propertyAddressUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.WARNING, "The property Address was not updated");
        }
        return propertyAddressUpdated;
    }

    @Override
    public boolean updatePropertyConstructionYear(final Property property, LocalDate propertyConstructionYear) {
        boolean propertyConstYearUpdated = true;
        try {
            propertyConstYearUpdated = propertyRepository.updatePropertyConstructionYear(property.getPropertyId(), propertyConstructionYear);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propertyConstYearUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.WARNING, "The property Construction Year was not updated!");
        }
        return propertyConstYearUpdated;
    }

    @Override
    public boolean updatePropertyType(final Property property, PropertyType propertyType) {
        boolean propertyTypeUpdated = true;
        try {
            propertyTypeUpdated = propertyRepository.updatePropertyType(property.getPropertyId(), propertyType);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propertyTypeUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.WARNING, "The property Construction Year was not updated!");
        }
        return propertyTypeUpdated;
    }

    @Override
    public PropertyRepair searchRepairPerId(int propertyRepairId) {
        PropertyRepair p = new PropertyRepair();
        try {
            p = propertyRepairRepository.read(propertyRepairId);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return p;
    }

    @Override
    public List<PropertyRepair> getAllRepairs(Owner owner) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmailValid(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isIdValid() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isPwdValid() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateOwnerAddress(Owner owner, String ownerAddress) {
        boolean ownerAddressUpdated = true;
        try {
            ownerAddressUpdated = ownerRepository.updateAddress(owner.getOwnerVat(), ownerAddress);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!ownerAddressUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.WARNING, "The owner Address was not updated");
        }
        return ownerAddressUpdated;  
    }

    @Override
    public boolean updateOwnerEmail(Owner owner, String ownerEmail) {
        boolean ownerEmailUpdated = true;
        try {
            ownerEmailUpdated = ownerRepository.updateEmail(owner.getOwnerVat(), ownerEmail);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!ownerEmailUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.WARNING, "The owner Email was not updated");
        }
        return ownerEmailUpdated;    
    }

    @Override
    public boolean updateOwnerPwd(Owner owner, String ownerPwd) {
        boolean ownerPwdUpdated = true;
        try {
            ownerPwdUpdated = ownerRepository.updatePassword(owner.getOwnerVat(), ownerPwd);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!ownerPwdUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.WARNING, "The owner Password was not updated");
        }
        return ownerPwdUpdated;  
    }
}
