package gr.ed.TechnikonProject.service;

import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import java.util.List;

public interface OwnerService {

    //add Repair(create)
    //add Property
    boolean addProperty(final Property property);
    boolean addPropertyRepair(final PropertyRepair propertyRepair);

    //read 
    Property searchByPropertyId(int propertyId);
    List<Property> searchByVATNumber(Owner propertyVATOwner);

    
    
    //accept Offer
    boolean updateRepairAcceptance(int propertyRepairId, boolean repairAcceptance);
}

