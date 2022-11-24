package gr.ed.TechnikonProject.service.serviceImpl;

import gr.ed.TechnikonProject.exceptions.InvalidEmailException;
import gr.ed.TechnikonProject.exceptions.InvalidIdException;
import gr.ed.TechnikonProject.exceptions.InvalidOwnerException;
import gr.ed.TechnikonProject.exceptions.InvalidVatException;
import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.repository.OwnerRepository;
import gr.ed.TechnikonProject.repository.PropertyRepairRepository;
import gr.ed.TechnikonProject.repository.PropertyRepository;
import gr.ed.TechnikonProject.service.OwnerService;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class OwnerServiceImpl implements OwnerService {

    protected final OwnerRepository ownerRepository;
    protected final PropertyRepository propertyRepository;
    protected final PropertyRepairRepository propertyRepairRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository, PropertyRepository propertyRepository, PropertyRepairRepository propertyRepairRepository) {
        this.ownerRepository = ownerRepository;
        this.propertyRepository = propertyRepository;
        this.propertyRepairRepository = propertyRepairRepository;

    }

    @Override
    public boolean addOwner(Owner owner) {
        if (!isOwnerValid(owner)) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidOwnerException(
                            "Error, invalid user value(s)! ("
                            + owner.toString() + ")"));
            return false;
        }
        try {
            ownerRepository.create(owner);
        } catch (Exception e) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);
            return false;
        }

        Logger.getLogger(OwnerServiceImpl.class.getName())
                .log(Level.INFO, "The owner has been added successfully!");
        return true;
    }

    @Override
    public Owner searchOwnerByOwnerId(int ownerId) {
        if (!isIdValid(ownerId)) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidIdException(
                            "Error, invalid Id value! ("
                            + ownerId + ")"));
            return null;
        }
        Owner owner = new Owner();
        try {
            owner = ownerRepository.read(ownerId);
        } catch (Exception e) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        return owner;
    }

    @Override
    public Owner searchOwnerPerVat(String ownerVatNumber) {
        if (!isVatValid(ownerVatNumber)) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidVatException(
                            "Error, invalid Vat value! ("
                            + ownerVatNumber + ")"));
            return null;
        }

        Optional<Owner> owner = null;

        try {
            owner = ownerRepository.readOwnerVat(ownerVatNumber);
        } catch (Exception e) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);
        }

        if (!owner.isPresent()) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, "There are no owners with the given Vat Number");
        }

        return owner.get();
    }

    @Override
    public Owner searchOwnerPerEmail(String ownerEmail) {
        if (!isEmailValid(ownerEmail)) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidEmailException(
                            "Error, invalid Email value! ("
                            + ownerEmail + ")"));
            return null;
        }
        Optional<Owner> owner = null;
        try {
            owner = ownerRepository.readOwnerEmail(ownerEmail);
        } catch (Exception e) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);

        }

        if (!owner.isPresent()) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, "There are no owners with the given Email!");
        }

        return owner.get();
    }

    @Override
    public boolean updateOwnerAddress(Owner owner, String ownerAddress) {
        boolean ownerAddressUpdated = true;
        try {
            ownerAddressUpdated = ownerRepository.updateEmail(owner.getOwnerVat(), ownerAddress);
        } catch (Exception ex) {
            Logger.getLogger(OwnerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!ownerAddressUpdated) {
            Logger.getLogger(OwnerServiceImpl.class.getName()).log(Level.WARNING, "The owner Address was not updated");
        }
        return ownerAddressUpdated;
    }

    @Override
    public boolean updateOwnerEmail(Owner owner, String ownerEmail) {
        boolean ownerEmailUpdated = true;
        try {
            ownerEmailUpdated = ownerRepository.updateEmail(owner.getOwnerVat(), ownerEmail);
        } catch (Exception ex) {
            Logger.getLogger(OwnerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!ownerEmailUpdated) {
            Logger.getLogger(OwnerServiceImpl.class.getName()).log(Level.WARNING, "The owner Email was not updated");
        }
        return ownerEmailUpdated;
    }

    @Override
    public boolean updateOwnerPwd(Owner owner, String ownerPwd) {
        boolean ownerPwdUpdated = true;
        try {
            ownerPwdUpdated = ownerRepository.updatePassword(owner.getOwnerVat(), ownerPwd);
        } catch (Exception ex) {
            Logger.getLogger(OwnerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!ownerPwdUpdated) {
            Logger.getLogger(OwnerServiceImpl.class.getName()).log(Level.WARNING, "The owner Password was not updated");
        }
        return ownerPwdUpdated;
    }

    @Override
    public boolean deleteOwner(Owner owner) {
        boolean ownerDeleted = true;
        try {
            ownerDeleted = ownerRepository.delete(owner.getOwnerId());
        } catch (Exception e) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, "Somthing went Wrong with Owner Deletion!");
        }
        return ownerDeleted;
    }

    private boolean isEmailValid(String email) {
        String regex = "^(.+)@(\\S+)$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    private boolean isIdValid(int id) {
        return id > 0;
    }

    private boolean isPwdValid(String password) {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password).matches();
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(phoneNumber).matches();
    }

    private boolean isVatValid(String vatNumber) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(vatNumber).matches();
    }

    private boolean isOwnerValid(Owner owner) {
        return (isVatValid(owner.getOwnerVat())
                && isEmailValid(owner.getOwnerEmail())
                && isPwdValid(owner.getOwnerPwd())
                && isPhoneNumberValid(owner.getOwnerPhoneNumber()));
    }
}
