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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.util.Locale.ROOT;

public class DataImport {
     
    private static final String OWNERS_CSV = "owners.csv";
    private static final String PROPERTIES_CSV = "properties.csv";
    private static final String REPAIRS_CSV = "repairs.csv";
            
            
    private final PropertyRepairRepository propertyRepairRepository;
    private final PropertyRepository propertyRepository;
     private final OwnerRepository ownerRepository;

    public DataImport(PropertyRepairRepository propertyRepairRepository, PropertyRepository propertyRepository, OwnerRepository ownerRepository) {
        this.propertyRepairRepository = propertyRepairRepository;
        this.propertyRepository = propertyRepository;
        this.ownerRepository = ownerRepository;
    }
    
      private static List<String[]> readFile(String filename) {
        List<String[]> lines = new ArrayList<>();
        String string;
        try(BufferedReader reader =  new BufferedReader(new FileReader(filename));){
            while ((string = reader.readLine()) != null) {
                lines.add(string.split(","));
            }
             reader.close();
        } catch( IOException ex) {
            
            System.out.println( "Problem openning the file " + filename + "!");
            return null;
        }
     
        return lines;
    }
          
    
     
    public void insertPropertyRepairs(){
       List<String[]> repairList = readFile("data/" + REPAIRS_CSV);  
      for (String[] repairString : repairList) {
          try {
              
              PropertyRepair pr = new PropertyRepair();
              pr.setRepairProperty(propertyRepository.read(Integer.parseInt(repairString[0])));
              pr.setRepairType(RepairType.valueOf(repairString[1]));
              pr.setRepairDescription(repairString[2]);
              pr.setRepairSubmissionDate(LocalDate.parse(repairString[3]));
              pr.setRepairWorkToBeDone(repairString[4]);
              pr.setRepairProposedStartDate(LocalDate.parse(repairString[5]));
              pr.setRepairProposedEndDate(LocalDate.parse(repairString[6]));
              pr.setRepairProposedCost(Double.valueOf(repairString[7]));
              pr.setRepairAcceptance(Boolean.valueOf(repairString[8]));
              pr.setRepairStatus(RepairStatus.valueOf(repairString[9]));
              pr.setRepairActualStartDate(LocalDate.parse(repairString[10]));
              pr.setRepairActualEndDate(LocalDate.parse(repairString[11]));
     
              propertyRepairRepository.create(pr);
              
              
          } catch (Exception e) {
                System.out.println(e.getMessage());
            }
      } 
    }
    
    public void insertProperties(){
        List<String[]> propertyList = readFile("data/" + PROPERTIES_CSV);
        for (String[] propertyString : propertyList){
            try {                
                Property p = new Property();
                p.setPropertyAddress(propertyString[0]);
                p.setPropertyConstructionYear(LocalDate.parse(propertyString[1]));
                p.setPropertyType(PropertyType.valueOf(propertyString[2]));
                p.setPropertyOwner(ownerRepository.read(Integer.parseInt(propertyString[3])));
                propertyRepository.create(p);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void insertOwners(){
        List<String[]> ownerList = readFile("data/" + OWNERS_CSV);
        for (String[] ownerString : ownerList){
            try {
                //String[] words =ownerString.split(",");
                Owner o = new Owner();
                o.setOwnerVat(ownerString[0]);
                o.setOwnerName(ownerString[1]);
                o.setOwnerSurname(ownerString[2]);
                o.setOwnerAddress(ownerString[3]);
                o.setOwnerPhoneNumber(ownerString[4]);
                o.setOwnerEmail(ownerString[5]);
                o.setOwnerUsername(ownerString[6]);
                o.setOwnerPwd(ownerString[7]);
                
                ownerRepository.create(o);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
