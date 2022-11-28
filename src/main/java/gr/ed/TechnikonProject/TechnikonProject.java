package gr.ed.TechnikonProject;

import gr.ed.TechnikonProject.enums.PropertyType;
import gr.ed.TechnikonProject.enums.RepairAcceptance;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.RepairType;
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
        //Initializing Entity Manager 
        EntityManager entityManager = JpaUtil.getEntityManager();
        //Initializing Repos
        PropertyRepository propertyRepo = new PropertyRepositoryImpl(entityManager);
        PropertyRepairRepository repairRepo = new PropertyRepairRepositoryImpl(entityManager);
        OwnerRepository ownerRepo = new OwnerRepositoryImpl(entityManager);
        //Initializing Services
        OwnerService ownerService = new OwnerServiceImpl(ownerRepo, propertyRepo, repairRepo);
        PropertyService propertyService = new PropertyServiceImpl(ownerRepo, propertyRepo, repairRepo);
        PropertyRepairService propertyRepairService = new PropertyRepairServiceImpl(ownerRepo, propertyRepo, repairRepo);
        DataImport dI = new DataImport(ownerService, propertyService, propertyRepairService);
        /*
        Populate the database with Users,Properties,Repairs (CASE 1)
         */
//        dI.insertOwners();
//        dI.insertProperties();
//        dI.insertPropertyRepairs();

        //BUSINESS FLOW (CASE 2)
        Owner sampleOwner = new Owner("1234567897",
                "thodoris",
                "theodoropoulos",
                "Tripoli",
                "6983234513",
                "thodoris@gmail.com",
                "theo",
                "43123Asdds",
                Role.OWNER);
        
        Owner sampleAdmin = new Owner("1234567898",
                "Takis", "Papadopoulos",
                "El.venizelou 215",
                "6987654123",
                "takis@gmail.com",
                "takis",
                "takis!23A",
                Role.ADMIN);

//        CreateSampleOwner(sampleOwner,ownerService);
//        CreateSampleAdmin(sampleAdmin,ownerService);
        
        //Register 2 Properties for Sample Owner
        //createTwoPropertiesForSampleOwner(propertyService, ownerService);
        
        //Register Two Repairs for sample Owner
        //createTwoRepairsForSampleOwner(propertyRepairService, propertyService);
        
        
        
//(CASE 4)
/*
Admin Proposes the Starting,ending date and cost.Some validations take place to check if the user performing this action has admin privilages or not
         */
//        updateRepairProposedStart(sampleAdmin, propertyRepairService.searchRepairByRepairId(8), LocalDate.of(2018, 12, 12), propertyRepairService);
//        updateRepairProposedEnd(sampleAdmin, propertyRepairService.searchRepairByRepairId(8), LocalDate.of(2022, 12, 12), propertyRepairService);
//        updateRepairProposedCost(sampleAdmin, propertyRepairService.searchRepairByRepairId(8), BigDecimal.valueOf(2000), propertyRepairService);
        /*
Owner Either accepts or denies the offer
         */
        
//updateRepairAcceptance(propertyRepairService.searchRepairByRepairId(8), RepairAcceptance.DECLINED, propertyRepairService);
//updateRepairAcceptance(propertyRepairService.searchRepairByRepairId(8), RepairAcceptance.ACCEPTED, propertyRepairService);
        /*
Admin sets the actual repair dates based on owner's acceptance again validation takes place
         */
//updateRepairBasedOnUserAcceptance(sampleAdmin, propertyRepairService.searchRepairByRepairId(8), propertyRepairService);


//get all owner's properties (CASE 3)
//        getAllPropertiesForOwner(sampleOwner, "1234567897", propertyService, ownerService); //returns properties for owner with given vat
//        getAllPropertiesForOwner(sampleAdmin, "1234567897", propertyService, ownerService); //returns properties for owner with given vat(by Admin)
//        getAllPropertiesForOwner(sampleOwner, "1234567893", propertyService, ownerService); //user cannot get another user's properties(Unauthorized Exception)

//get all owner's repairs (CASE 5)
//        getAllRepairsForOwner(sampleOwner, "1234567897", propertyRepairService, ownerService); //owner can get only his repairs
//        getAllRepairsForOwner(sampleAdmin, "1234567891", propertyRepairService, ownerService); //admin can get every user's repair
//        getAllRepairsForOwner(sampleOwner, "1234567891", propertyRepairService, ownerService); //owner cannot search for another owner's repairs

