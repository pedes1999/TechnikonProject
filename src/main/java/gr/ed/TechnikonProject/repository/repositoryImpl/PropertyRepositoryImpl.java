package gr.ed.TechnikonProject.repository.repositoryImpl;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class PropertyRepositoryImpl implements PropertyRepository {

    protected EntityManager entityManager;

    public PropertyRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * Creates property
     * @param t
     * @return the id of the property that been created
     */
    @Override
    public int create(Property t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return t.getPropertyId();
    }

    /**
     * 
     * @param id
     * @return the property which has id same with the given one
     */
    @Override
    public Property read(int id) {
        Property p = entityManager.find(Property.class, id);
        if (p != null) {
            return p;
        } else {
            return null;
        }
    }

    /**
     * 
     * @return the list of the properties 
     */
    @Override
    public List<Property> read() {
        return entityManager.createQuery("from Property").getResultList();
    }
    
    /**
     * Deletes a property
     * @param id
     * @return true if the property is deleted correctly
     */
    @Override
    public boolean delete(int id) {
        Property p = read(id);
        if (p != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(p);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return true;
    }
    
    /**
     * 
     * @param PropertyVATOwner The VAT number of the owner
     * @return the list of properties with the same VAT number 
     */
    @Override
    public List<Property> readByVATNumber(Owner PropertyVATOwner) {
        String ow = PropertyVATOwner.getOwnerVat();
        String findpropertyVATOwnerString = "select * from property"
                + " inner join owner on property.propertyOwner_ownerId = owner.ownerId"
                + " where owner.ownerVat = ?";

        Query findpropertyVATOwnerQuery = entityManager.createNativeQuery(findpropertyVATOwnerString, Property.class);

        try {
            findpropertyVATOwnerQuery.setParameter(1, ow);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findpropertyVATOwnerQuery.getResultList();

    }

    /**
     * 
     * @param propertyE9
     * @return the property with E9 the given one
     */
    @Override
    public Property readByPropertyE9(int propertyE9) {
        String findpropertyE9String = "select * from property"
                + " where propertyE9 =?";

        Query findpropertyE9Query = entityManager.createNativeQuery(findpropertyE9String, Property.class);
       
        try {
             findpropertyE9Query.setParameter(1, propertyE9);
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return (Property) findpropertyE9Query.getSingleResult();
    }
    
    /**
     * 
     * @param id of Property
     * @param propertyConstructionYear
     * @return true if the construction year is updated correctly
     */
    @Override
    public boolean updatePropertyConstructionYear(int id, LocalDate propertyConstructionYear) {
        Property property = read(id);

        try {
            property.setPropertyConstructionYear(propertyConstructionYear);
            entityManager.getTransaction().begin();
            entityManager.merge(property);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 
     * @param id of the Property
     * @param propertyType
     * @return  true if the property type is updated correctly
     */
    @Override
    public boolean updatePropertyType(int id, PropertyType propertyType) {
        Property property = read(id);
        try {
            property.setPropertyType(propertyType);
            entityManager.getTransaction().begin();
            entityManager.merge(property);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
    
    /**
     * 
     * @param id of Property
     * @param propertyAddress
     * @return  true if the property's address is updated correctly
     */
    @Override
    public boolean updatePropertyAddress(int id, String propertyAddress) {
        Property property = read(id);
        try {
            property.setPropertyAddress(propertyAddress);
            entityManager.getTransaction().begin();
            entityManager.merge(property);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
