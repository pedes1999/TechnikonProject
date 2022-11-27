package gr.ed.TechnikonProject;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.enums.RepairAcceptance;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.Role;
import gr.ed.TechnikonProject.exceptions.UnauthorizedException;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
//        dI.insertPropertyRepairs();
        //BUSINESS FLOW
        // ADD OWNER 
        Owner user1 = new Owner("1234567897",
                "thodoris",
                "theodoropoulos",
                "Tripoli",
                "6983234513",
                "thodoris@gmail.com",
                "theo",
                "43123Asdds",
                Role.OWNER);
        //ownerService.addOwner(user1);

        Owner user2 = new Owner("1234567898",
                "Takis", "Papadopoulos",
                "El.venixelou 215",
                "6987654123",
                "takis@gmail.com",
                "takis",
                "takis!23A",
                Role.ADMIN);
        //ownerService.addOwner(user2);

//        propertyService.addProperty(new Property(
//                ownerService.searchOwnerPerVat( "1234567897") , 
//                "Mitilini",
//                LocalDate.of(2002,11,11),
//                PropertyType.DETACHED_HOUSE));
//        
//        propertyService.addProperty(new Property(
//                ownerService.searchOwnerPerVat( "1234567897"),
//                "Irakleio",
//                LocalDate.of(2022, 5, 19),
//                PropertyType.MAISONETTE));
        //OWNER ADDS A REPAIR TO THE PROPERTY
//        propertyRepairService.addPropertyRepair(new PropertyRepair(
//                propertyService.searchPropertyByPropertyId(5),
//                RepairType.INSULATION,
//                RepairStatus.PENDING,
//               "Insulating the whole house",
//               "This is a very large house and it needs to be insulated",
//                LocalDate.now(),
//                BigDecimal.ZERO));

        /*
        Admin Proposes the Starting,ending date and cost.Some validations take place to check if the user performing this action has admin privilages or not
         */
