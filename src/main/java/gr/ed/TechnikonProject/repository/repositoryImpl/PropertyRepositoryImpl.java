package gr.ed.TechnikonProject.repository.repositoryImpl;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.model.Owner;
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
    public List<Property> readByPropertyE9(int propertyE9) {
       String findpropertyE9String = "select * from property"
                + "where propertyE9 = ?";

        Query findpropertyE9Query = entityManager.createNativeQuery( findpropertyE9String, Property.class);

        try {
            findpropertyE9Query.setParameter(1, propertyE9);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findpropertyE9Query.getResultList();
    
    }


    @Override
    public boolean updatePropertyConstructionYear(int propertyE9, LocalDate propertyConstructionYear) {
        Property property = read(propertyE9);
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
    public boolean updatePropertyType(int propertyE9, PropertyType propertyType) {
       Property property = read(propertyE9);
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
    public boolean updatePropertyAddress(int propertyE9, String propertyAddress) {
       Property property = read(propertyE9);
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