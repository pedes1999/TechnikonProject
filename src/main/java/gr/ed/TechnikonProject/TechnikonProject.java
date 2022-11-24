package gr.ed.TechnikonProject;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.enums.RepairAcceptance;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.RepairType;
import gr.ed.TechnikonProject.enums.Role;
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
import gr.ed.TechnikonProject.util.JpaUtil;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import gr.ed.TechnikonProject.service.PropertyRepairService;
import gr.ed.TechnikonProject.service.PropertyService;
import gr.ed.TechnikonProject.service.serviceImpl.OwnerServiceImpl;
import gr.ed.TechnikonProject.service.serviceImpl.PropertyRepairServiceImpl;
import gr.ed.TechnikonProject.service.serviceImpl.PropertyServiceImpl;
import gr.ed.TechnikonProject.util.DataImport;
import java.math.BigDecimal;

public class TechnikonProject {

    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        PropertyRepository propertyRepo = new PropertyRepositoryImpl(entityManager);
        PropertyRepairRepository repairRepo = new PropertyRepairRepositoryImpl(entityManager);
        OwnerRepository ownerRepo = new OwnerRepositoryImpl(entityManager);

        OwnerService ownerService = new OwnerServiceImpl(ownerRepo, propertyRepo, repairRepo);
        PropertyService propertyService = new PropertyServiceImpl(ownerRepo, propertyRepo, repairRepo);
        PropertyRepairService propertyRepairService = new PropertyRepairServiceImpl(ownerRepo, propertyRepo, repairRepo);
        DataImport dI = new DataImport(ownerService, propertyService, propertyRepairService);

        dI.insertOwners();
        dI.insertProperties();
       dI.insertPropertyRepairs();

        //BUSINESS FLOW
        // ADD OWNER 
//        Owner o = new Owner();
//        o.setOwnerVat("1234567894");
//        o.setOwnerName("Giorgos");
//        o.setOwnerSurname("Georgopoulos");
//        o.setOwnerPhoneNumber("6983234568");
//        o.setOwnerAddress("Xania");
//        o.setOwnerEmail("giorgos1@gmail.com");
//        o.setOwnerUsername("georgess");
//        o.setOwnerPwd("43123Asdds");
//        o.setIsAdmin(Role.ADMIN);

        //ownerService.addOwner(o);
//        Property p = new Property();
//        p.setPropertyAddress("Athens");
//        p.setPropertyConstructionYear(LocalDate.of(2010, 10, 19));
//        p.setPropertyType(PropertyType.DETACHED_HOUSE);
//        p.setPropertyOwner(ownerService.searchOwnerPerEmail("giorgos1@gmail.com"));
        // propertyService.addProperty(p);

//        Property p2 = new Property();
//        p2.setPropertyAddress("Giannena");
//        p2.setPropertyConstructionYear(LocalDate.of(2019, 10, 4));
//        p2.setPropertyType(PropertyType.APPARTMENT);
//        p2.setPropertyOwner(ownerService.searchOwnerPerEmail("giorgos1@gmail.com"));
        //propertyService.addProperty(p2);

        //OWNER ADDS A REPAIR TO THE PROPERTY
//        PropertyRepair pr = new PropertyRepair();
//        pr.setRepairSubmissionDate(LocalDate.now());
//        pr.setRepairAcceptance(RepairAcceptance.PENDING);
//        pr.setRepairStatus(RepairStatus.PENDING);
//        pr.setRepairType(RepairType.PLUMBING);
//        pr.setRepairProposedCost(BigDecimal.ZERO);
//        pr.setRepairDescription("Plumbing the whole house");
//        pr.setRepairWorkToBeDone("This is a very large house and it needs to be plumbed");
//        pr.setRepairProperty(propertyService.getAllOwnerProperties("1234567894").get(1));
        //propertyRepairService.addPropertyRepair(pr);

        //  propertyRepairService.updatePropertyRepairProposedStartDate(propertyRepairService.searchRepairByRepairId(7), LocalDate.now());
        //propertyRepairService.updatePropertyRepairProposedEndDate(propertyRepairService.searchRepairByRepairId(7), LocalDate.of(2023,1,2));
        // propertyRepairService.updatePropertyRepairProposedCost(propertyRepairService.searchRepairByRepairId(7), BigDecimal.valueOf(6000));
       // propertyRepairService.updateRepairAcceptance(propertyRepairService.searchRepairByRepairId(7), RepairAcceptance.ACCEPTED);

      //  propertyRepairService.updateRepairBasedOnAcceptance(propertyRepairService.searchRepairByRepairId(7));

    }
}
