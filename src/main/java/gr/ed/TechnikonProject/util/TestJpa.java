package gr.ed.TechnikonProject.util;

import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import gr.ed.TechnikonProject.repository.repositoryImpl.PropertyRepairRepositoryImpl;
import gr.ed.TechnikonProject.repository.repositoryImpl.PropertyRepositoryImpl;
import jakarta.persistence.EntityManager;

public class TestJpa {

    public static void main(String[] args) throws Exception{
        EntityManager entityManager = JpaUtil.getEntityManager();
        PropertyRepository propertyRepo = new PropertyRepositoryImpl(entityManager);
        PropertyRepairRepository repairRepo = new PropertyRepairRepositoryImpl(entityManager);
        DataImport dI = new DataImport(repairRepo,propertyRepo);
        //dI.insertProperties();
        dI.insertPropertyRepairs();
        
        
        //System.out.println(repairRepo.readPerDate(LocalDate.of(2022, 8, 22)));
        
        
    }
}
