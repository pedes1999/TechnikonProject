package gr.ed.TechnikonProject.service;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.model.Property;
import java.time.LocalDate;
import java.util.List;

public interface PropertyService {
    boolean addProperty(final Property property);
    
    Property searchPropertyByPropertyId(int propertyId);
    List<Property> getAllOwnerProperties(String ownerVat);
    
    
    boolean updatePropertyAddress(final Property property, String propertyAddress);
    boolean updatePropertyConstructionYear(final Property property, LocalDate propertyConstructionYear);
    boolean updatePropertyType(final Property property, PropertyType propertyType);
    
    boolean deleteProperty(Property property);
}
