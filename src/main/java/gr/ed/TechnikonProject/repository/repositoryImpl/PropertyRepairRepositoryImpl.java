package gr.ed.TechnikonProject.repository.repositoryImpl;

import gr.ed.TechnikonProject.enums.RepairAcceptance;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public Optional<PropertyRepair> read(int id) {
        PropertyRepair pr = entityManager.find(PropertyRepair.class, id);
        if (pr != null) {
            return Optional.of(pr);
        } else {
            return Optional.empty();
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
        PropertyRepair persistentInstance = entityManager.find(PropertyRepair.class, id);
        if (persistentInstance != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(persistentInstance);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
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
    public List<PropertyRepair> readPerOwnerVAT(String ownerVAT) throws Exception {
        String findRepairPerOwnerVATString = "select * from propertyrepair as pr "
                + "inner join property as p on pr.repairProperty_propertyId = p.propertyId "
                + " inner join owner as o on p.propertyOwner_ownerId = o.ownerId "
                + " where o.ownerVat = ? ";

        Query findRepairPerOwnerVATQuery = entityManager.createNativeQuery(findRepairPerOwnerVATString, PropertyRepair.class);

        try {
            findRepairPerOwnerVATQuery.setParameter(1, ownerVAT);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return findRepairPerOwnerVATQuery.getResultList();
    }

    /**
     *
     * @param date
     * @return List of repairs based on a given date
     */
    @Override
    public List<PropertyRepair> readPerDate(LocalDate date) throws Exception{
        String findRepairPerDateString = "select * from propertyrepair where ? between repairActualStartDate and repairActualEndDate";
        Query findRepairPerDateQuery = entityManager.createNativeQuery(findRepairPerDateString, PropertyRepair.class);
        try {
            findRepairPerDateQuery.setParameter(1, date);

        } catch (Exception e) {
           throw new Exception(e);
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
    public List<PropertyRepair> readPerRangeOfDates(LocalDate startDate, LocalDate endDate) throws Exception{
        String findRepairPerDatesString = "select * from propertyrepair where repairActualStartDate>=? and repairActualEndDate <= ?";
        Query findRepairPerDatesQuery = entityManager.createNativeQuery(findRepairPerDatesString, PropertyRepair.class);
        try {
            findRepairPerDatesQuery.setParameter(1, startDate);
            findRepairPerDatesQuery.setParameter(2, endDate);

        } catch (Exception e) {
            throw new Exception(e);
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
        Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
        if (propertyRepair.isPresent()) {
            try {
                PropertyRepair propertyRepair2 = propertyRepair.get();
                propertyRepair2.setRepairProposedStartDate(dateTime);
                entityManager.getTransaction().begin();
                entityManager.merge(propertyRepair2);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
               throw new Exception(e);
            }

            return true;
        }
        return false;
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
        Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
        if (propertyRepair.isPresent()) {
            try {
                PropertyRepair propertyRepair2 = propertyRepair.get();
                propertyRepair2.setRepairProposedEndDate(dateTime);
                entityManager.getTransaction().begin();
                entityManager.merge(propertyRepair2);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                throw new Exception(e);
            }

            return true;
        }
        return false;
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
        Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
        if (propertyRepair.isPresent()) {
            try {
                PropertyRepair propertyRepair2 = propertyRepair.get();
                propertyRepair2.setRepairActualStartDate(dateTime);
                entityManager.getTransaction().begin();
                entityManager.merge(propertyRepair2);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
             throw new Exception(e);
            }

            return true;
        }
        return false;
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
        Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
        if (propertyRepair.isPresent()) {
            try {
                PropertyRepair propertyRepair2 = propertyRepair.get();
                propertyRepair2.setRepairActualEndDate(dateTime);
                entityManager.getTransaction().begin();
                entityManager.merge(propertyRepair2);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                throw new Exception(e);
            }

            return true;
        }
        return false;
    }

    /**
     *
     * @param propertyRepairId
     * @param repairAcceptance
     * @return if acceptance of the repair has been updated
     * @throws Exception
     */
    @Override
    public boolean updateRepairAcceptance(int propertyRepairId, RepairAcceptance repairAcceptance) throws Exception {
        Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
        if (propertyRepair.isPresent()) {
            try {
                PropertyRepair propertyRepair2 = propertyRepair.get();
                propertyRepair2.setRepairAcceptance(repairAcceptance);
                entityManager.getTransaction().begin();
                entityManager.merge(propertyRepair2);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                throw new Exception(e);
            }

            return true;
        }
        return false;
    }

    /**
     *
     * @param propertyRepairId
     * @param cost
     * @return if Proposed Cost has been Updated
     * @throws Exception
     */
    @Override
    public boolean updateRepairProposedCost(int propertyRepairId, BigDecimal cost) throws Exception {
        Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
        if (propertyRepair.isPresent()) {
            try {
                PropertyRepair propertyRepair2 = propertyRepair.get();
                propertyRepair2.setRepairProposedCost(cost);
                entityManager.getTransaction().begin();
                entityManager.merge(propertyRepair2);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                throw new Exception(e);
            }

            return true;
        }
        return false;

    }

    /**
     *
     * @param propertyRepairId
     * @param newPropertyRepair
     * @return if the Repair has been updated
     */
    @Override
    public boolean updateRepair(int propertyRepairId, PropertyRepair newPropertyRepair
    ) throws Exception{
        Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
        if (propertyRepair.isPresent()) {
            try {
                PropertyRepair propertyRepair2 = propertyRepair.get();
                propertyRepair2.setRepairType(newPropertyRepair.getRepairType());
                propertyRepair2.setRepairDescription(newPropertyRepair.getRepairDescription());
                propertyRepair2.setRepairProperty(newPropertyRepair.getRepairProperty());
                propertyRepair2.setRepairWorkToBeDone(newPropertyRepair.getRepairWorkToBeDone());
                propertyRepair2.setRepairAcceptance(newPropertyRepair.getRepairAcceptance());
                propertyRepair2.setRepairStatus(newPropertyRepair.getRepairStatus());
                propertyRepair2.setRepairSubmissionDate(newPropertyRepair.getRepairSubmissionDate());
                entityManager.getTransaction().begin();
                entityManager.merge(propertyRepair2);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                throw new Exception(e);

            }
            return true;
        }
        return false;

    }

    @Override
    public boolean updateRepairStatus(int propertyRepairId, RepairStatus repairStatus) throws Exception {
        Optional<PropertyRepair> propertyRepair = read(propertyRepairId);
        if (propertyRepair.isPresent()) {
            try {
                PropertyRepair propertyRepair2 = propertyRepair.get();
                propertyRepair2.setRepairStatus(repairStatus);
                entityManager.getTransaction().begin();
                entityManager.merge(propertyRepair2);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
               throw new Exception(e);
            }

            return true;
        }
        return false;
    }

}
