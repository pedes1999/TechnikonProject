package gr.ed.TechnikonProject.util;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.enums.RepairAcceptance;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.RepairType;
import gr.ed.TechnikonProject.enums.Role;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.service.OwnerService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import gr.ed.TechnikonProject.service.PropertyRepairService;
import gr.ed.TechnikonProject.service.PropertyService;
import java.time.Month;

public class DataImport {

    private static final String OWNERS_CSV = "owners.csv";
    private static final String PROPERTIES_CSV = "properties.csv";
    private static final String REPAIRS_CSV = "repairs.csv";

    private OwnerService ownerService;
    private PropertyService propertyService;
    private PropertyRepairService propertyRepairService;

    public DataImport(OwnerService ownerService, PropertyService propertyService, PropertyRepairService propertyRepairService) {
        this.ownerService = ownerService;
        this.propertyService = propertyService;
        this.propertyRepairService = propertyRepairService;
    }

    private static List<String[]> readFile(String filename) {
        List<String[]> lines = new ArrayList<>();
        String string;
        try ( BufferedReader reader = new BufferedReader(new FileReader(filename));) {
            String headerLine = reader.readLine();
            while ((string = reader.readLine()) != null) {
                lines.add(string.split(","));
            }
            reader.close();
        } catch (IOException ex) {

            System.out.println("Problem openning the file " + filename + "!");
            return null;
        }

        return lines;
    }

    public void insertPropertyRepairs() {
        List<String[]> repairList = readFile("data/" + REPAIRS_CSV);
        for (String[] repairString : repairList) {
            try {

                PropertyRepair pr = new PropertyRepair();
                pr.setRepairProperty(propertyService.searchPropertyByPropertyId(Integer.parseInt(repairString[0])));
                pr.setRepairType(RepairType.valueOf(repairString[1]));
                pr.setRepairDescription(repairString[2].toLowerCase());
                pr.setRepairSubmissionDate(LocalDate.parse(repairString[3]));
                pr.setRepairWorkToBeDone(repairString[4].toLowerCase());
                pr.setRepairProposedStartDate(LocalDate.parse(repairString[6]));
                pr.setRepairProposedEndDate(LocalDate.parse(repairString[5]));
                pr.setRepairProposedCost(new BigDecimal(repairString[7].trim()));
                pr.setRepairAcceptance(RepairAcceptance.valueOf(repairString[8]));
                pr.setRepairStatus(RepairStatus.valueOf(repairString[9]));
                pr.setRepairActualStartDate(LocalDate.parse(repairString[11]));
                pr.setRepairActualEndDate(LocalDate.parse(repairString[10]));

                propertyRepairService.addPropertyRepair(pr);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void insertProperties() {
        List<String[]> propertyList = readFile("data/" + PROPERTIES_CSV);
        for (String[] propertyString : propertyList) {
            try {
                Property p = new Property();
                p.setPropertyAddress(propertyString[0].toLowerCase());
                p.setPropertyConstructionYear(LocalDate.parse(propertyString[1].trim()));
                p.setPropertyType(PropertyType.valueOf(propertyString[2]));
                p.setPropertyOwner(ownerService.searchOwnerByOwnerId(Integer.parseInt(propertyString[3])));
                propertyService.addProperty(p);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void insertOwners() {
        List<String[]> ownerList = readFile("data/" + OWNERS_CSV);
        List<Owner> olist = new ArrayList<>();
        for (String[] ownerString : ownerList) {
            try {
                Owner o = new Owner();
                o.setOwnerVat(ownerString[0].trim());
                o.setOwnerName(ownerString[1].trim().toLowerCase());
                o.setOwnerSurname(ownerString[2].trim().toLowerCase());
                o.setOwnerAddress(ownerString[3].toLowerCase());
                o.setOwnerPhoneNumber(ownerString[4].trim());
                o.setOwnerEmail(ownerString[5].trim().toLowerCase());
                o.setOwnerUsername(ownerString[6].trim().toLowerCase());
                o.setOwnerPwd(ownerString[7]);
                o.setUserRole(Role.valueOf(ownerString[8]));

                ownerService.addOwner(o);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
