package gr.ed.TechnikonProject.util;

import gr.ed.TechnikonProject.repository.OwnerRepository;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import gr.ed.TechnikonProject.repository.repositoryImpl.OwnerRepositoryImpl;
import gr.ed.TechnikonProject.repository.repositoryImpl.PropertyRepairRepositoryImpl;
import gr.ed.TechnikonProject.repository.repositoryImpl.PropertyRepositoryImpl;
import jakarta.persistence.EntityManager;

public class TestJpa {

    public static void main(String[] args) throws Exception {
        EntityManager entityManager = JpaUtil.getEntityManager();
        PropertyRepository propertyRepo = new PropertyRepositoryImpl(entityManager);
        PropertyRepairRepository repairRepo = new PropertyRepairRepositoryImpl(entityManager);
        OwnerRepository ownerRepo = new OwnerRepositoryImpl(entityManager);
        DataImport dI = new DataImport(repairRepo, propertyRepo, ownerRepo);
        //UCOMMENT EDW MAGKES TIS 3 ENTOLES
        dI.insertUsers();
        dI.insertProperties();
        dI.insertPropertyRepairs();

        //REPAIRS
        //System.out.println(repairRepo.readPerOwnerVAT("1234567893"));
        //System.out.println(repairRepo.readPerDate(LocalDate.of(2022,08,22)));
        //System.out.println(repairRepo.updateRepairActualEndDate(1, LocalDate.of(2023,11,22)));
        //System.out.println(repairRepo.updateRepairActualStartDate(1, LocalDate.of(2023,5,10)));
        //System.out.println(repairRepo.readPerRangeOfDates(LocalDate.of(2022, 11, 9), LocalDate.of(2022, 11, 22)));
        //System.out.println(repairRepo.readPerDate(LocalDate.of(2023,6,10)));
        //System.out.println(repairRepo.delete(3));
        //Properties
        //System.out.println(propertyRepo.readByVATNumber("1234567891"));
        //System.out.println(propertyRepo.read());
        //Owner
        //System.out.println(ownerRepo.readOwnerEmail("adsasasd@gmail.com"));
        //System.out.println(ownerRepo.readOwnerVat("1234567893"));
    }
}
