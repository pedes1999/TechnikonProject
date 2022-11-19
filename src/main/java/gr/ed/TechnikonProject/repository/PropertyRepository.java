package gr.ed.TechnikonProject.repository;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.model.Property;
import java.time.LocalDate;
import java.util.List;

public interface PropertyRepository extends Repository<Property> {
    List<Property> readByPropertyE9 (int propertyId);
    List<Property> readByVATNumber (String propertyVATOwner);
    boolean updatePropertyAddress (int propertyId, String propertyAddress);
    boolean  updatePropertyConstructionYear (int propertyId, LocalDate propertyConstructionYear);
    boolean updatePropertyType (int propertyId, PropertyType propertyType);
}