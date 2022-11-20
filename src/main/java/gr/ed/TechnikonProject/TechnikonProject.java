package gr.ed.TechnikonProject;

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
//        Owner o = new Owner();
//        o.setOwnerVat("1234567895");
//        o.setOwnerName("Giorgos");
//        o.setOwnerSurname("Georgopoulos");
//        o.setOwnerPhoneNumber("6983234567");
//        o.setOwnerAddress("Xania");
//        o.setOwnerEmail("periklis@gmail.com");
//        o.setOwnerUsername("perry");
//        o.setOwnerPwd("5431232");
//        adminService.addOwner(o);

        //OWNER ADDS A NEW PROPERTY
        
//       Property p = new Property();
//       p.setPropertyAddress("Cuba");
//       p.setPropertyConstructionYear(LocalDate.of(2010,10,19));
//       p.setPropertyType(PropertyType.DETACHED_HOUSE);
//       p.setPropertyOwner(adminService.searchOwnerPerEmail("periklis@gmail.com"));
//       ownerService.addProperty(p);

        //OWNER ADD A REPAIR TO THE PROPERTY
//       PropertyRepair pr = new PropertyRepair();
//       pr.setRepairSubmissionDate(LocalDate.now());
//       pr.setRepairStatus(RepairStatus.PENDING);
//       pr.setRepairType(RepairType.PAINTING);
//       pr.setRepairDescription("Painting the whole house");
//       pr.setRepairWorkToBeDone("This is a very large house and it needs to be blue");
//       pr.setRepairProperty(ownerService.searchPropertyByPropertyId(1));
//       ownerService.addPropertyRepair(pr);

        //ADMIN PROPOSES DATES AND COST
//        adminService.updatePropertyRepairProposedStartDate(adminService.searchRepairPerId(1), LocalDate.of(2022, 12, 3));
//        adminService.updatePropertyRepairProposedEndDate(adminService.searchRepairPerId(1), LocalDate.of(2023, 3, 6));
//        adminService.updatePropertyRepairProposedCost(adminService.searchRepairPerId(1),5000);
//        
        //CUSTOMER ACCEPTS
//        ownerService.updateRepairAcceptance(ownerService.searchRepairPerId(1), true);
        //ADMIN SETS THE ACTUAL DATES OF THE  REPAIR
//        adminService.updatePropertyRepairActualStartDate(adminService.searchRepairPerId(1),adminService.searchRepairPerId(1).getRepairProposedStartDate());
//        adminService.updatePropertyRepairActualEndDate(adminService.searchRepairPerId(1),adminService.searchRepairPerId(1).getRepairProposedEndDate());
         //SETS STATUS TO IN_PROGRESS




// ========================================================================================================================================



        //TESTS TO SEE IF PRIMARY AND FOREIGNS KEYS WORK AS THEY SHOULD
//       PropertyRepair pr = new PropertyRepair();
//       pr.setRepairSubmissionDate(LocalDate.now());
//       pr.setRepairStatus(RepairStatus.PENDING);
//       pr.setRepairType(RepairType.INSULATION);
//       pr.setRepairDescription("Insulating the whole house");
//       pr.setRepairWorkToBeDone("This is a very large house and it needs to be Insulated");
//       pr.setRepairProperty(ownerService.searchPropertyByPropertyId(4));
//       ownerService.addPropertyRepair(pr);

//    Owner o = new Owner();
//    o.setOwnerVat("1234567895");
//    o.setOwnerName("Giorgos");
//    o.setOwnerSurname("Georgopoulos");
//    o.setOwnerPhoneNumber("6983234567");
//    o.setOwnerAddress("Xania");
//    o.setOwnerEmail("periklis@gmail.com");
//    o.setOwnerUsername("perry");
//    o.setOwnerPwd("5431232");
//    adminService.addOwner(o);

//       Property p = new Property();
//       p.setPropertyAddress("Havana");
//       p.setPropertyConstructionYear(LocalDate.of(199,10,19));
//       p.setPropertyType(PropertyType.APPARTMENT);
//       p.setPropertyOwner(adminService.searchOwnerPerVat("1234567895"));
//       ownerService.addProperty(p);
//       
//        System.out.println(adminService.searchOwnerPerEmail("periklis@gmail.com"));
    }
}