//        updateRepairProposedStart(user2, propertyRepairService.searchRepairByRepairId(8), LocalDate.of(2018, 12, 12), propertyRepairService);
//        updateRepairProposedEnd(user2, propertyRepairService.searchRepairByRepairId(8), LocalDate.of(2022, 12, 12), propertyRepairService);
//        updateRepairProposedCost(user2, propertyRepairService.searchRepairByRepairId(8), BigDecimal.valueOf(2000), propertyRepairService);
        /*
        Owner Either accepts or denies the offer
         */
        //updateRepairAcceptance(propertyRepairService.searchRepairByRepairId(8), RepairAcceptance.PENDING, propertyRepairService);
        /*
        Admin sets the actual repair dates based on owner's acceptance again validation takes place
         */
        //updateRepairBasedOnUserAcceptance(user2, propertyRepairService.searchRepairByRepairId(8), propertyRepairService);
        //CRUD
        //Searches
        //searchUserPerVat(user2, "1234567892", ownerService);              
        //searchUserPerEmail(user2,"giannis@giannis", ownerService);      
        //searchUserPerId(user2, 122, ownerService);
        //searchPropertyPerId(user2, 5, propertyService);
        //getAllPropertiesForOwner(user1, "1234567897", propertyService, ownerService);
        //searchRepairsPerId(user2, 5, propertyRepairService);
        //getAllRepairsForOwner(user2, "1234567897", propertyRepairService, ownerService);
        //searchRepairsPerDate(user2, ownerService.searchOwnerPerVat("1234567897"), LocalDate.of(2022, 11, 06), propertyRepairService);
        //searchRepairsPerRangeOfDates(user2, user1, LocalDate.of(2022,11,4), LocalDate.of(2022,11,13), propertyRepairService);
        //Updates
        //updateUserAddress(ownerService.searchOwnerByOwnerId(6), "Papamixali 2", ownerService);
        //updateUserEmail(user1,"pasd@dd.com", ownerService);
        //updateUserPwd(user1, "!asdasd1232aA", ownerService);
        //updatePropertyAddress(propertyService.searchPropertyByPropertyId(1), "kanari 25", propertyService);
        //updatePropertyConstructionYear(propertyService.searchPropertyByPropertyId(7), LocalDate.of(1999,2,2), propertyService);
        //updatePropertyType(propertyService.searchPropertyByPropertyId(7), PropertyType.APPARTMENT, propertyService);
        //Deletes
        //deleteOwner(user2,ownerService.searchOwnerByOwnerId(3), ownerService);
        //deleteProperty(propertyService.searchPropertyByPropertyId(10) , propertyService);
        //deletePropertyRepair(propertyRepairService.searchRepairByRepairId(1), propertyRepairService);
    }

    //Searches(only the ADMIN can do these actions)
    public static void searchUserPerVat(Owner user, String vatNumber, OwnerService os) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        } else {
            Owner owner = os.searchOwnerPerVat(vatNumber);
            System.out.println("User with Vat : " + vatNumber + " is " + owner);
        }
    }

    public static void searchUserPerEmail(Owner user, String email, OwnerService os) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        } else {
            Owner owner = os.searchOwnerPerEmail(email);
            System.out.println("User with Email : " + email + " is " + owner);
        }
    }

    public static void searchUserPerId(Owner user, int id, OwnerService os) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        } else {
            Owner owner = os.searchOwnerByOwnerId(id);
            System.out.println("User with Id : " + id + " is " + owner);
        }
    }

    public static void searchPropertyPerId(Owner user, int id, PropertyService ps) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        } else {
            Property property = ps.searchPropertyByPropertyId(id);
            System.out.println("Property with Id : " + id + " is " + property);
        }
    }

    //It returns all the properties of a specific owner (the OWNER can search only his/her properties and the ADMIN can search for any owner's properties)
    public static void getAllPropertiesForOwner(Owner user, String vat, PropertyService ps, OwnerService os) {
        if (os.searchOwnerPerVat(vat).equals(user) || user.getUserRole().equals(Role.ADMIN)) {
            List<Property> plist = ps.getAllOwnerProperties(vat);
            System.out.println("Properties for Owner with Vat: " + vat + " are " + plist);
        } else {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        }
    }

    //Only the ADMIN can search a repair using its id
    public static void searchRepairsPerId(Owner user, int id, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        } else {
            PropertyRepair propertyRepair = prs.searchRepairByRepairId(id);
            System.out.println("Repair with Id : " + id + " is " + propertyRepair);
        }
    }

    //It returns all the repairs of the properties of a specific owner (the OWNER can search only his/her repairs and the ADMIN can search for any repairs)
    public static void getAllRepairsForOwner(Owner user, String vat, PropertyRepairService prs, OwnerService os) {
        if (os.searchOwnerPerVat(vat).equals(user) || user.getUserRole().equals(Role.ADMIN)) {
            List<PropertyRepair> prlist = prs.getAllOwnerRepairs(vat);
            System.out.println("Repairs for Owner with Vat: " + vat + " are " + prlist);
        } else {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        }
    }

    //It returns all the repairs of the properties given a specific date (the OWNER can search only his/her repairs and the ADMIN can search for any repairs)
    public static void searchRepairsPerDate(Owner user, Owner owner, LocalDate date, PropertyRepairService prs) {
        if (user.getUserRole().equals(Role.ADMIN) || user.equals(owner)) {
            List<PropertyRepair> prlist = prs.searchRepairsByDate(date);
            System.out.println("Repairs with Date : " + date + " is " + prlist);
        } else {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        }
    }

    //It returns all the repairs of the properties given a specific range of dates (the OWNER can search only his/her repairs and the ADMIN can search for any repairs)
    public static void searchRepairsPerRangeOfDates(Owner user, Owner owner, LocalDate dateFrom, LocalDate dateTo, PropertyRepairService prs) {
        if (user.getUserRole().equals(Role.ADMIN) || user.equals(owner)) {
            List<PropertyRepair> prlist = prs.searchRepairsByDate(dateFrom, dateTo);
            System.out.println("Repairs from Date : " + dateFrom + " to date : " + dateTo + " are : " + prlist);
        } else {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        }
    }

    //Updates that both owner and admin can do
    public static boolean updateUserAddress(Owner owner, String address, OwnerService os) {
        return os.updateOwnerAddress(owner, address);
    }

    public static boolean updateUserEmail(Owner owner, String email, OwnerService os) {
        return os.updateOwnerEmail(owner, email);
    }

    public static boolean updateUserPwd(Owner owner, String pwd, OwnerService os) {
        return os.updateOwnerPwd(owner, pwd);
    }

    public static boolean updatePropertyAddress(Property property, String address, PropertyService ps) {
        if (property != null) {
            return ps.updatePropertyAddress(property, address);
        }
        return false;
    }

    public static boolean updatePropertyConstructionYear(Property property, LocalDate date, PropertyService ps) {
        if (property != null) {
            return ps.updatePropertyConstructionYear(property, date);
        }
        return false;
    }

    public static boolean updatePropertyType(Property property, PropertyType type, PropertyService ps) {
        if (property != null) {
            return ps.updatePropertyType(property, type);
        }
        return false;
    }

    //Only the admin can update the repair proposed start date
    public static boolean updateRepairProposedStart(Owner user, PropertyRepair pr, LocalDate date, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            prs.updatePropertyRepairProposedStartDate(pr, date);
            return true;
        }
    }

    //Only the admin can update the repair proposed end date
    public static boolean updateRepairProposedEnd(Owner user, PropertyRepair pr, LocalDate date, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            prs.updatePropertyRepairProposedEndDate(pr, date);
            return true;
        }
    }

    //Only the admin can update the repair proposed cost
    public static boolean updateRepairProposedCost(Owner user, PropertyRepair pr, BigDecimal cost, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            prs.updatePropertyRepairProposedCost(pr, cost);
            return true;
        }
    }

    ////Only the admin can update the repair actual start date
    public static boolean updateRepairActualStart(Owner user, PropertyRepair pr, LocalDate date, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            prs.updatePropertyRepairActualStartDate(pr, date);
            return true;
        }
    }

    //Only the admin can update the repair actual end date
    public static boolean updateRepairActualEnd(Owner user, PropertyRepair pr, LocalDate date, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            prs.updatePropertyRepairActualEndDate(pr, date);
            return true;
        }
    }

    //Only the admin can update the repair status
    public static boolean updateRepairStatus(Owner user, PropertyRepair pr, RepairStatus status, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            prs.updatePropertyRepairStatus(pr, status);
            return true;
        }
    }

    public static boolean updateRepairAcceptance(PropertyRepair pr, RepairAcceptance repairAccept, PropertyRepairService prs) {
        return prs.updateRepairAcceptance(pr, repairAccept);
    }

    //Only the admin can do this action updating the repair status according to propertyrepair's status
    public static boolean updateRepairBasedOnUserAcceptance(Owner user, PropertyRepair pr, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        }
        prs.updateRepairBasedOnAcceptance(pr);
        return true;
    }

    //The ADMIN can delete any owner while the OWNER can only delete himself/herself
    public static boolean deleteOwner(Owner user, Owner owner, OwnerService os) {
        if (user.getUserRole().equals(Role.ADMIN) || user.equals(owner)) {
            os.deleteOwner(owner);
            return true;
        } else {
            Logger.getLogger(TechnikonProject.class.getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        }
    }

    //Both ADMIN and OWNER can delete a property
    public static boolean deleteProperty(Property pr, PropertyService ps) {
        return ps.deleteProperty(pr);
    }

    //Both ADMIN and OWNER can delete a property
    public static boolean deletePropertyRepair(PropertyRepair pr, PropertyRepairService prs) {
        return prs.deletePropertyRepair(pr);
    }
}
