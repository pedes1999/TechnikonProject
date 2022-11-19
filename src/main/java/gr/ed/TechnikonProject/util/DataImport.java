package gr.ed.TechnikonProject.util;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.RepairType;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import java.time.LocalDate;
import java.time.Year;

public class DataImport {
        
    private final PropertyRepairRepository propertyRepairRepository;
    private final PropertyRepository propertyRepository;

    public DataImport(PropertyRepairRepository propertyRepairRepository, PropertyRepository propertyRepository) {
        this.propertyRepairRepository = propertyRepairRepository;
        this.propertyRepository = propertyRepository;
    }

    
    
    
        

        private final static String[] REPAIRS = {
        "1,PAINTING,INSULATION OF THE PIPES,2022-10-22,THIS A FREE TEXT FIELD TEST,2022-11-12,2022-11-22,5000,TRUE,PENDING,2022-11-12,2022-11-22",
            "1,INSULATION,INSULATION OF THE PIPES,2022-08-27,THIS A FREE TEXT FIELD TEST,2022-12-12,2022-10-30,1000,TRUE,PENDING,2022-11-12,2022-11-22",
            "3,PLUMBING,PLUMBING OF THE PIPES,2022-10-22,THIS A FREE TEXT FIELD TEST,2022-11-12,2022-11-22,5000,TRUE,PENDING,2022-11-12,2022-11-22",
            "2,PAINTING,INSULATION OF THE PIPES,2022-06-22,THIS A FREE TEXT FIELD TEST,2022-07-12,2022-11-22,5000,TRUE,PENDING,2022-11-12,2022-11-22",
            "1,PAINTING,INSULATION OF THE PIPES,2022-10-22,THIS A FREE TEXT FIELD TEST,2022-11-12,2022-08-22,5000,TRUE,IN_PROGRESS,2022-11-12,2022-08-22",
            "1,ELECTRICAL_WORK,ELECTRICAL WORK OF THE PIPES,2022-10-22,THIS A FREE TEXT FIELD TEST,2022-11-12,2022-11-22,5000,TRUE,PENDING,2022-11-12,2022-11-22"
            
    };
        
        
        private final static String[] PROPERTIES ={
            "Athens,2019-06-22,MAISONETTE",
            "Patras,1999-07-21,MAISONETTE",
            "Attiki,2005-03-14,MAISONETTE",
            "Sounio,2011-02-27,MAISONETTE"
        };
    
    
    
    
     
    public void insertPropertyRepairs(){
      for (String repairString : REPAIRS) {
          try {
              String[] words = repairString.split(",");
              PropertyRepair pr = new PropertyRepair();
              pr.setRepairProperty(propertyRepository.read(Integer.parseInt(words[0])));
              //pr.setRepairProperty(new Property());
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
                
                propertyRepository.create(p);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