//admin get all Repairs in all statuses (CASE 5)
         // getAllPropertyRepairs(sampleOwner, propertyRepairService); //Owner has not access to every repair
         // getAllPropertyRepairs(sampleAdmin, propertyRepairService); //Admin can see all property repairs
//=================================================================================================================================
//CRUD
//Search user by vat number
//        searchUserPerVat(sampleAdmin, "1234567890", ownerService); //User does not exist 
//        searchUserPerVat(sampleAdmin, "1234567892", ownerService); //returns user with given vat
//        searchUserPerVat(sampleAdmin, "12345", ownerService); //Invalid Vat Exception
//        searchUserPerVat(sampleOwner, "1234567890", ownerService); //Unauthorized Exception
//search user by email
//        searchUserPerEmail(sampleAdmin,"giannis@giannis", ownerService); //user does not exist
//        searchUserPerEmail(sampleAdmin,"giannis@gmail.com", ownerService); //returns user with given email
//        searchUserPerEmail(sampleAdmin,"giannis", ownerService);  //Invalid Email Exception
//        searchUserPerEmail(sampleOwner,"giannis@gmail.com", ownerService); //Unauthorized Exception
//search user by id
//        searchUserPerId(sampleAdmin, 122, ownerService); //user does not exist
//        searchUserPerId(sampleAdmin, 4, ownerService); //returns user with id 4
//        searchUserPerId(sampleAdmin, -1, ownerService); //Invalid Id Exception
//        searchUserPerId(sampleOwner, 122, ownerService); //Unauthorized Exception
//search property by id
//        searchPropertyPerId(sampleAdmin, 18, propertyService); //property does not exist
//        searchPropertyPerId(sampleAdmin, 5, propertyService); //returns property with id 5
//        searchPropertyPerId(sampleAdmin, -1, propertyService); // Invalid id Exception
//        searchPropertyPerId(sampleOwner, 5, propertyService); //Unauthorized Exception
//search repairs by id
//        searchRepairsPerId(sampleAdmin, 52, propertyRepairService); //repair does not exist
//        searchRepairsPerId(sampleAdmin, 5, propertyRepairService);  //returns repair with id 5
//        searchRepairsPerId(sampleAdmin, -1, propertyRepairService);  //Invalid id Exception
//        searchRepairsPerId(sampleOwner, 5, propertyRepairService);   //Unauthorized Exception
//search repairs by date
//searchRepairsPerDate(sampleOwner, ownerService.searchOwnerPerVat("1234567897"), LocalDate.of(2022, 12, 11), propertyRepairService);
//search repairs by range of dates
//searchRepairsPerRangeOfDates(sampleAdmin, sampleOwner, LocalDate.of(2022,11,4), LocalDate.of(2022,11,13), propertyRepairService);
//Updates
//update user address
//        updateUserAddress(sampleOwner, sampleOwner, "Papamixali 2", ownerService); //updates owner's address
//        updateUserAddress(sampleAdmin, ownerService.searchOwnerByOwnerId(6), "Papamixali 2", ownerService); // admin updates every owner's address
//        updateUserAddress(sampleOwner, ownerService.searchOwnerByOwnerId(2), "Papamixali 2", ownerService); //owner cannot update another owner's address
//update user email 
//        updateUserEmail(sampleOwner,sampleOwner,"pasdds@gmai.c", ownerService); //owner can change his email
//        updateUserEmail(sampleOwner,ownerService.searchOwnerByOwnerId(6),"asdas@gmail.com", ownerService); //owner cannot change another owner's email
//        updateUserEmail(sampleAdmin,ownerService.searchOwnerByOwnerId(2),"pasdds@sadsa.gr", ownerService); //admin can change everyone's email
//update user pwd
//        updateUserPwd(sampleOwner,sampleOwner, "!asdasd1232aA", ownerService);//owner can change their pwd
//        updateUserPwd(sampleOwner ,ownerService.searchOwnerByOwnerId(6), "!asdsad54534A", ownerService); //owner cannot change another owner's pwd
//        updateUserPwd(sampleAdmin,ownerService.searchOwnerByOwnerId(2), "!asd232232aA", ownerService); // admin can change everyone's pwd
//update property address
//        updatePropertyAddress(sampleOwner,propertyService.searchPropertyByPropertyId(9), "kanari 25", propertyService); //owner can change their properties address
//        updatePropertyAddress(sampleOwner ,propertyService.searchPropertyByPropertyId(1), "kanari 25", propertyService); // owner cannot change another owner's property
//        updatePropertyAddress(sampleAdmin , propertyService.searchPropertyByPropertyId(2), "kanari 25", propertyService); // admin can change everything
//update property construction year
//        updatePropertyConstructionYear(sampleOwner,propertyService.searchPropertyByPropertyId(9), LocalDate.of(1999,2,2), propertyService);//owner can change their property's year
//        updatePropertyConstructionYear(sampleOwner,propertyService.searchPropertyByPropertyId(1), LocalDate.of(1999,2,2), propertyService); // owner cannot change another owner's property year
//        updatePropertyConstructionYear(sampleAdmin,propertyService.searchPropertyByPropertyId(2), LocalDate.of(1999,2,2), propertyService);// admin can change everything
//update property type
//        updatePropertyType(sampleOwner,propertyService.searchPropertyByPropertyId(9), PropertyType.APPARTMENT, propertyService);//owner can change their property's type
//        updatePropertyType(sampleOwner,propertyService.searchPropertyByPropertyId(1), PropertyType.APPARTMENT, propertyService);// owner cannot change another owner's property type
//        updatePropertyType(sampleAdmin,propertyService.searchPropertyByPropertyId(2), PropertyType.DETACHED_HOUSE, propertyService);// admin can change everything
//Deletes
//Owner Delete
//        deleteOwner(sampleAdmin,ownerService.searchOwnerByOwnerId(3), ownerService); //admin can delete every owner
//        deleteOwner(sampleOwnpleAdmin,ownerSer,ownerService.searchOwnerByOwnerId(7), ownerService); //owner can only delete himself
//        deleteOwner(sampleOwner,ownerService.searchOwnerByOwnerId(4), ownerService); //Unauthorized EXception
//Property Delete
//       deleteProperty(sampleAdmin,propertyService.searchPropertyByPropertyId(3) , propertyService); //admin can delete every property
//       deleteProperty(ownerService.searchOwnerByOwnerId(5),propertyService.searchPropertyByPropertyId(5) , propertyService); //owner can only delete their properties
//       deleteProperty(sampleOwner,propertyService.searchPropertyByPropertyId(6) , propertyService); //owner cannot delete another owner's properties
//Repair Delete
//       deletePropertyRepair(sampleAdmin,propertyRepairService.searchRepairByRepairId(1), propertyRepairService); //admin can delete every repair
//       deletePropertyRepair(ownerService.searchOwnerByOwnerId(1),propertyRepairService.searchRepairByRepairId(2), propertyRepairService); //owner can delete only their repairs
//       deletePropertyRepair(ownerService.searchOwnerByOwnerId(1),propertyRepairService.searchRepairByRepairId(4), propertyRepairService);  //owner cannot delete another owner's repairs
    }

    public static boolean CreateSampleAdmin(Owner admin, OwnerService ownerService) {
        return ownerService.addOwner(admin);
    }

    public static boolean CreateSampleOwner(Owner owner, OwnerService ownerService) {
        return ownerService.addOwner(owner);
    }

    public static void createTwoPropertiesForSampleOwner(PropertyService propertyService, OwnerService ownerService) {
        propertyService.addProperty(new Property(
                ownerService.searchOwnerPerVat("1234567897"),
                "Mitilini",
                LocalDate.of(2002, 11, 11),
                PropertyType.DETACHED_HOUSE));

        propertyService.addProperty(new Property(
                ownerService.searchOwnerPerVat("1234567897"),
                "Irakleio",
                LocalDate.of(2022, 5, 19),
                PropertyType.MAISONETTE));
    }

    public static void createTwoRepairsForSampleOwner(PropertyRepairService propertyRepairService, PropertyService propertyService) {
        propertyRepairService.addPropertyRepair(new PropertyRepair(
                propertyService.searchPropertyByPropertyId(9),
                RepairType.INSULATION,
                RepairStatus.PENDING,
                "Insulating the whole house",
                "This is a very large house and it needs to be insulated",
                LocalDate.now(),
                BigDecimal.ZERO));
        propertyRepairService.addPropertyRepair(new PropertyRepair(
                propertyService.searchPropertyByPropertyId(10),
                RepairType.PLUMBING,
                RepairStatus.PENDING,
                "plumbing the whole house",
                "This is a very large house and it needs to be plumbed",
                LocalDate.now(),
                BigDecimal.ZERO));

    }

    public static void searchUserPerVat(Owner user, String vatNumber, OwnerService os) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class
                    .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        } else {
            Owner owner = os.searchOwnerPerVat(vatNumber);
            System.out.println("User with Vat : " + vatNumber + " is " + owner);
            System.out.println("===========================================================");
        }
    }

    public static void searchUserPerEmail(Owner user, String email, OwnerService os) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class
                    .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        } else {
            Owner owner = os.searchOwnerPerEmail(email);
            System.out.println("User with Email : " + email + " is " + owner);
            System.out.println("===========================================================");
        }
    }

    public static void searchUserPerId(Owner user, int id, OwnerService os) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class
                    .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        } else {
            Owner owner = os.searchOwnerByOwnerId(id);
            System.out.println("User with Id : " + id + " is " + owner);
            System.out.println("===========================================================");
        }
    }

    public static void searchPropertyPerId(Owner user, int id, PropertyService ps) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class
                    .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        } else {
            Property property = ps.searchPropertyByPropertyId(id);
            System.out.println("Property with Id : " + id + " is " + property);
            System.out.println("===========================================================");
        }
    }

    //It returns all the properties of a specific owner (the OWNER can search only his/her properties and the ADMIN can search for any owner's properties)
    public static void getAllPropertiesForOwner(Owner user, String vat, PropertyService ps, OwnerService os) {
        if (os.searchOwnerPerVat(vat).equals(user) || user.getUserRole().equals(Role.ADMIN)) {
            List<Property> plist = ps.getAllOwnerProperties(vat);
            System.out.println("Properties for Owner with Vat: " + vat + " are " + plist);
            System.out.println("===========================================================");

        } else {
            Logger.getLogger(TechnikonProject.class
                    .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        }
    }

    //Only the ADMIN can search a repair using its id
    public static void searchRepairsPerId(Owner user, int id, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class
                    .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        } else {
            PropertyRepair propertyRepair = prs.searchRepairByRepairId(id);
            System.out.println("Repair with Id : " + id + " is " + propertyRepair);
            System.out.println("===========================================================");
        }
    }

    //It returns all the repairs of the properties of a specific owner (the OWNER can search only his/her repairs and the ADMIN can search for any repairs)
    public static void getAllRepairsForOwner(Owner user, String vat, PropertyRepairService prs, OwnerService os) {
        if (os.searchOwnerPerVat(vat).equals(user) || user.getUserRole().equals(Role.ADMIN)) {
            List<PropertyRepair> prlist = prs.getAllOwnerRepairs(vat);
            System.out.println("Repairs for Owner with Vat: " + vat + " are " + prlist);
            System.out.println("===========================================================");

        } else {
            Logger.getLogger(TechnikonProject.class
                    .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        }
    }

    //It returns all the repairs of the properties given a specific date (the OWNER can search only his/her repairs and the ADMIN can search for any repairs)
    public static void searchRepairsPerDate(Owner user, Owner owner, LocalDate date, PropertyRepairService prs) {
        if (user.getUserRole().equals(Role.ADMIN) || user.equals(owner)) {
            List<PropertyRepair> prlist = prs.searchRepairsByDate(date);
            System.out.println("Repairs with Date : " + date + " is " + prlist);
            System.out.println("===========================================================");

        } else {
            Logger.getLogger(TechnikonProject.class
                    .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        }
    }

    //It returns all the repairs of the properties given a specific range of dates (the OWNER can search only his/her repairs and the ADMIN can search for any repairs)
    public static void searchRepairsPerRangeOfDates(Owner user, Owner owner, LocalDate dateFrom, LocalDate dateTo, PropertyRepairService prs) {
        if (user.getUserRole().equals(Role.ADMIN) || user.equals(owner)) {
            List<PropertyRepair> prlist = prs.searchRepairsByDate(dateFrom, dateTo);
            System.out.println("Repairs from Date : " + dateFrom + " to date : " + dateTo + " are : " + prlist);
            System.out.println("===========================================================");

        } else {
            Logger.getLogger(TechnikonProject.class
                    .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
        }
    }

    //Updates that both owner and admin can do
    public static boolean updateUserAddress(Owner user, Owner owner, String address, OwnerService os) {
        if (user.getUserRole().equals(Role.ADMIN) || user.equals(owner)) {
            System.out.println("===========================================================");
            return os.updateOwnerAddress(owner, address);
        } else {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        }
    }

    public static boolean updateUserEmail(Owner user, Owner owner, String email, OwnerService os) {
        if (user.getUserRole().equals(Role.ADMIN) || user.equals(owner)) {
            System.out.println("===========================================================");
            return os.updateOwnerEmail(owner, email);
        } else {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        }
    }

    public static boolean updateUserPwd(Owner user, Owner owner, String pwd, OwnerService os) {
        if (user.getUserRole().equals(Role.ADMIN) || user.equals(owner)) {
            System.out.println("===========================================================");
            return os.updateOwnerPwd(owner, pwd);
        } else {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        }
    }

    public static boolean updatePropertyAddress(Owner user, Property property, String address, PropertyService ps) {
        if (user.getUserRole().equals(Role.ADMIN) || property.getPropertyOwner().equals(user)) {
            System.out.println("===========================================================");
            return ps.updatePropertyAddress(property, address);
        } else {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        }
    }

    public static boolean updatePropertyConstructionYear(Owner user, Property property, LocalDate date, PropertyService ps) {
        if (user.getUserRole().equals(Role.ADMIN) || property.getPropertyOwner().equals(user)) {
            System.out.println("===========================================================");
            return ps.updatePropertyConstructionYear(property, date);
        } else {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        }
    }

    public static boolean updatePropertyType(Owner user, Property property, PropertyType type, PropertyService ps) {
        if (user.getUserRole().equals(Role.ADMIN) || property.getPropertyOwner().equals(user)) {
            System.out.println("===========================================================");
            return ps.updatePropertyType(property, type);
        } else {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        }
    }

    //Only the admin can update the repair proposed start date
    public static boolean updateRepairProposedStart(Owner user, PropertyRepair pr, LocalDate date, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            Logger.getLogger(TechnikonProject.class
                    .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            System.out.println("===========================================================");
            prs.updatePropertyRepairProposedStartDate(pr, date);
            return true;
        }
    }

    //Only the admin can update the repair proposed end date
    public static boolean updateRepairProposedEnd(Owner user, PropertyRepair pr, LocalDate date, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            System.out.println("===========================================================");
            prs.updatePropertyRepairProposedEndDate(pr, date);
            return true;
        }
    }

    //Only the admin can update the repair proposed cost
    public static boolean updateRepairProposedCost(Owner user, PropertyRepair pr, BigDecimal cost, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            System.out.println("===========================================================");
            prs.updatePropertyRepairProposedCost(pr, cost);
            return true;
        }
    }

    ////Only the admin can update the repair actual start date
    public static boolean updateRepairActualStart(Owner user, PropertyRepair pr, LocalDate date, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            System.out.println("===========================================================");
            prs.updatePropertyRepairActualStartDate(pr, date);
            return true;
        }
    }

    //Only the admin can update the repair actual end date
    public static boolean updateRepairActualEnd(Owner user, PropertyRepair pr, LocalDate date, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            System.out.println("===========================================================");
            prs.updatePropertyRepairActualEndDate(pr, date);
            return true;
        }
    }

    //Only the admin can update the repair status
    public static boolean updateRepairStatus(Owner user, PropertyRepair pr, RepairStatus status, PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            System.out.println("===========================================================");
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
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        }
        System.out.println("===========================================================");
        prs.updateRepairBasedOnAcceptance(pr);
        return true;
    }

    //The ADMIN can delete any owner while the OWNER can only delete himself/herself
    public static boolean deleteOwner(Owner user, Owner owner, OwnerService os) {
        if (user.getUserRole().equals(Role.ADMIN) || user.equals(owner)) {
            System.out.println("===========================================================");
            os.deleteOwner(owner);
            return true;
        } else {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        }
    }

    //Both ADMIN and OWNER can delete a property(Owner can delete only their properties)
    public static boolean deleteProperty(Owner user, Property pr, PropertyService ps) {
        if (user.getUserRole().equals(Role.ADMIN) || pr.getPropertyOwner().equals(user)) {
            System.out.println("===========================================================");
            return ps.deleteProperty(pr);
        } else {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        }
    }

    //Both ADMIN and OWNER can delete a repair(Owner can delete only their repairs)
    public static boolean deletePropertyRepair(Owner user, PropertyRepair pr, PropertyRepairService prs) {
        if (user.getUserRole().equals(Role.ADMIN) || pr.getRepairProperty().getPropertyOwner().equals(user)) {
            System.out.println("===========================================================");
            return prs.deletePropertyRepair(pr);
        } else {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        }
    }
    
    public static boolean getAllPropertyRepairs(Owner user,PropertyRepairService prs) {
        if (!user.getUserRole().equals(Role.ADMIN)) {
            System.out.println("===========================================================");
            Logger
                    .getLogger(TechnikonProject.class
                            .getName())
                    .log(Level.WARNING, null, new UnauthorizedException(
                            "Sorry, you are not authorized to perform this action!"));
            return false;
        } else {
            System.out.println("===========================================================");
            System.out.println(prs.getAllPropertyRepairs());
            return true;
        }
    }
}
