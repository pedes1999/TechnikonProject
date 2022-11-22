package gr.ed.TechnikonProject.service;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import java.time.LocalDate;
import java.util.List;

public interface OwnerService {

    boolean addProperty(final Property property);

    boolean addPropertyRepair(final PropertyRepair propertyRepair);

    Property searchPropertyByPropertyId(int propertyId);

    //Owner Reports
    List<Property> searchPropertyByVATNumber(Owner propertyOwner);

    List<PropertyRepair> getAllRepairs(Owner owner);

    //Repair Searches
    
    Property searchPropertyByPropertyId(int propertyId);

    List<Property> searchPropertyByVATNumber(Owner propertyVATOwner);

    
    List<PropertyRepair> searchRepairsByDate(final LocalDate date);

    List<PropertyRepair> searchRepairsByDate(final LocalDate startDate, final LocalDate endDate);

    PropertyRepair searchRepairPerId(int propertyRepairId);


    //update owner info
    boolean updateOwnerAddress(final Owner owner, String ownerAddress);
    boolean updateOwnerEmail(final Owner owner, String ownerEmail);
    boolean updateOwnerPwd(final Owner owner, String ownerPwd);
    
    //update repair info
    //update property info

    boolean updatePropertyAddress(final Property property, String propertyAddress);

    boolean updatePropertyConstructionYear(final Property property, LocalDate propertyConstructionYear);

    boolean updatePropertyType(final Property property, PropertyType propertyType);

    

    //accept Offer
    boolean updateRepairAcceptance(final PropertyRepair propertyRepair, boolean repairAcceptance);
    

    //validation
    boolean isEmailValid(String email);

    boolean isIdValid();

    boolean isPwdValid();


    //accept Offer
    boolean updateRepairAcceptance(final PropertyRepair propertyRepair, boolean repairAcceptance);
}
