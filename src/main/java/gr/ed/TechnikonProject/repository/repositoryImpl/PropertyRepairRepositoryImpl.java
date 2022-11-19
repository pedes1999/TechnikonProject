
package gr.ed.TechnikonProject.repository.repositoryImpl;

import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class PropertyRepairRepositoryImpl implements PropertyRepairRepository {

    protected EntityManager entityManager;

    public PropertyRepairRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     *
     * @param t
     * @return id of the created repair
     */
    @Override
    public int create(PropertyRepair t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return t.getPropertyRepairId();
    }

    /**
     *
     * @param id
     * @return repair record from given id
     */
    @Override
    public PropertyRepair read(int id) {
        PropertyRepair pr = entityManager.find(PropertyRepair.class, id);
        if (pr != null) {
            return pr;
        } else {
            return null;
        }

    }
    
    /**
     *
     * @return all repairs in the database
     */
    @Override
    public List<PropertyRepair> read() {
        return entityManager.createQuery("from PropertyRepair").getResultList();
    }

    /**
     *
     * @param id
     * @return if a record deleted from db
     */
    @Override
    public boolean delete(int id) {
        PropertyRepair pr = read(id);
        if (pr != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(pr);
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
     * @param ownerVAT
     * @return List of repairs based on a given owner VAT
     */
    @Override
    public List<PropertyRepair> readPerOwnerVAT(String ownerVAT) {
        String findRepairPerOwnerVATString = "select * from propertyrepair"
                + "inner join property on propertyrepair.repairProperty_propertyId = property.propertyId"
                + " inner join owner on owner.owner_ownerId = owner.ownerId"
                + " where owner.ownerVat = ?";

        Query findRepairPerOwnerVATQuery = entityManager.createNativeQuery(findRepairPerOwnerVATString, PropertyRepair.class);

        try {
            findRepairPerOwnerVATQuery.setParameter(1, ownerVAT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return findRepairPerOwnerVATQuery.getResultList();
    }

    /**
     *
     * @param date
     * @return List of repairs based on a given date
     */
    @Override
    public List<PropertyRepair> readPerDate(LocalDate date) {
        String findRepairPerDateString = "select * from propertyrepair where repairActualStartDate = ? or repairActualEndDate= ?";
        Query findRepairPerDateQuery = entityManager.createNativeQuery(findRepairPerDateString, PropertyRepair.class);
        try {
            findRepairPerDateQuery.setParameter(1, date);
            findRepairPerDateQuery.setParameter(2, date);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return findRepairPerDateQuery.getResultList();
    }

    /**
     *
     * @param startDate
     * @param endDate
     * @return List of repairs based on a given range of dates
     */
    @Override
    public List<PropertyRepair> readPerRangeOfDates(LocalDate startDate, LocalDate endDate) {
        String findRepairPerDatesString = "select * from propertyrepair where repairActualStartDate>=? and repairActualEndDate <= ?";
        Query findRepairPerDatesQuery = entityManager.createNativeQuery(findRepairPerDatesString, PropertyRepair.class);
        try {
            findRepairPerDatesQuery.setParameter(1, startDate);
            findRepairPerDatesQuery.setParameter(2, endDate);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return findRepairPerDatesQuery.getResultList();

    }

    /**
     *
     * @param propertyRepairId
     * @param dateTime
     * @return if Proposed Start Date has been Updated
     * @throws Exception
     */
    @Override
    public boolean updateRepairProposedStartDate(int propertyRepairId, LocalDate dateTime) throws Exception {
        PropertyRepair propertyRepair = read(propertyRepairId);
        try {
            propertyRepair.setRepairProposedStartDate(dateTime);
            entityManager.getTransaction().begin();
            entityManager.merge(propertyRepair);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *
     * @param propertyRepairId
     * @param dateTime
     * @return if Proposed End Date has been Updated
     * @throws Exception
     */
    @Override
    public boolean updateRepairProposedEndDate(int propertyRepairId, LocalDate dateTime) throws Exception {
        PropertyRepair propertyRepair = read(propertyRepairId);
        try {
            propertyRepair.setRepairProposedEndDate(dateTime);
            entityManager.getTransaction().begin();
            entityManager.merge(propertyRepair);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *
     * @param propertyRepairId
     * @param dateTime
     * @return if Actual Start Date has been Updated
     * @throws Exception
     */
    @Override
    public boolean updateRepairActualStartDate(int propertyRepairId, LocalDate dateTime) throws Exception {
        PropertyRepair propertyRepair = read(propertyRepairId);
        try {
            propertyRepair.setRepairActualStartDate(dateTime);
            entityManager.getTransaction().begin();
            entityManager.merge(propertyRepair);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *
     * @param propertyRepairId
     * @param dateTime
     * @return if Actual End Date has been Updated
     * @throws Exception
     */
    @Override
    public boolean updateRepairActualEndDate(int propertyRepairId, LocalDate dateTime) throws Exception {
        PropertyRepair propertyRepair = read(propertyRepairId);
        try {
            propertyRepair.setRepairActualEndDate(dateTime);
            entityManager.getTransaction().begin();
            entityManager.merge(propertyRepair);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *
     * @param propertyRepairId
     * @param cost
     * @return if Proposed Cost has been Updated
     * @throws Exception
     */
    @Override
    public boolean updateRepairProposedCost(int propertyRepairId, double cost) throws Exception {
        PropertyRepair propertyRepair = read(propertyRepairId);
        try {
            propertyRepair.setRepairProposedCost(cost);
            entityManager.getTransaction().begin();
            entityManager.merge(propertyRepair);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *
     * @param propertyRepairId
     * @param newPropertyRepair
     * @return if the Repair has been updated
     */
    @Override
    public boolean updateRepair(int propertyRepairId, PropertyRepair newPropertyRepair) {
        PropertyRepair propertyRepair = read(propertyRepairId);
        try {
            propertyRepair.setRepairType(newPropertyRepair.getRepairType());
            propertyRepair.setRepairDescription(newPropertyRepair.getRepairDescription());
            propertyRepair.setRepairProperty(newPropertyRepair.getRepairProperty());
            propertyRepair.setRepairWorkToBeDone(newPropertyRepair.getRepairWorkToBeDone());
            propertyRepair.setRepairAcceptance(newPropertyRepair.getRepairAcceptance());
            propertyRepair.setRepairStatus(newPropertyRepair.getRepairStatus());
            propertyRepair.setRepairSubmissionDate(newPropertyRepair.getRepairSubmissionDate());
            entityManager.getTransaction().begin();
            entityManager.merge(propertyRepair);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
        return true;

    }

}
