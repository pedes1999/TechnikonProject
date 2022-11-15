package gr.ed.TechnikonProject.repository.repositoryImpl;

import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyRepairRepositoryImpl extends RepositoryImpl<PropertyRepair> implements PropertyRepairRepository {

    //To be Changed
    @Override
    public void updateAll(int propertyRepairId, PropertyRepair newData) {
        PropertyRepair repair = read(propertyRepairId);
        if (repair != null) {
            repair.setRepairOwnerId(newData.getRepairOwnerId());
            repair.setRepairPropertyId(newData.getRepairPropertyId());
            repair.setRepairType(newData.getRepairType());
            repair.setRepairDescription(newData.getRepairDescription());
            repair.setRepairSubmissionDate(newData.getRepairSubmissionDate());
            repair.setRepairWorkToBeDone(newData.getRepairWorkToBeDone());
            repair.setRepairProposedStartDate(newData.getRepairProposedStartDate());
            repair.setRepairProposedEndDate(newData.getRepairProposedEndDate());
            repair.setRepairProposedCost(newData.getRepairProposedCost());
            repair.setRepairAcceptance(newData.getRepairAcceptance());
            repair.setRepairStatus(newData.getRepairStatus());
            repair.setRepairActualStartDate(newData.getRepairActualStartDate());
            repair.setRepairActualEndDate(newData.getRepairActualEndDate());

        }
    }

    @Override
    public List<PropertyRepair> searchPerOwnerId(int ownerId) {
        return read()
                .stream()
                .filter(pr -> pr.getRepairOwnerId().equals(ownerId))
                .collect(Collectors.toList());

    }

    @Override
    public List<PropertyRepair> searchPerDate(LocalDate date) {
        return read()
                .stream()
                .filter(pr -> pr.getRepairActualStartDate().equals(date) || pr.getRepairActualEndDate().equals(date))
                .collect(Collectors.toList());
    }

}
