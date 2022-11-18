
package gr.ed.TechnikonProject.util;

import gr.ed.TechnikonProject.enums.RepairType;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.repositoryImpl.PropertyRepairRepositoryImpl;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestJpa {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        PropertyRepairRepository repairRepo = new PropertyRepairRepositoryImpl(entityManager);
         PropertyRepair pr = new PropertyRepair();
         Property p = new Property();
         Owner o = new Owner();
         o.setOwnerVat("1234567890");
         p.setPropertyOwner(o);
         //pr.setRepairProperty(p);
         pr.setRepairDescription("Electrical work on the Balcony");
         pr.setRepairType(RepairType.PAINTING);
         
//         //repairRepo.create(pr);
//         System.out.println(repairRepo.read(3));
//         System.out.println(repairRepo.delete(3));
//         System.out.println(repairRepo.read());
//         
//          try {
//            repairRepo.updateRepairActualStartDate(5,  LocalDate.of(2022, 11, 18));
//        } catch (Exception ex) {
//            Logger.getLogger(TestJpa.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         
//        try {
//            repairRepo.updateRepairActualEndDate(5,  LocalDate.of(2022, 11, 28));
//        } catch (Exception ex) {
//            Logger.getLogger(TestJpa.class.getName()).log(Level.SEVERE, null, ex);
//        }
//System.out.println(repairRepo.readPerDate( LocalDate.of(2022, 11, 18)));
System.out.println(repairRepo.readPerRangeOfDates( LocalDate.of(2022, 11, 18),LocalDate.of(2022, 11, 28)));
       
    }
   
    
   
    
}
