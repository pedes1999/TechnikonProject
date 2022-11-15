package gr.ed.TechnikonProject.repository.repositoryImpl;

import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;

public class PropertyRepairRepositoryImpl extends RepositoryImpl<PropertyRepair> implements PropertyRepairRepository {

    @Override
    public void updateAll(int propertyRepairId, PropertyRepair newData) {
        //        PropertyRepair repair = read(propertyRepairId);
//        if(repair != null) {
//            repair.setRepairOwnerVAT(newData.getRepairOwnerVAT());
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
