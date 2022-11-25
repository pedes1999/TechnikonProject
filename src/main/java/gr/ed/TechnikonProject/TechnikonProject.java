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
import java.time.Month;
import java.util.List;

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
       
         /*
       Populate the database with Users,Properties,Repairs
        */
//        dI.insertOwners();
//        dI.insertProperties();
//       dI.insertPropertyRepairs();

        //BUSINESS FLOW
        
        
        // ADD OWNER 
        Owner o = new Owner();
        o.setOwnerVat("1234567897");
        o.setOwnerName("thodoris");
        o.setOwnerSurname("theodoropoulos");
        o.setOwnerPhoneNumber("6983234518");
        o.setOwnerAddress("Tripoli");
        o.setOwnerEmail("thodoris@gmail.com");
        o.setOwnerUsername("theo");
        o.setOwnerPwd("43123Asdds");
        o.setIsAdmin(Role.OWNER);
        //ownerService.addOwner(o);

//        Property p = new Property();
//        p.setPropertyAddress("Athens");
//        p.setPropertyConstructionYear(LocalDate.of(2010, 10, 19));
//        p.setPropertyType(PropertyType.DETACHED_HOUSE);
//        p.setPropertyOwner(ownerService.searchOwnerPerEmail("thodoris@gmail.com"));
         //propertyService.addProperty(p);

//        Property p2 = new Property();
//        p2.setPropertyAddress("Giannena");
//        p2.setPropertyConstructionYear(LocalDate.of(2019, 10, 4));
//        p2.setPropertyType(PropertyType.APPARTMENT);
//        p2.setPropertyOwner(ownerService.searchOwnerPerEmail("thodoris@gmail.com"));
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
//        pr.setRepairProperty(propertyService.getAllOwnerProperties("1234567897").get(1));
        //propertyRepairService.addPropertyRepair(pr);
        
        /*
        Admin Proposes the Starting,ending date and cost.
        */
//          propertyRepairService.updatePropertyRepairProposedStartDate(propertyRepairService.searchRepairByRepairId(8), LocalDate.now());
//        propertyRepairService.updatePropertyRepairProposedEndDate(propertyRepairService.searchRepairByRepairId(8), LocalDate.of(2023,1,2));
//         propertyRepairService.updatePropertyRepairProposedCost(propertyRepairService.searchRepairByRepairId(8), BigDecimal.valueOf(6000));
         
         /*
        Owner Either accepts or denies the offer
        */ 
      // propertyRepairService.updateRepairAcceptance(propertyRepairService.searchRepairByRepairId(8), RepairAcceptance.ACCEPTED);
       
       //propertyRepairService.updateRepairAcceptance(propertyRepairService.searchRepairByRepairId(8), RepairAcceptance.DECLINED);
       
        /*
        Admin sets the actual repair dates based on owner's acceptance
        */ 
        //propertyRepairService.updateRepairBasedOnAcceptance(propertyRepairService.searchRepairByRepairId(8));
        
        System.out.println("======================================================================================================");
        
        //Searches
        
        /*
        Search an owner based on VAT
        */ 
        //String vatNumber = "1234567892";
        //String vatNumber = ""; //Exception Invalid VatNumber
        //String vatNumber = "1234567890"; //Exception Invalid VatNumber
        //Owner owner = ownerService.searchOwnerPerVat(vatNumber);
        //System.out.println("Owner with Vat : "+ vatNumber + " is " + owner);
        
        /*
        Search an owner based on Email
        */ 
        //String email = "periklis@gmail.com";
        //String email = "periklis"; //Invalid Email
        //String email = ""; //Invalid Email
        //String email = "asdasd@gmail.com";
        //Owner owner = ownerService.searchOwnerPerEmail(email);
       //System.out.println("Owner with Email : "+ email + " is " + owner);
       
       /*
        Search an owner based on Id
        */ 
       //Integer id = 1;
       //Integer id = 0; //Invalid id
//       Integer id =15;
//       Owner owner = ownerService.searchOwnerByOwnerId(id);
//       System.out.println("Owner with id : "+ id + " is " + owner);
    
     /*
        Search an property based on Id
        */ 
        //Integer id = 1;
//        Integer id = 5;
//        Property property = propertyService.searchPropertyByPropertyId(id);
//        System.out.println("Property with id : "+ id + " is " + property);

        /*
        Search all properties for a specific owner
        */ 
        
//        String vat = "1234567896";
//        List<Property> plist = propertyService.getAllOwnerProperties(vat);
//        System.out.println("Owner with vat " +vat + "has these properties : " + plist);

         /*
        Search repair based on id
        */
         
         //Integer id = -1; //Invalid Id value
         //Integer id = 1; 
         //Integer id = 10; //No repairs with this id
//         PropertyRepair pr = propertyRepairService.searchRepairByRepairId(id);
//         System.out.println("Repair with id : " +id + " is " +pr);

        /*
        Get all repairs of a certain owner
        */
        
        //String vat = "1234567891";
        //String vat = "1234567896";
        //List<PropertyRepair> pr = propertyRepairService.getAllOwnerRepairs(vat);
       //System.out.println("Owner with Vat : " +vat + " has these repairs : " +pr);
       
       /*
        Get all repairs based on a date
        */
       
       
       //LocalDate date = LocalDate.of(2022, 11, 6);  //should return 1,2,4,5
//       LocalDate date = LocalDate.of(2023, 2, 15);
//       List<PropertyRepair> pr = propertyRepairService.searchRepairsByDate(date);
//        System.out.println("Repairs based on date : " +date +  " are " + pr);


        /*
        Get all repairs based on a range of dates
        */
//        LocalDate datefrom = LocalDate.of(2022, 4, 2); 
//        LocalDate dateto = LocalDate.now();
//         List<PropertyRepair> pr = propertyRepairService.searchRepairsByDate(datefrom,dateto);
//        System.out.println("Repairs based on date From  : " +datefrom  + " date to : " + dateto + "are  : "  + pr);
    }
}
