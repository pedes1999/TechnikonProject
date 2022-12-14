package gr.ed.TechnikonProject.repository;

import gr.ed.TechnikonProject.model.Owner;
import java.util.Optional;

public interface OwnerRepository extends Repository<Owner> {
    //Read based on specific criteria

    public Optional<Owner> readOwnerVat(String vat);

    public Optional<Owner> readOwnerEmail(String email);

    //Update owner data
    boolean updateAddress(String vatNumber, String newAddress) throws Exception;

    boolean updateEmail(String vatNumber, String newEmail) throws Exception;

    boolean updatePassword(String vatNumber, String newPassword) throws Exception;

}
