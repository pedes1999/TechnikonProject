package gr.ed.TechnikonProject.service.serviceImpl;

import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.OwnerRepository;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import gr.ed.TechnikonProject.service.AdminService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of the AdminService interface. 
 * Same logic here as UserServiceImpl. 
 * We check validity and then we parse the actual search to
 * the appropriate repository.
 * 
 */
public class AdminServiceImpl extends OwnerServiceImpl implements AdminService {

    public AdminServiceImpl(OwnerRepository ownerRepository, PropertyRepository propertyRepository, PropertyRepairRepository propertyRepairRepository) {
        super(ownerRepository, propertyRepository, propertyRepairRepository);
    }

    //ADDS
    @Override
    public boolean addOwner(Owner owner) {
        try {
            ownerRepository.create(owner);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);
            return false;
        }
        return true;
    }

    //Reads for owners
    @Override
    public Owner searchOwnerPerVat(String ownerVatNumber) {
        Optional<Owner> owner = null;

        try {
            owner = ownerRepository.readOwnerVat(ownerVatNumber);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);
        }

        if (!owner.isPresent()) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, "There are no owners with the given Vat Number");
        }

        return owner.get();
    }

    @Override
    public Owner searchOwnerPerEmail(String ownerEmail) {
        Optional<Owner> owner = null;
        try {
            owner = ownerRepository.readOwnerEmail(ownerEmail);
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);
        }

        if (!owner.isPresent()) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, "There are no owners with the given Email!");
        }

        return owner.get();
    }

    //Updates for Repair
    @Override
    public boolean updatePropertyRepairProposedStartDate(PropertyRepair propertyRepair, LocalDate prPropStart) {
        boolean propStartDateUpdated = true;
        try {
            propertyRepairRepository.updateRepairProposedStartDate(propertyRepair.getPropertyRepairId(), prPropStart);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!propStartDateUpdated) {

        }
        return propStartDateUpdated;
    }

    @Override
    public boolean updatePropertyRepairProposedEndDate(PropertyRepair propertyRepair, LocalDate prPropEnd) {
        boolean propEndDateUpdated = true;
        try {
            propertyRepairRepository.updateRepairProposedEndDate(propertyRepair.getPropertyRepairId(), prPropEnd);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!propEndDateUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, "Proposed Start Date Was not updated!");
        }
        return propEndDateUpdated;
    }

    @Override
    public boolean updatePropertyRepairProposedCost(PropertyRepair propertyRepair, double prPropCost) {
        boolean propCostUpdated = true;
        try {
            propertyRepairRepository.updateRepairProposedCost(propertyRepair.getPropertyRepairId(), prPropCost);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propCostUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, "Proposed Cost was not updated!");
        }
        return propCostUpdated;
    }

    @Override
    public boolean updatePropertyRepairActualStartDate(PropertyRepair propertyRepair, LocalDate prActualStart) {
        boolean propActualStartUpdated = true;
        try {
            propertyRepairRepository.updateRepairActualStartDate(propertyRepair.getPropertyRepairId(), prActualStart);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propActualStartUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, "Actual Start Date was not Updated!");
        }
        return propActualStartUpdated;
    }

    @Override
    public boolean updatePropertyRepairActualEndDate(PropertyRepair propertyRepair, LocalDate prActualEnd) {
        boolean propActualEndUpdated = true;
        try {
            propertyRepairRepository.updateRepairActualEndDate(propertyRepair.getPropertyRepairId(), prActualEnd);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return propActualEndUpdated;
    }

    //DELETES
    @Override
    public boolean deletePropertyRepair(PropertyRepair propertyRepair) {
        boolean propertyRepairDeleted = true;
        try {
            propertyRepairDeleted = propertyRepairRepository.delete(propertyRepair.getPropertyRepairId());
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);
        }
        if (!propertyRepairDeleted) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, "Somthing went Wrong with Repair Deletion!");
        }
        return propertyRepairDeleted;
    }

    @Override
    public boolean deleteProperty(Property property) {
        boolean propertyDeleted = true;
        try {
            propertyDeleted = propertyRepository.delete(property.getPropertyId());
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);
        }
        if (!propertyDeleted) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, "Somthing went Wrong with Property Deletion!");
        }
        return propertyDeleted;
    }

    @Override
    public boolean deleteOwner(Owner owner) {
        boolean ownerDeleted = true;
        try {
            ownerDeleted = ownerRepository.delete(owner.getOwnerId());
        } catch (Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, "Somthing went Wrong with Owner Deletion!");
        }
        return ownerDeleted;
    }

    @Override
    public boolean updateRepairIfAccepted(PropertyRepair propertyRepair) {
        if (propertyRepair.getRepairAcceptance()) {
            try {
                updatePropertyRepairActualStartDate(propertyRepair, propertyRepair.getRepairProposedStartDate());
                updatePropertyRepairActualEndDate(propertyRepair, propertyRepair.getRepairProposedEndDate());
                propertyRepair.setRepairStatus(RepairStatus.IN_PROGRESS);
            } catch (Exception e) {
                Logger.getLogger(AdminServiceImpl.class.getName())
                        .log(Level.WARNING, "Somthing went Wrong with Repair Updates!");
                return false;
            }

        }
        return true;
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
    public List<PropertyRepair> getAllPropertyRepairs() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateRepairIfDeclined(PropertyRepair propertyRepair) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
