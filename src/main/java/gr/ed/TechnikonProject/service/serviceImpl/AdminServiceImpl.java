package gr.ed.TechnikonProject.service.serviceImpl;

import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.enums.RepairType;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.OwnerRepository;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import gr.ed.TechnikonProject.service.AdminService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminServiceImpl implements AdminService {

    private final OwnerRepository ownerRepository;
    private final PropertyRepository propertyRepository;
    private final PropertyRepairRepository propertyRepairRepository;

    public AdminServiceImpl(OwnerRepository ownerRepository, PropertyRepository propertyRepository, PropertyRepairRepository propertRepairRepository) {
        this.ownerRepository = ownerRepository;
        this.propertyRepository = propertyRepository;
        this.propertyRepairRepository = propertRepairRepository;
    }
    //ADDS
    
    //Reads for owners
      @Override
    public Owner searchOwnerPerVat(String ownerVatNumber) {
        Optional<Owner> owner = null;
        
        try {
            //owner = ownerRepository.read(ownerVatNumber);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    
    //UPDATES FOR OWNER
       
    //UPDATES FOR PROPERTY
    
    // UPDATES FOR REPAIRS
    @Override
    public boolean updatePropertyRepairType(PropertyRepair propertyRepair, RepairType prType) {
        try {
            //propertyRepairRepository.updateRepairType(propertyRepair.getPropertyRepairId(), prType);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Successfully updated!!");
        return true;
    }

    @Override
    public boolean updatePropertyRepairDesc(PropertyRepair propertyRepair, String prDescription) {
        try {
            //propertyRepairRepository.updateRepairDesc(propertyRepair.getPropertyRepairId(), prDescription);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean updatePropertyRepairWorkToBeDone(PropertyRepair propertyRepair, String prWorkToBeDone) {
        try {
            //propertyRepairRepository.updateRepairWorkToBeDone(propertyRepair.getPropertyRepairId(), prWorkToBeDone);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean updatePropertyRepairStatus(PropertyRepair propertyRepair, RepairStatus prStatus) {
        try {
            //propertyRepairRepository.updateRepairStatus(propertyRepair.getPropertyRepairId(), prStatus);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean updatePropertyRepairProposedStartDate(PropertyRepair propertyRepair, LocalDate prPropStart) {
        try {
            //propertyRepairRepository.updateRepairProposedStartDate(propertyRepair.getPropertyRepairId(), prPropStart);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean updatePropertyRepairProposedEndDate(PropertyRepair propertyRepair, LocalDate prPropEnd) {
        try {
            propertyRepairRepository.updateRepairProposedStartDate(propertyRepair.getPropertyRepairId(), prPropEnd);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean updatePropertyRepairProposedCost(PropertyRepair propertyRepair, double prPropCost) {
        try {
            //propertyRepairRepository.updateRepairProposedCost(propertyRepair.getPropertyRepairId(), prPropCost);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean updatePropertyRepairActualStartDate(PropertyRepair propertyRepair, LocalDate prActualStart) {
        try {
            propertyRepairRepository.updateRepairActualStartDate(propertyRepair.getPropertyRepairId(), prActualStart);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean updatePropertyRepairActualEndDate(PropertyRepair propertyRepair, LocalDate prActualEnd) {
        try {
            propertyRepairRepository.updateRepairActualEndDate(propertyRepair.getPropertyRepairId(), prActualEnd);
        } catch (Exception ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    //DELETES

    @Override
    public boolean deletePropertyRepair(PropertyRepair propertyRepair) {
        try {
        propertyRepairRepository.delete(propertyRepair.getPropertyRepairId());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteProperty(Property property) {
        try {
            //add ID to Property
        //propertyRepository.delete(property.getPropertyId());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteOwner(Owner owner) {
        try {
            //add owner ID
        //ownerRepository.delete(owner.getOwnerId());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Owner searchOwnerPerEmail(String ownerEmail) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addProperty(Property property) {
        try {
            propertyRepository.create(property);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    @Override
    public boolean addPropertyRepair(PropertyRepair propertyRepair) {
        try {
            propertyRepairRepository.create(propertyRepair);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

     @Override
    public Property searchByPropertyId(int propertyId) {
        Property p = new Property();
       try {
           p = propertyRepository.readByPropertyId(propertyId);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return p;
    
    }

    @Override
    public List<Property> searchByVATNumber(Owner propertyVATOwner) {
        List<Property> propertyList = new ArrayList<>();
        try {
            propertyList = propertyRepository.readByVATNumber(propertyVATOwner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyList;

    }

    @Override
    public boolean updateRepairAcceptance(int propertyRepairId, boolean repairAcceptance) {
        try {
            propertyRepairRepository.updateRepairAcceptance(propertyRepairId, repairAcceptance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }
}
  

