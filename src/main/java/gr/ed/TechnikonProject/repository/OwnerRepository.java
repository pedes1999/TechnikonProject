package gr.ed.TechnikonProject.repository;

import gr.ed.TechnikonProject.model.Owner;
import java.util.List;

public interface OwnerRepository extends Repository<Owner> {

    void update(int ownerId, Owner newData);

    List<Owner> searchPerOwnerVat(String vat);
    
    List<Owner> searchPerOwnerEmail(String email);
    
    List<Owner> readOwnerVat(String vat);
    
    List<Owner> readOwnerEmail(String email);
    
    

}