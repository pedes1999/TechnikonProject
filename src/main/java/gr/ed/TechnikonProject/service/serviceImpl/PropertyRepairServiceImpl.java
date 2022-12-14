package gr.ed.TechnikonProject.service.serviceImpl;

import gr.ed.TechnikonProject.enums.RepairAcceptance;
import gr.ed.TechnikonProject.enums.RepairStatus;
import gr.ed.TechnikonProject.exceptions.InvalidIdException;
import gr.ed.TechnikonProject.exceptions.InvalidRepairException;
import gr.ed.TechnikonProject.exceptions.InvalidVatException;
import gr.ed.TechnikonProject.model.PropertyRepair;
import gr.ed.TechnikonProject.repository.OwnerRepository;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import gr.ed.TechnikonProject.service.PropertyRepairService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class PropertyRepairServiceImpl implements PropertyRepairService {

    protected final OwnerRepository ownerRepository;
    protected final PropertyRepository propertyRepository;
    protected final PropertyRepairRepository propertyRepairRepository;

    public PropertyRepairServiceImpl(OwnerRepository ownerRepository, PropertyRepository propertyRepository, PropertyRepairRepository propertyRepairRepository) {
        this.ownerRepository = ownerRepository;
        this.propertyRepository = propertyRepository;
        this.propertyRepairRepository = propertyRepairRepository;
    }

    /**
     * It checks if the property repair's data are valid and then it adds it
     *
     * @param propertyRepair
     * @return if the given repair's data are valid or not and if the
     * propertyrepair has been added
     */
    @Override
    public boolean addPropertyRepair(PropertyRepair propertyRepair) {
        if (!isRepairValid(propertyRepair)) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidRepairException(
                            "Error, invalid property value(s)! ("
                            + propertyRepair.toString() + ")"));
            return false;
        }
        try {
            propertyRepairRepository.create(propertyRepair);
        } catch (Exception e) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
            return false;
        }

        Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                .log(Level.INFO, "The Repair has been added successfully!");
        return true;
    }

    /**
     * It checks if the id is valid and if it exists in the database or not
     *
     * @param propertyRepairId
     * @return an error message in case of invalid data or not existing repair
     * in the database (giving the propertyrepair id) , and the repair if the id
     * exists
     */
    @Override
    public PropertyRepair searchRepairByRepairId(int propertyRepairId) {
        if (!isIdValid(propertyRepairId)) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidIdException(
                            "Error, invalid Id value! ("
                            + propertyRepairId + ")"));
            return null;
        }
        Optional<PropertyRepair> p = null;
        try {
            p = propertyRepairRepository.read(propertyRepairId);
            return p.get();
        } catch (Exception e) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        if (!p.isPresent()) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.WARNING, "There are no properties with the given Id");
            return null;
        }
        return null;
    }

    /**
     * It checks if the given VAT number is valid and it returns a list of the
     * repairs
     *
     * @param ownerVat
     * @return the repairs ,if they exist, of the properties by given owner's
     * VAT number
     */
    @Override
    public List<PropertyRepair> getAllOwnerRepairs(String ownerVat) {
        if (!isVatValid(ownerVat)) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidVatException(
                            "Error, invalid Vat value! ("
                            + ownerVat + ")"));
            return null;
        }
        List<PropertyRepair> ownerRepairs = new ArrayList<>();
        try {
            ownerRepairs = propertyRepairRepository.readPerOwnerVAT(ownerVat);
        } catch (Exception e) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        if (ownerRepairs.isEmpty()) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.INFO, "There are no repairs active for this user");
        }
        return ownerRepairs;
    }

    /**
     *
     * @return A list of all the repairs of the system
     */
    @Override
    public List<PropertyRepair> getAllPropertyRepairs() {
        List<PropertyRepair> returnedList = new ArrayList<>();
        try {
            returnedList = propertyRepairRepository.read();
        } catch (Exception e) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);
        }
        if (returnedList.isEmpty()) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.INFO, "There are noRepairs at the Moment");
        }

        return returnedList;
    }

    /**
     *
     * @param date
     * @return a list of repairs by the given date and a message if there are
     * not repairs for the specific date
     */
    @Override
    public List<PropertyRepair> searchRepairsByDate(LocalDate date) {
        List<PropertyRepair> propertyRepairListDate = new ArrayList<>();
        try {
            propertyRepairListDate = propertyRepairRepository.readPerDate(date);
        } catch (Exception e) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.WARNING, e.getMessage(), e);
        }

        if (propertyRepairListDate.isEmpty()) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.INFO, null, "There are no Repairs for the Given Date");
        }
        return propertyRepairListDate;
    }

    /**
     *
     * @param startDate
     * @param endDate
     * @return a list of repairs by the given range of dates and a message if
     * there are not repairs for the specific range of dates
     */
    @Override
    public List<PropertyRepair> searchRepairsByDate(LocalDate startDate, LocalDate endDate) {
        List<PropertyRepair> propertyRepairListRangeDates = new ArrayList<>();
        try {
            propertyRepairListRangeDates = propertyRepairRepository.readPerRangeOfDates(startDate, endDate);
        } catch (Exception e) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.WARNING, e.getMessage(), e);
        }

        if (propertyRepairListRangeDates.isEmpty()) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.INFO, null, "There are no Repairs for the Given Date");
        }
        return propertyRepairListRangeDates;
    }

    /**
     *
     * @param propertyRepair
     * @param prPropStart
     * @return if the proposed started date has been successfully updated in the
     * given propertyrepair's data
     */
    @Override
    public boolean updatePropertyRepairProposedStartDate(PropertyRepair propertyRepair, LocalDate prPropStart) {
        boolean propStartDateUpdated = true;
        try {
            propStartDateUpdated = propertyRepairRepository.updateRepairProposedStartDate(propertyRepair.getPropertyRepairId(), prPropStart);
        } catch (Exception ex) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!propStartDateUpdated) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.WARNING, "Proposed Start Date not Updated!");
        }
        return propStartDateUpdated;
    }

    /**
     *
     * @param propertyRepair
     * @param prPropEnd
     * @return if the proposed end date has been successfully updated in the
     * given propertyrepair's data
     */
    @Override
    public boolean updatePropertyRepairProposedEndDate(PropertyRepair propertyRepair, LocalDate prPropEnd) {
        boolean propEndDateUpdated = true;
        try {
            propEndDateUpdated = propertyRepairRepository.updateRepairProposedEndDate(propertyRepair.getPropertyRepairId(), prPropEnd);
        } catch (Exception ex) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propEndDateUpdated) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.SEVERE, "Proposed End Date Was not updated!");
        }

        return propEndDateUpdated;
    }

    /**
     *
     * @param propertyRepair
     * @param prPropCost
     * @return if the proposed cost has been successfully updated in the given
     * propertyrepair's data
     */
    @Override
    public boolean updatePropertyRepairProposedCost(PropertyRepair propertyRepair, BigDecimal prPropCost) {
        boolean propCostUpdated = true;
        try {
            propCostUpdated = propertyRepairRepository.updateRepairProposedCost(propertyRepair.getPropertyRepairId(), prPropCost);
        } catch (Exception ex) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propCostUpdated) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.SEVERE, "Proposed Cost was not updated!");
        }
        return propCostUpdated;
    }

    /**
     *
     * @param propertyRepair
     * @param prActualStart
     * @return if the actual started date has been successfully updated in the
     * given propertyrepair's data
     */
    @Override
    public boolean updatePropertyRepairActualStartDate(PropertyRepair propertyRepair, LocalDate prActualStart) {
        boolean propActualStartUpdated = true;
        try {
            propActualStartUpdated = propertyRepairRepository.updateRepairActualStartDate(propertyRepair.getPropertyRepairId(), prActualStart);
        } catch (Exception ex) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propActualStartUpdated) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.SEVERE, "Actual Start Date was not Updated!");
        }
        return propActualStartUpdated;
    }

    /**
     *
     * @param propertyRepair
     * @param prActualEnd
     * @return if the actual ended date has been successfully updated in the
     * given propertyrepair's data
     */
    @Override
    public boolean updatePropertyRepairActualEndDate(PropertyRepair propertyRepair, LocalDate prActualEnd) {
        boolean propActualEndUpdated = true;
        try {
            propertyRepairRepository.updateRepairActualEndDate(propertyRepair.getPropertyRepairId(), prActualEnd);
        } catch (Exception ex) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!propActualEndUpdated) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.SEVERE, "Actual End Date was not Updated!");
        }
        return propActualEndUpdated;
    }

    /**
     *
     * @param propertyRepair
     * @param repairStatus
     * @return if the status of the propertyrepair's has been successfully
     * updated
     */
    @Override
    public boolean updatePropertyRepairStatus(PropertyRepair propertyRepair, RepairStatus repairStatus) {
        boolean repairStatusUpdated = true;
        try {
            repairStatusUpdated = propertyRepairRepository.updateRepairStatus(propertyRepair.getPropertyRepairId(), repairStatus);
        } catch (Exception ex) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!repairStatusUpdated) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName()).log(Level.WARNING, "Repair Status was not Updated!");
        }
        return repairStatusUpdated;
    }

    /**
     * It checks if the given propertyrepair is valid or not and then it updates
     * the repairacceptance value
     *
     * @param propertyRepair
     * @param repairAcceptance
     * @return if the update of propertyrepair's acceptance happened or not
     */
    @Override
    public boolean updateRepairAcceptance(PropertyRepair propertyRepair, RepairAcceptance repairAcceptance) {
        if (!isRepairValid(propertyRepair)) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidRepairException(
                            "Error, invalid repair value(s)! ("
                            + propertyRepair.toString() + ")"));
            return false;
        }
        boolean acceptanceUpdated = true;
        try {
            acceptanceUpdated = propertyRepairRepository.updateRepairAcceptance(propertyRepair.getPropertyRepairId(), repairAcceptance);
        } catch (Exception e) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }

        if (!acceptanceUpdated) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.WARNING, "Repair acceptance was not Updated");
        }
        return acceptanceUpdated;

    }

    /**
     * It checks the status of given propertyrepair, if it is accepted it is
     * updating the actual start and end dates and then the repair status to
     * IN_PROGRESS, if it is not accepted(declined) it sets the actual start and
     * end dates to null and the status to DECLINED. In case of pending it just
     * informs about it
     *
     * @param propertyRepair
     * @return according to the status of the given propertyrepair
     */
    @Override
    public boolean updateRepairBasedOnAcceptance(PropertyRepair propertyRepair) {
        if (propertyRepair.getRepairAcceptance().equals(RepairAcceptance.PENDING)) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.INFO, "User has not yet accepted or declined the offer!");
        } else if (propertyRepair.getRepairAcceptance().equals(RepairAcceptance.ACCEPTED)) {
            try {
                updatePropertyRepairActualStartDate(propertyRepair, propertyRepair.getRepairProposedStartDate());
                updatePropertyRepairActualEndDate(propertyRepair, propertyRepair.getRepairProposedEndDate());
                updatePropertyRepairStatus(propertyRepair,RepairStatus.IN_PROGRESS);
            } catch (Exception e) {
                Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                        .log(Level.WARNING, "Somthing went Wrong with Repair Updates!");
                return false;
            }
        } else if (propertyRepair.getRepairAcceptance().equals(RepairAcceptance.DECLINED)) {
            try {
                updatePropertyRepairStatus(propertyRepair, RepairStatus.DECLINED);
                updatePropertyRepairActualStartDate(propertyRepair, null);
                updatePropertyRepairActualEndDate(propertyRepair, null);
            } catch (Exception e) {
                Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                        .log(Level.WARNING, "Somthing went Wrong with Repair Updates!");
                return false;
            }

        }
        return true;
    }

    /**
     *
     * @param propertyRepair
     * @return if the given property repair has been successfully deleted
     */
    @Override
    public boolean deletePropertyRepair(PropertyRepair propertyRepair) {
        boolean propertyRepairDeleted = true;
        try {
            propertyRepairDeleted = propertyRepairRepository.delete(propertyRepair.getPropertyRepairId());
        } catch (Exception e) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);
        }
        if (!propertyRepairDeleted) {
            Logger.getLogger(PropertyRepairServiceImpl.class.getName())
                    .log(Level.WARNING, "Somthing went Wrong with Repair Deletion!");
        }
        return propertyRepairDeleted;
    }

    //Validation patterns
    private boolean isIdValid(int id) {
        return id > 0;
    }

    private boolean isVatValid(String vatNumber) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(vatNumber).matches();
    }

    private boolean isProposedCostValid(BigDecimal proposedCost) {
        return proposedCost.compareTo(BigDecimal.ZERO) >= 0;
    }

    private boolean isRepairValid(PropertyRepair propertyRepair) {
        return (isProposedCostValid(propertyRepair.getRepairProposedCost()));
    }

}
