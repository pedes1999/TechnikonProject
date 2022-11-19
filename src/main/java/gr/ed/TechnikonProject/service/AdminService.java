package gr.ed.TechnikonProject.service;

import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import java.time.LocalDate;

public interface AdminService extends OwnerService {
    //add owner
    //add property
    //add repair
    boolean addOwner(Owner owner);
    
    //read Owners
    Owner searchOwnerPerVat(String ownerVatNumber);
    Owner searchOwnerPerEmail(String ownerEmail);
    
    PropertyRepair searchRepairPerId(int propertyRepairId);
    
    //Proposed
    boolean updatePropertyRepairProposedStartDate(PropertyRepair propertyRepair, LocalDate prPropStart);
    boolean updatePropertyRepairProposedEndDate(PropertyRepair propertyRepair, LocalDate prPropEnd);
    boolean updatePropertyRepairProposedCost(PropertyRepair propertyRepair, double prPropCost);

    //Actual
    boolean updatePropertyRepairActualStartDate(PropertyRepair propertyRepair, LocalDate prActualStart);
    boolean updatePropertyRepairActualEndDate(PropertyRepair propertyRepair, LocalDate prActualEnd);

    //delete (3)
    boolean deletePropertyRepair(PropertyRepair propertyRepair);
    boolean deleteProperty(Property property);
    boolean deleteOwner(Owner owner);

}
