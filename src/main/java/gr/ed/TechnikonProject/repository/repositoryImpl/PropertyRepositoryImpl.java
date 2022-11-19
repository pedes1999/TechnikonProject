package gr.ed.TechnikonProject.repository.repositoryImpl;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.time.LocalDate;
import java.util.List;


public class PropertyRepositoryImpl implements PropertyRepository{

    protected EntityManager entityManager;

    public PropertyRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
  
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

    @Override
    public Property read(int id) {
         Property p = entityManager.find(Property.class, id);
        if (p != null) {
            return p;
        } else {
            return null;
        }
    }
    

    @Override
    public List<Property> read() {
        return entityManager.createQuery("from Property").getResultList();
    }
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

   

    @Override

    public List<Property> readByVATNumber(String PropertyVATOwner) {
       
        String findpropertyVATOwnerString = "select * from property"
               +" inner join owner on property.propertyOwner_ownerId = owner.ownerId"
                + " where owner.ownerVat = ?";
               

        Query findpropertyVATOwnerQuery = entityManager.createNativeQuery(findpropertyVATOwnerString, Property.class);
        
        try {
            findpropertyVATOwnerQuery.setParameter(1, PropertyVATOwner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findpropertyVATOwnerQuery.getResultList();
    
    }
    
      @Override
    public List<Property> readByPropertyE9(int propertyId) {
       String findpropertyE9String = "select * from property"
                + "where propertyE9 = ?";

        Query findpropertyE9Query = entityManager.createNativeQuery( findpropertyE9String, Property.class);

        try {
            findpropertyE9Query.setParameter(1, propertyId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findpropertyE9Query.getResultList();
    
    }


    @Override
    public boolean updatePropertyConstructionYear(int propertyId, LocalDate propertyConstructionYear) {
        Property property = read(propertyId);
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
    

    @Override
    public boolean updatePropertyType(int propertyId, PropertyType propertyType) {
       Property property = read(propertyId);
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
  

    @Override
    public boolean updatePropertyAddress(int propertyId, String propertyAddress) {
       Property property = read(propertyId);
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