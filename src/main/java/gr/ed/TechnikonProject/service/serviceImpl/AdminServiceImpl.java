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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    
    
    @Override
    public Owner searchOwnerByOwnerId(int ownerId) {
        Owner owner = new Owner();
        try {
            owner = ownerRepository.read(ownerId);
        } catch (Exception e) {
             Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return owner;
    }

    
   
     @Override
    public Property searchPropertyByPropertyId(int propertyId) {
        Property p = new Property();
       try {
           p = propertyRepository.read(propertyId);
        } catch(Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return p;
    
    }
    
      @Override
    public PropertyRepair searchRepairByRepairId(int propertyRepairId) {
        PropertyRepair p = new PropertyRepair();
       try {
           p = propertyRepairRepository.read(propertyRepairId);
        } catch(Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return p;
    }
    
     @Override
    public List<PropertyRepair> getAllPropertyRepairs() {
        List<PropertyRepair> returnedList = new ArrayList<>();
        try {
           returnedList = propertyRepairRepository.read();
        } catch(Exception e) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);
        }
        if(returnedList.isEmpty()){
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.INFO,"There are noRepairs at the Moment" );
        }
        
        return returnedList;
    }

    //Updates for Repair
    @Override
    public boolean updatePropertyRepairProposedStartDate(PropertyRepair propertyRepair, LocalDate prPropStart) {
        boolean propStartDateUpdated = true;
        try {
            propStartDateUpdated = propertyRepairRepository.updateRepairProposedStartDate(propertyRepair.getPropertyRepairId(), prPropStart);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!propStartDateUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.WARNING, "Proposed Start Date not Updated!");
        }
        return propStartDateUpdated;
    }

    @Override
    public boolean updatePropertyRepairProposedEndDate(PropertyRepair propertyRepair, LocalDate prPropEnd) {
        boolean propEndDateUpdated = true;
        try {
            propEndDateUpdated = propertyRepairRepository.updateRepairProposedEndDate(propertyRepair.getPropertyRepairId(), prPropEnd);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propEndDateUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, "Proposed End Date Was not updated!");
        }

        return propEndDateUpdated;
    }

    @Override
    public boolean updatePropertyRepairProposedCost(PropertyRepair propertyRepair, double prPropCost) {
        boolean propCostUpdated = true;
        try {
            propCostUpdated = propertyRepairRepository.updateRepairProposedCost(propertyRepair.getPropertyRepairId(), prPropCost);
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
            propActualStartUpdated = propertyRepairRepository.updateRepairActualStartDate(propertyRepair.getPropertyRepairId(), prActualStart);
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
        if (!propActualEndUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, "Actual End Date was not Updated!");
        }
        return propActualEndUpdated;
    }

    @Override
    public boolean updatePropertyRepairStatus(PropertyRepair propertyRepair, RepairStatus repairStatus) {
        boolean repairStatusUpdated = true;
        try {
            repairStatusUpdated = propertyRepairRepository.updateRepairStatus(propertyRepair.getPropertyRepairId(), repairStatus);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!repairStatusUpdated) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.WARNING, "Repair Status was not Updated!");
        }
        return repairStatusUpdated;
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
    public boolean updateRepairBasedOnAcceptance(PropertyRepair propertyRepair) {
        if (propertyRepair.getRepairAcceptance() == null) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.INFO, "User has not yet accepted or declined the offer!");
        } else if (propertyRepair.getRepairAcceptance()) {
            try {
                updatePropertyRepairActualStartDate(propertyRepair, propertyRepair.getRepairProposedStartDate());
                updatePropertyRepairActualEndDate(propertyRepair, propertyRepair.getRepairProposedEndDate());
                propertyRepair.setRepairStatus(RepairStatus.IN_PROGRESS);
            } catch (Exception e) {
                Logger.getLogger(AdminServiceImpl.class.getName())
                        .log(Level.WARNING, "Somthing went Wrong with Repair Updates!");
                return false;
            }

        } else if (!propertyRepair.getRepairAcceptance()) {
            try {
                updatePropertyRepairStatus(propertyRepair, RepairStatus.DECLINED);
                updatePropertyRepairActualStartDate(propertyRepair, null);
                updatePropertyRepairActualEndDate(propertyRepair, null);
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
        String regex = "^(.+)@(\\S+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        System.out.println(email + " : " + matcher.matches());
        return true;

    }

    @Override
    public boolean isIdValid(int id) {
        String s = Integer.toString(id);
        String regex = "\\d{8}"; 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        System.out.println(s + " : " + matcher.matches());
        return true;
    }
    
    //Password is valid when there is at least one number, one lower case and one uppercase letter (password width : 8-20 characters)
    
    @Override
    public boolean isPwdValid(String password) {
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        System.out.println(password + " : " + matcher.matches());
        return true;
    }
}
