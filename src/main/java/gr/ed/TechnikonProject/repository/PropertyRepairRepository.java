package gr.ed.TechnikonProject.repository;

import gr.ed.TechnikonProject.enums.RepairAcceptance;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.model.PropertyRepair;
import java.math.BigDecimal;
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
    List<PropertyRepair> readPerRangeOfDates(LocalDate startDate, LocalDate endDate);

    //Repair Date Handling
    boolean updateRepairProposedStartDate(int propertyRepairId, LocalDate dateTime) throws Exception;

    boolean updateRepairProposedEndDate(int propertyRepairId, LocalDate dateTime) throws Exception;

    boolean updateRepairActualStartDate(int propertyRepairId, LocalDate dateTime) throws Exception;

    boolean updateRepairActualEndDate(int propertyRepairId, LocalDate dateTime) throws Exception;

    boolean updateRepairProposedCost(int propertyRepairId, BigDecimal cost) throws Exception;
    
    boolean updateRepairAcceptance(int propertyRepairId, RepairAcceptance repairAcceptance) throws Exception;
    
    boolean updateRepairStatus(int propertyRepairId, RepairStatus repairStatus) throws Exception;

    //repair misc handling
    boolean updateRepair(int propertyRepairId, PropertyRepair newPropertyRepair);

}
