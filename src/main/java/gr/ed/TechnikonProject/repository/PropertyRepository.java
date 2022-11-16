package gr.ed.TechnikonProject.repository;

import gr.ed.TechnikonProject.model.Property;
import java.util.List;

public interface PropertyRepository extends Repository<Property> {
    
    /**
     * Updates all the values of a property
     * @param propertyId
     * @param newProperty 
     */
    void updateAll(int propertyId, Property newProperty);
    
    /**
     * 
     * @param propertyE9
     * @return 
     */
    List<Property> searchByPropertyId(int propertyE9);
    
    /**
     * Returns a list of properties of an owner using his/her VAT number
     * @param propertyVATOwner
     * @return 
     */
    List<Property> searchByVATNumber(String propertyVATOwner);
}
