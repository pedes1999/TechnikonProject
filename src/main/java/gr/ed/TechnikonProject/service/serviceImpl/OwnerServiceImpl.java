package gr.ed.TechnikonProject.service.serviceImpl;

import gr.ed.TechnikonProject.model.Property;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.OwnerRepository;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import gr.ed.TechnikonProject.service.OwnerService;
import java.util.ArrayList;
import java.util.List;


public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PropertyRepository propertyRepository;
    private final PropertyRepairRepository propertyRepairRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository, PropertyRepository propertyRepository, PropertyRepairRepository propertyRepairRepository) {
        this.ownerRepository = ownerRepository;
        this.propertyRepository = propertyRepository;
        this.propertyRepairRepository = propertyRepairRepository;
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
    public List<Property> searchByPropertyE9(int propertyE9) {
        List<Property> propertyList = new ArrayList<>();
        try {
            propertyList = propertyRepository.readByPropertyE9(propertyE9);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyList;

    }

    @Override
    public List<Property> searchByVATNumber(String propertyVATOwner) {
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
