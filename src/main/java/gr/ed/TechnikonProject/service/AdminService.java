package gr.ed.TechnikonProject.service;

import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.RepairType;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import java.time.LocalDate;

public interface AdminService extends OwnerService {
    //add owner
    //add property
    //add repair

    //update owner
    //update property
    //update repair
    boolean updatePropertyRepairType(PropertyRepair propertyRepair, RepairType prType);
    boolean updatePropertyRepairDesc(PropertyRepair propertyRepair, String prDescription);
    boolean updatePropertyRepairWorkToBeDone(PropertyRepair propertyRepair, String prWorkToBeDone);
    boolean updatePropertyRepairStatus(PropertyRepair propertyRepair, RepairStatus prStatus);

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
