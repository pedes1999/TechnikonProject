package gr.ed.TechnikonProject.repository;

import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.RepairType;
import gr.ed.TechnikonProject.model.PropertyRepair;
import java.time.LocalDate;
import java.util.List;

public interface PropertyRepairRepository extends Repository<PropertyRepair> {
    
    //Read based on owner VAT
    
    /**
     *
     * @param ownerVAT
     * @return List of Repairs for a specific owner ID
     */
    List<PropertyRepair> readPerOwnerVAT(String ownerVAT);
    
    /**
     *
     * @param date
     * @return List of Repairs for a Date Given
     */
    List<PropertyRepair> readPerDate(LocalDate date);
    
    /**
     *
     * @param startDate
     * @param endDate
     * @return List of repairs based on a range of given Dates;
     */
    List<PropertyRepair> readPerRangeOfDates(LocalDate startDate , LocalDate endDate);
    
    /**
     *
     * @param propertyRepairId
     * @param dateTime
     * @return if Date is updated
     * @throws Exception
     */
    boolean updateDateTime(int propertyRepairId , LocalDate dateTime) throws Exception;
    
    /**
     *
     * @param propertyRepairId
     * @param repairType
     * @return if repair type is Updated
     * @throws Exception
     */
    boolean updateRepairType(int propertyRepairId , RepairType repairType) throws Exception;
    
    /**
     *
     * @param propertyRepairId
     * @param repairDesc
     * @return if Repair Description is Updated
     * @throws Exception
     */
    boolean updateRepairDesc(int propertyRepairId , String repairDesc) throws Exception;
    
    /**
     *
     * @param propertyRepairId
     * @param repairWorkToBeDone
     * @return if Work to Be Done is updated
     * @throws Exception
     */
    boolean updateRepairWorkToBeDone(int propertyRepairId , String repairWorkToBeDone) throws Exception;
    
    /**
     *
     * @param propertyRepairId
     * @param repairAcceptance
     * @return if the acceptance is updated
     * @throws Exception
     */
    boolean updateRepairAcceptance(int propertyRepairId , boolean repairAcceptance) throws Exception;
    
    /**
     *
     * @param propertyRepairId
     * @param repairCost
     * @return if the cost is updated
     * @throws Exception
     */
    boolean updateProposedCost(int propertyRepairId , double repairCost) throws Exception;
    
    /**
     *
     * @param propertRepairId
     * @param repairStatus
     * @return if the repair status has been updated
     * @throws Exception
     */
    boolean updateRepairStatus(int propertRepairId,RepairStatus repairStatus) throws Exception;
    
}
