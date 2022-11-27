package gr.ed.TechnikonProject.repository;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.model.Property;
import java.time.LocalDate;
import java.util.List;

public interface PropertyRepository extends Repository<Property> {
    List<Property> readByVATNumber(String ownerVat) throws Exception;

    boolean updatePropertyAddress(int propertyId, String propertyAddress) throws Exception;


    boolean updatePropertyConstructionYear(int propertyId, LocalDate propertyConstructionYear) throws Exception;

    boolean updatePropertyType(int propertyId, PropertyType propertyType) throws Exception;
}
