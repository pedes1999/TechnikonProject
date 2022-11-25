package gr.ed.TechnikonProject;


import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.RepairType;
import gr.ed.TechnikonProject.model.User;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.OwnerRepository;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import gr.ed.TechnikonProject.repository.repositoryImpl.OwnerRepositoryImpl;
import gr.ed.TechnikonProject.repository.repositoryImpl.PropertyRepairRepositoryImpl;
import gr.ed.TechnikonProject.repository.repositoryImpl.PropertyRepositoryImpl;
import gr.ed.TechnikonProject.service.AdminService;
import gr.ed.TechnikonProject.service.OwnerService;
import gr.ed.TechnikonProject.service.serviceImpl.AdminServiceImpl;
import gr.ed.TechnikonProject.service.serviceImpl.OwnerServiceImpl;
import gr.ed.TechnikonProject.util.JpaUtil;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;

public class TechnikonProject {

    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        OwnerRepository ownerRepo = new OwnerRepositoryImpl(entityManager);
        PropertyRepository propertyRepo = new PropertyRepositoryImpl(entityManager);
        PropertyRepairRepository propertyRepairRepo = new PropertyRepairRepositoryImpl(entityManager);
        OwnerService ownerService = new OwnerServiceImpl(ownerRepo, propertyRepo, propertyRepairRepo);
        AdminService adminService = new AdminServiceImpl(ownerRepo, propertyRepo, propertyRepairRepo);

        
        //BUSINESS FLOW
        
        
        // ADD OWNER 
//
//        User o = new User();
//        o.setOwnerVat("1234567898");
//        o.setOwnerName("Giorgos");
//        o.setOwnerSurname("Georgopoulos");
//        o.setOwnerPhoneNumber("6983234567");
//        o.setOwnerAddress("Xania");
//        o.setOwnerEmail("giorgos@gmail.com");
//        o.setOwnerUsername("george");
//        o.setOwnerPwd("5431232");
//        adminService.addOwner(o);

        //OWNER TWO NEW PROPERTIES
//        
//       Property p = new Property();
//       p.setPropertyAddress("Cuba");
//       p.setPropertyConstructionYear(LocalDate.of(2010,10,19));
//       p.setPropertyType(PropertyType.DETACHED_HOUSE);
//       p.setPropertyOwner(adminService.searchOwnerPerEmail("giorgos@gmail.com"));
//       ownerService.addProperty(p);
//       
//       
//       
//       Property p2 = new Property();
//       p2.setPropertyAddress("Giannena");
//       p2.setPropertyConstructionYear(LocalDate.of(2019,10,4));
//       p2.setPropertyType(PropertyType.APPARTMENT);
//       p2.setPropertyOwner(adminService.searchOwnerPerEmail("giorgos@gmail.com"));
//       ownerService.addProperty(p2);


      //ownerService.updatePropertyAddress(adminService.getAllOwnerProperties("1234567898").get(1), "Larissa");
      //ownerService.updatePropertyConstructionYear(ownerService.getAllOwnerProperties("1234567898").get(1), LocalDate.now());
//      ownerService.updatePropertyType(ownerService.getAllOwnerProperties("1234567898").get(1), PropertyType.MAISONETTE);
       // adminService.deleteOwner(adminService.searchOwnerByOwnerId(3));
       // adminService.deleteProperty(adminService.searchPropertyByPropertyId(5));
      
        //OWNER ADD A REPAIR TO THE PROPERTY
//       PropertyRepair pr = new PropertyRepair();
//       pr.setRepairSubmissionDate(LocalDate.now());
//       pr.setRepairStatus(RepairStatus.PENDING);
//       pr.setRepairType(RepairType.PLUMBING);
//       pr.setRepairDescription("Plumbing the whole house");
//       pr.setRepairWorkToBeDone("This is a very large house and it needs to be plumbed");
//       pr.setRepairProperty(ownerService.getAllOwnerProperties("1234567898").get(1));
//       ownerService.addPropertyRepair(pr);

        //ADMIN PROPOSES DATES AND COST
        adminService.updatePropertyRepairProposedStartDate(adminService.searchRepairByRepairId(8), LocalDate.of(2022, 12, 3));
        adminService.updatePropertyRepairProposedEndDate(adminService.searchRepairByRepairId(8), LocalDate.of(2023, 3, 6));
        adminService.updatePropertyRepairProposedCost(adminService.searchRepairByRepairId(8),100);
//        
        //CUSTOMER ACCEPTS
     ownerService.updateRepairAcceptance(adminService.searchRepairByRepairId(8), false);
        //ADMIN SETS THE ACTUAL DATES OF THE  REPAIR
       adminService.updateRepairBasedOnAcceptance(adminService.searchRepairByRepairId(8));
    

         //Owner Reports
        //System.out.println(ownerService.getAllOwnerRepairs("1234567893"));
       //ownerService.getAllOwnerProperties("1234567891");
       
       //Owner Search Per Dates
        //System.out.println(ownerService.searchRepairsByDate(LocalDate.of(2022,11,13)));
        //System.out.println(ownerService.updatePropertyAddress(propertyRepo.read(2), "XAVAI"));
      //System.out.println(ownerService.updatePropertyConstructionYear(propertyRepo.read(2), LocalDate.of(2022,12,15)));
        //System.out.println(ownerService.updatePropertyType(propertyRepo.read(2), PropertyType.DETACHED_HOUSE));
       //ADMIN SEARCHES BY ID 
        //System.out.println(adminService.searchOwnerByOwnerId(1));
        //System.out.println(adminService.searchPropertyByPropertyId(1));
       // System.out.println(adminService.searchRepairByRepairId(1));
//=========================================================
        //Admin report of all the Properties
        //System.out.println(adminService.getAllPropertyRepairs());
        
        
       
        
    }
}
