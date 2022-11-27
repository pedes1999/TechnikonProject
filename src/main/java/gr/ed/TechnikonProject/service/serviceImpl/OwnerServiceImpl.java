package gr.ed.TechnikonProject.service.serviceImpl;

import gr.ed.TechnikonProject.enums.Role;
import gr.ed.TechnikonProject.exceptions.InvalidAddressException;
import gr.ed.TechnikonProject.exceptions.InvalidEmailException;
import gr.ed.TechnikonProject.exceptions.InvalidIdException;
import gr.ed.TechnikonProject.exceptions.InvalidOwnerException;
import gr.ed.TechnikonProject.exceptions.InvalidVatException;
import gr.ed.TechnikonProject.exceptions.UnauthorizedException;
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

    /**
     * It checks if the owner's data are valid and then add the owner in the
     * database
     *
     * @param owner
     * @return if the owner has been added
     */
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

    /**
     * It checks if the id is valid and if it exists in the system or not
     *
     * @param ownerId
     * @return an error message in case of invalid data or not existing owner in
     * the database (giving the owner id) , and the owner if the id exists
     */
    @Override
    public Owner searchOwnerByOwnerId(int ownerId) {
        if (!isIdValid(ownerId)) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidIdException(
                            "Error, invalid Id value! ("
                            + ownerId + ")"));
            return null;
        }
        Optional<Owner> owner = null;
        try {
            owner = ownerRepository.read(ownerId);
            return owner.get();
        } catch (Exception e) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        if (!owner.isPresent()) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, "There are no owners with the given Id");
            return null;
        }
        return null;
    }

    /**
     * It checks if the VAT number is valid and if it exists in the database or
     * not
     *
     * @param ownerVatNumber
     * @return an error message in case of invalid data or not existing owner
     * (giving the VAT number) in the database , and the owner if the VAT number
     * exists
     */
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
            return owner.get();
        } catch (Exception e) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);
        }

        if (!owner.isPresent()) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, "There are no owners with the given Vat Number");
            return null;
        }

        return null;
    }

    /**
     * It checks if the email is valid and if it exists in the database or not
     *
     * @param ownerEmail
     * @return an error message in case of invalid data or not existing owner
     * (giving the owner's email) in the database , and the owner if the email
     * exists
     */
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
            return owner.get();
        } catch (Exception e) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, e);

        }

        if (!owner.isPresent()) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, "There are no owners with the given Email!");
        }

        return null;
    }

    /**
     * It checks if the given address is valid and then it updates the given
     * owner's address
     *
     * @param owner
     * @param ownerAddress
     * @return if the given address is valid or not and if the address of the
     * given owner has been updated
     */
    @Override
    public boolean updateOwnerAddress(Owner owner, String ownerAddress) {
        if (!isAddressValid(ownerAddress)) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidAddressException(
                            "Error, invalid Address value! ("
                            + ownerAddress + ")"));
            return false;
        }
        boolean ownerAddressUpdated = true;
        try {
            ownerAddressUpdated = ownerRepository.updateAddress(owner.getOwnerVat(), ownerAddress);
        } catch (Exception ex) {
            Logger.getLogger(OwnerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!ownerAddressUpdated) {
            Logger.getLogger(OwnerServiceImpl.class.getName()).log(Level.WARNING, "The owner Address was not updated");
        }
        return ownerAddressUpdated;
    }

    /**
     * It checks if the given email is valid and then it updates the given
     * owner's email
     *
     * @param owner
     * @param ownerEmail
     * @return if the given email is valid or not and if the email of the given
     * owner has been updated
     */
    @Override
    public boolean updateOwnerEmail(Owner owner, String ownerEmail) {
        if (!isEmailValid(ownerEmail)) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidEmailException(
                            "Error, invalid Email value! ("
                            + ownerEmail + ")"));
            return false;
        }
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

    /**
     * It checks if the given password is valid and then it updates the given
     * owner's password
     *
     * @param owner
     * @param ownerPwd
     * @return if the given password is valid or not and if the password of the
     * given owner has been updated
     */
    @Override
    public boolean updateOwnerPwd(Owner owner, String ownerPwd) {
        if (!isPwdValid(ownerPwd)) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, null, new InvalidEmailException(
                            "Error, invalid Password value! ("
                            + ownerPwd + ")"));
            return false;
        }
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

    /**
     *
     * @param owner
     * @return if the given owner has be deleted or not
     */
    @Override
    public boolean deleteOwner(Owner owner) {
        boolean ownerDeleted = true;
        try {
            ownerDeleted = ownerRepository.delete(owner.getOwnerId());
        } catch (Exception e) {
            Logger.getLogger(OwnerServiceImpl.class.getName())
                    .log(Level.WARNING, "Something went Wrong with Owner Deletion!");
        }
        return ownerDeleted;
    }

    //Validation patterns
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

    private boolean isAddressValid(String address) {
        String regex = "[\\w\\s]*\\d*";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(address).matches();
    }

    private boolean isOwnerValid(Owner owner) {
        return (isVatValid(owner.getOwnerVat())
                && isEmailValid(owner.getOwnerEmail())
                && isPwdValid(owner.getOwnerPwd())
                && isPhoneNumberValid(owner.getOwnerPhoneNumber()));
    }
}
