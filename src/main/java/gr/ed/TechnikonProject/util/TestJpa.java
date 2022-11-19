package gr.ed.TechnikonProject.util;


import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.OwnerRepository;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import gr.ed.TechnikonProject.repository.repositoryImpl.OwnerRepositoryImpl;
import gr.ed.TechnikonProject.repository.repositoryImpl.PropertyRepairRepositoryImpl;
import gr.ed.TechnikonProject.repository.repositoryImpl.PropertyRepositoryImpl;
import gr.ed.TechnikonProject.service.OwnerService;
import gr.ed.TechnikonProject.service.serviceImpl.OwnerServiceImpl;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;


public class TestJpa {

    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        PropertyRepository pr = new PropertyRepositoryImpl(entityManager);
        OwnerRepository ow = new OwnerRepositoryImpl(entityManager);
        PropertyRepairRepository prr = new PropertyRepairRepositoryImpl(entityManager);
        OwnerService os = new OwnerServiceImpl(ow,pr,prr);
        //  PropertyRepairRepository repairRepo = new PropertyRepairRepositoryImpl(entityManager);
        //PropertyRepair pr = new PropertyRepair();
        Property p = new Property();
        Owner o = new Owner();
        PropertyRepair pro = new PropertyRepair();
        o.setOwnerVat("1234567890");
        pro.setRepairAcceptance(true);
        
        os.addPropertyRepair(pro);
        System.out.println("--------------------");
        System.out.println(prr.read());
        os.updateRepairAcceptance(1, false);
        System.out.println(prr.read());
        // p.setPropertyOwner(o);
        // p.setPropertyOwner(o);
        o.setOwnerVat("143234");
        ow.create(o);
        System.out.println(o);
        System.out.println(o.getOwnerId());
        p.setPropertyAddress("keas");
        p.setPropertyE9(1234567890);
     p.setPropertyConstructionYear(LocalDate.of(2010, 1, 20)); 
        //p.setPropertyType(PropertyType.MAISONETTE);
        //p.setpropertyE9(1234567892);
        p.setPropertyOwner(o);
        os.addProperty(p);
        System.out.println("--------------------------");
        System.out.println(pr.readByPropertyE9(p.getPropertyE9()));
        System.out.println(os.searchByPropertyE9(p.getPropertyE9()));
        //System.out.println(pr.de);
        // System.out.println(pr.read(1));
        //System.out.println(pr.read(3));
        // System.out.println(pr.delete(1));
        // System.out.println(pr.read(1));
        // System.out.println(o.getOwnerVat());
        // System.out.println(p.getPropertyOwner().toString());
       // System.out.println("----");
      //  System.out.println(pr.read().toString());
        ///System.out.println(pr.readByPropertyE9(1234567892));
        // System.out.println(p.getPropertyId());
        // System.out.println(o.getOwnerId());
        // System.out.println(o.toString());
        
        // p.setPropertyAddress("kefallinias");

     
        // System.out.println(p.getPropertyOwner().getOwnerVat());
        //System.out.println(p.getPropertyOwner());
        //  System.out.println(pr.readByVATNumber(o.getOwnerVat()));

        //  System.out.println(pr.readByVATNumber("1234567890"));
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
