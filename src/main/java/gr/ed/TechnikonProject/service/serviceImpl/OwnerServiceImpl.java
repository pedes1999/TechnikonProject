
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public List<Property> getAllOwnerProperties(String ownerVat) {
        List<Property> ownerProperties = new ArrayList<>();
        try {
            ownerProperties = propertyRepository.readByVATNumber(ownerVat);
        } catch(Exception e) { 
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        if(ownerProperties.isEmpty()){
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.INFO, "There are no Properties active for this user");
        }
        return ownerProperties;
    }

    
    @Override
    public List<PropertyRepair> getAllOwnerRepairs(String ownerVat) {
        List<PropertyRepair> ownerRepairs = new ArrayList<>();
        try {
            ownerRepairs = propertyRepairRepository.readPerOwnerVAT(ownerVat);
        } catch(Exception e) { 
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        if(ownerRepairs.isEmpty()){
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.INFO, "There are no repairs active for this user");
        }
        return ownerRepairs;
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


    @Override
    public boolean updateOwnerAddress(Owner owner, String ownerAddress) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

