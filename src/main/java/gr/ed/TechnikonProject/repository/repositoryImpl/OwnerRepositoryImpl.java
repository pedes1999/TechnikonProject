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
            owner.setOwnerAddress(newData.getOwnerAddress());
            owner.setOwnerEmail(newData.getOwnerEmail());
            owner.setOwnerPwd(newData.getOwnerPwd());
        }
    }

    @Override
    public List<Owner> readOwnerVat(String vat) {
        List<Owner> returnOwners = new ArrayList<>();
        for (Owner owner : read()) {
            if (owner.getOwnerVat() != null && owner.getOwnerVat().contains(vat)) {
                returnOwners.add(owner);
            }
        }
        return returnOwners;
    }

    @Override
    public List<Owner> readOwnerEmail(String email) {
        List<Owner> returnOwners = new ArrayList<>();
        for (Owner owner : read()) {
            if (owner.getOwnerEmail() != null && owner.getOwnerEmail().contains(email)) {
                returnOwners.add(owner);
            }
        }
        return returnOwners;
    }

}
