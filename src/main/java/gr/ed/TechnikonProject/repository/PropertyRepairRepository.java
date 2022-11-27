package gr.ed.TechnikonProject.repository;

import gr.ed.TechnikonProject.enums.RepairAcceptance;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.model.PropertyRepair;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PropertyRepairRepository extends Repository<PropertyRepair> {

    //Read based on specific criteria.
    List<PropertyRepair> readPerOwnerVAT(String ownerVAT);
    
    List<PropertyRepair> readPerDate(LocalDate date);

    List<PropertyRepair> readPerRangeOfDates(LocalDate startDate, LocalDate endDate);

    //Repair Date Handling.
    boolean updateRepairProposedStartDate(int propertyRepairId, LocalDate dateTime) throws Exception;

    boolean updateRepairProposedEndDate(int propertyRepairId, LocalDate dateTime) throws Exception;

    boolean updateRepairActualStartDate(int propertyRepairId, LocalDate dateTime) throws Exception;

    boolean updateRepairActualEndDate(int propertyRepairId, LocalDate dateTime) throws Exception;

    boolean updateRepairProposedCost(int propertyRepairId, BigDecimal cost) throws Exception;

    boolean updateRepairAcceptance(int propertyRepairId, RepairAcceptance repairAcceptance) throws Exception;

    boolean updateRepairStatus(int propertyRepairId, RepairStatus repairStatus) throws Exception;

    //Repair misc handling
    boolean updateRepair(int propertyRepairId, PropertyRepair newPropertyRepair);

}
