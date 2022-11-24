
package gr.ed.TechnikonProject.service;

import gr.ed.TechnikonProject.enums.RepairAcceptance;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.model.PropertyRepair;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PropertyRepairService {
    boolean addPropertyRepair(final PropertyRepair propertyRepair);
    
    PropertyRepair searchRepairByRepairId(int propertyRepairId);
    
    List<PropertyRepair> getAllOwnerRepairs(String ownerVat);
    List<PropertyRepair> getAllPropertyRepairs();
    
    List<PropertyRepair> searchRepairsByDate(final LocalDate date);
    List<PropertyRepair> searchRepairsByDate(final LocalDate startDate, final LocalDate endDate);
    
    boolean updatePropertyRepairProposedStartDate(PropertyRepair propertyRepair, LocalDate prPropStart);
    boolean updatePropertyRepairProposedEndDate(PropertyRepair propertyRepair, LocalDate prPropEnd);
    boolean updatePropertyRepairProposedCost(PropertyRepair propertyRepair, BigDecimal prPropCost);
    boolean updatePropertyRepairStatus(PropertyRepair propertyRepair , RepairStatus repairStatus);
    boolean updatePropertyRepairActualStartDate(PropertyRepair propertyRepair, LocalDate prActualStart);
    boolean updatePropertyRepairActualEndDate(PropertyRepair propertyRepair, LocalDate prActualEnd);
    boolean updateRepairBasedOnAcceptance(PropertyRepair propertyRepair);
    boolean updateRepairAcceptance(final PropertyRepair propertyRepair, RepairAcceptance repairAcceptance);
    
    boolean deletePropertyRepair(PropertyRepair propertyRepair);
}
