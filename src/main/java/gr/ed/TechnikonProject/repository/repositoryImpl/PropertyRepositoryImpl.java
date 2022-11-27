package gr.ed.TechnikonProject.repository.repositoryImpl;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PropertyRepositoryImpl implements PropertyRepository {

    protected EntityManager entityManager;

    public PropertyRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Creates property
     *
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
    public Optional<Property> read(int id) {
        Property p = entityManager.find(Property.class, id);
        if (p != null) {
            return Optional.of(p);
        } else {
            return Optional.empty();
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
     *
     * @param id
     * @return true if the property is deleted correctly
     */
    @Override
    public boolean delete(int id) {
        Property persistentInstance = entityManager.find(Property.class, id);
        if (persistentInstance != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(persistentInstance);
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
    public List<Property> readByVATNumber(String ownerVat) {
        //String ow = PropertyVATOwner.getOwnerVat();
        String findpropertyVATOwnerString = "select * from property"
                + " inner join owner on property.propertyOwner_ownerId = owner.ownerId"
                + " where owner.ownerVat = ?";

        Query findpropertyVATOwnerQuery = entityManager.createNativeQuery(findpropertyVATOwnerString, Property.class);

        try {
            findpropertyVATOwnerQuery.setParameter(1, ownerVat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findpropertyVATOwnerQuery.getResultList();

    }

    /**
     *
     * @param id of Property
     * @param propertyConstructionYear
     * @return true if the construction year is updated correctly
     */
    @Override
    public boolean updatePropertyConstructionYear(int id, LocalDate propertyConstructionYear) {
        Optional<Property> property = read(id);
        if (property.isPresent()) {
            try {
                Property property2 = property.get();
                property2.setPropertyConstructionYear(propertyConstructionYear);
                entityManager.getTransaction().begin();
                entityManager.merge(property2);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }
        return false;
    }

    /**
     *
     * @param id of the Property
     * @param propertyType
     * @return true if the property type is updated correctly
     */
    @Override
    public boolean updatePropertyType(int id, PropertyType propertyType) {
        Optional<Property> property = read(id);
        if (property.isPresent()) {
            try {
                Property property2 = property.get();
                property2.setPropertyType(propertyType);
                entityManager.getTransaction().begin();
                entityManager.merge(property2);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }
        return false;
    }

    /**
     *
     * @param id of Property
     * @param propertyAddress
     * @return true if the property's address is updated correctly
     */
    @Override
    public boolean updatePropertyAddress(int id, String propertyAddress
    ) {
        Optional<Property> property = read(id);
        if (property.isPresent()) {
            try {
                Property property2 = property.get();
                property2.setPropertyAddress(propertyAddress);
                entityManager.getTransaction().begin();
                entityManager.merge(property2);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }
        return false;
    }

}
