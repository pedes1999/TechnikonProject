package gr.ed.TechnikonProject.service;

import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import java.util.List;

public interface OwnerService {

    //add Repair(create)
    //add Property
    boolean addProperty(final Property property);

    boolean addPropertyRepair(final PropertyRepair propertyRepair);

    //read 
    List<Property> searchByPropertyE9(int propertyE9);

    List<Property> searchByVATNumber(String propertyVATOwner);

    //accept Offer
    boolean updateRepairAcceptance(int propertyRepairId, boolean repairAcceptance);
}
