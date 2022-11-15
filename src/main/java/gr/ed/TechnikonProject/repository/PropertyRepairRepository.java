package gr.ed.TechnikonProject.repository;

import gr.ed.TechnikonProject.model.PropertyRepair;
import java.time.LocalDate;
import java.util.List;

public interface PropertyRepairRepository extends Repository<PropertyRepair> {

    /**
     *
     * @param propertyRepairId
     * @param newData
     * Updates all Given Repair Information
     */
    void updateAll(int propertyRepairId,PropertyRepair newData);
    
    /**
     *
     * @param ownerId
     * @return List of Repairs for a specific owner ID
     */
    List<PropertyRepair> searchPerOwnerId(int ownerId);
    
    /**
     *
     * @param date
     * @return List of Repairs for the Actual Date Given
     */
    List<PropertyRepair> searchPerDate(LocalDate date);
}
