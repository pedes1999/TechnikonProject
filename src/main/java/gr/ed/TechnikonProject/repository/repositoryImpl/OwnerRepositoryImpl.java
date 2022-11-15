package gr.ed.TechnikonProject.repository.repositoryImpl;

import gr.ed.TechnikonProject.model.Owner;
import gr.ed.TechnikonProject.repository.OwnerRepository;
import java.util.ArrayList;
import java.util.List;

public class OwnerRepositoryImpl extends RepositoryImpl<Owner> implements OwnerRepository {

    @Override
    public void update(int ownerId, Owner newData) {
        Owner owner = read(ownerId);
        if (owner != null) {
            owner.setAddress(newData.getAddress());
            owner.setEmail(newData.getEmail());
            owner.setPassword(newData.getPassword());
        }
    }

    @Override
    public List<Owner> searchPerOwnerVat(String vat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Owner> searchPerOwnerEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Owner> readOwnerVat(String vat) {
        List<Owner> returnOwners = new ArrayList<>();
        for (Owner owner : read()) {
            if (owner.getVat() != null && owner.getVat().contains(vat)) {
                returnOwners.add(owner);
            }
        }
        return returnOwners;}

    @Override
    public List<Owner> readOwnerEmail(String email) {
        List<Owner> returnOwners = new ArrayList<>();
        for (Owner owner : read()) {
            if (owner.getEmail() != null && owner.getEmail().contains(email)) {
                returnOwners.add(owner);
            }
        }
        return returnOwners;} 

}




