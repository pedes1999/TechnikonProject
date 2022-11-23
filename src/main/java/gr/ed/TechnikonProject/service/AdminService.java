package gr.ed.TechnikonProject.service;

import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import java.time.LocalDate;
import java.util.List;

public interface AdminService extends OwnerService {
    //add owner
    boolean addOwner(Owner owner);

    //read Owners
    Owner searchOwnerPerVat(String ownerVatNumber);
    Owner searchOwnerPerEmail(String ownerEmail);


    Owner searchOwnerByOwnerId(int ownerId);
    Property searchPropertyByPropertyId(int propertyId);
    PropertyRepair searchRepairByRepairId(int propertyRepairId);
                         
    //admin report
    List<PropertyRepair> getAllPropertyRepairs();
   

    boolean updatePropertyRepairProposedStartDate(PropertyRepair propertyRepair, LocalDate prPropStart);
    boolean updatePropertyRepairProposedEndDate(PropertyRepair propertyRepair, LocalDate prPropEnd);
    boolean updatePropertyRepairProposedCost(PropertyRepair propertyRepair, double prPropCost);
    boolean updatePropertyRepairStatus(PropertyRepair propertyRepair , RepairStatus repairStatus);
    boolean updatePropertyRepairActualStartDate(PropertyRepair propertyRepair, LocalDate prActualStart);
    boolean updatePropertyRepairActualEndDate(PropertyRepair propertyRepair, LocalDate prActualEnd);
    
    //Update the repair Based on User Acceptance
    boolean updateRepairBasedOnAcceptance(PropertyRepair propertyRepair);
    
    //delete (3)
    boolean deletePropertyRepair(PropertyRepair propertyRepair);

    boolean deleteProperty(Property property);

    boolean deleteOwner(Owner owner);

}
