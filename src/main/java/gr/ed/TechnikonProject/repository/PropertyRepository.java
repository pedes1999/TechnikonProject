package gr.ed.TechnikonProject.repository;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.model.Property;
import java.time.LocalDate;
import java.util.List;

public interface PropertyRepository extends Repository<Property> {
    List<Property> readByPropertyE9 (int propertyE9);
    List<Property> readByVATNumber (String propertyVATOwner);
    boolean updatePropertyAddress (int propertyE9, String propertyAddress);
    boolean  updatePropertyConstructionYear (int propertyE9, LocalDate propertyConstructionYear);
    boolean updatePropertyType (int propertyE9, PropertyType propertyType);
}