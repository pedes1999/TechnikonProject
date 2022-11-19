
package gr.ed.TechnikonProject.util;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.enums.RepairType;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import gr.ed.TechnikonProject.repository.repositoryImpl.PropertyRepairRepositoryImpl;
import gr.ed.TechnikonProject.repository.repositoryImpl.PropertyRepositoryImpl;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Serializable;

public class TestJpa {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        PropertyRepository pr = new PropertyRepositoryImpl(entityManager);
      //  PropertyRepairRepository repairRepo = new PropertyRepairRepositoryImpl(entityManager);
         //PropertyRepair pr = new PropertyRepair();
         Property p = new Property();
        Owner o = new Owner();
         o.setOwnerVat("1234567890");
        // p.setPropertyOwner(o);
        // p.setPropertyOwner(o);
         p.setPropertyAddress("keas");
        // p.setPropertyConstructionYear(LocalDate.of(2010, 1, 20)); 
         p.setPropertyType(PropertyType.MAISONETTE);
         p.setpropertyE9(1234567892);
        p.setPropertyOwner(o);
         pr.create(p);
         System.out.println(p.getPropertyOwner());
         //System.out.println(pr.de);
          
        // System.out.println(pr.read(1));
         //System.out.println(pr.read(3));
                  
         // System.out.println(pr.delete(1));
         // System.out.println(pr.read(1));
        // System.out.println(o.getOwnerVat());
         // System.out.println(p.getPropertyOwner().toString());
            System.out.println("----");
            System.out.println(pr.read().toString());
            //System.out.println(pr.readByVATNumber(o.getOwnerVat()));
          }
         // pr.read();
    //pr.setRepairProperty(p);
       //  pr.setRepairDescription("Electrical work on the Balcony");
        // pr.setRepairType(RepairType.PAINTING);
         
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
//System.out.println(repairRepo.readPerRangeOfDates( LocalDate.of(2022, 11, 18),LocalDate.of(2022, 11, 28)));
       
    }
   

