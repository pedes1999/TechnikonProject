package gr.ed.TechnikonProject.util;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.RepairType;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.OwnerRepository;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import java.time.LocalDate;

public class DataImport {
        
    private final PropertyRepairRepository propertyRepairRepository;
    private final PropertyRepository propertyRepository;
     private final OwnerRepository ownerRepository;

    public DataImport(PropertyRepairRepository propertyRepairRepository, PropertyRepository propertyRepository, OwnerRepository ownerRepository) {
        this.propertyRepairRepository = propertyRepairRepository;
        this.propertyRepository = propertyRepository;
        this.ownerRepository = ownerRepository;
    }

//    private final OwnerService ownerService;
//    private final AdminService adminService;
//
//    public DataImport(OwnerService ownerService, AdminService adminService) {
//        this.ownerService = ownerService;
//        this.adminService = adminService;
//    }
 
    
    
    
        

        private final static String[] REPAIRS = {
        "1,PAINTING,INSULATION OF THE PIPES,2022-10-22,THIS A FREE TEXT FIELD TEST,2022-11-12,2022-11-22,5000,TRUE,PENDING,2022-11-12,2022-11-22",
            "1,INSULATION,INSULATION OF THE PIPES,2022-08-27,THIS A FREE TEXT FIELD TEST,2022-12-12,2022-10-30,1000,TRUE,PENDING,2022-11-12,2022-11-22",
            "3,PLUMBING,PLUMBING OF THE PIPES,2022-10-22,THIS A FREE TEXT FIELD TEST,2022-11-12,2022-11-22,5000,TRUE,PENDING,2022-11-12,2022-11-22",
            "2,PAINTING,INSULATION OF THE PIPES,2022-06-22,THIS A FREE TEXT FIELD TEST,2022-07-12,2022-11-22,5000,TRUE,PENDING,2022-11-12,2022-11-22",
            "4,PAINTING,INSULATION OF THE PIPES,2022-10-22,THIS A FREE TEXT FIELD TEST,2022-11-12,2022-08-22,5000,TRUE,IN_PROGRESS,2022-11-12,2022-08-22",
            "1,ELECTRICAL_WORK,ELECTRICAL WORK OF THE PIPES,2022-10-22,THIS A FREE TEXT FIELD TEST,2022-11-12,2022-11-22,5000,TRUE,PENDING,2022-11-12,2022-11-22"
            
    };
        
        
        private final static String[] PROPERTIES ={
            "Athens,2019-06-22,MAISONETTE,1",
            "Patras,1999-07-21,MAISONETTE,2",
            "Attiki,2005-03-14,MAISONETTE,2",
            "Sounio,2011-02-27,MAISONETTE,3"
        };
        
          private final static String[] OWNERS ={
            "1234567890,Renaldo,Veledi,Patras,6986543152,adsas@gmail.com,renaldo,123456",
            "1234567891,Periklis,desyllas,Patras,698652352,adsasasd@gmail.com,perry,123456",
            "1234567893,sokratis,mantzakos,Athens,6986343152,adsasss@gmail.com,sokratis,123456",
        
        };
    
    
    
    
     
    public void insertPropertyRepairs(){
      for (String repairString : REPAIRS) {
          try {
              String[] words = repairString.split(",");
              PropertyRepair pr = new PropertyRepair();
              pr.setRepairProperty(propertyRepository.read(Integer.parseInt(words[0])));
              pr.setRepairType(RepairType.valueOf(words[1]));
              pr.setRepairDescription(words[2]);
              pr.setRepairSubmissionDate(LocalDate.parse(words[3]));
              pr.setRepairWorkToBeDone(words[4]);
              pr.setRepairProposedStartDate(LocalDate.parse(words[5]));
              pr.setRepairProposedEndDate(LocalDate.parse(words[6]));
              pr.setRepairProposedCost(Double.valueOf(words[7]));
              pr.setRepairAcceptance(Boolean.valueOf(words[8]));
              pr.setRepairStatus(RepairStatus.valueOf(words[9]));
              pr.setRepairActualStartDate(LocalDate.parse(words[10]));
              pr.setRepairActualEndDate(LocalDate.parse(words[11]));
     
              propertyRepairRepository.create(pr);
              
              
          } catch (Exception e) {
                System.out.println(e.getMessage());
            }
      } 
    }
    
    public void insertProperties(){
        for (String propertyString : PROPERTIES){
            try {
                String[] words = propertyString.split(",");
                Property p = new Property();
                p.setPropertyAddress(words[0]);
                p.setPropertyConstructionYear(LocalDate.parse(words[1]));
                p.setPropertyType(PropertyType.valueOf(words[2]));
                p.setPropertyOwner(ownerRepository.read(Integer.parseInt(words[3])));
                propertyRepository.create(p);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void insertOwners(){
        for (String ownerString : OWNERS){
            try {
                String[] words =ownerString.split(",");
                Owner o = new Owner();
                o.setOwnerVat(words[0]);
                o.setOwnerName(words[1]);
                o.setOwnerSurname(words[2]);
                o.setOwnerAddress(words[3]);
                o.setOwnerPhoneNumber(words[4]);
                o.setOwnerEmail(words[5]);
                o.setOwnerUsername(words[6]);
                o.setOwnerPwd(words[7]);
                
                ownerRepository.create(o);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
