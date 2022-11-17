package gr.ed.TechnikonProject.repository;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import java.time.Year;
import java.util.List;

public interface PropertyRepository extends Repository<Property> {
    List<Property> readByPropertyIdE9 (int propertyIdE9);
    List<Property> readByVATNumber (Owner propertyVATOwner);
    boolean updatePropertyAddress (int propertyIdE9, String propertyAddress);
    boolean  updatePropertyConstructionYear (int propertyIdE9, Year propertyConstructionYear);
    boolean updatePropertyType (int propertyIdE9, PropertyType propertyType);
}