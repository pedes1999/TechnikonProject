package gr.ed.TechnikonProject.service;

import gr.ed.TechnikonProject.model.Owner;

public interface OwnerService {

    boolean addOwner(Owner owner);

    Owner searchOwnerByOwnerId(int ownerId);
    Owner searchOwnerPerVat(String ownerVatNumber);
    Owner searchOwnerPerEmail(String ownerEmail);

    boolean updateOwnerAddress(final Owner owner, String ownerAddress);
    boolean updateOwnerEmail(final Owner owner, String ownerEmail);
    boolean updateOwnerPwd(final Owner owner, String ownerPwd);
    boolean deleteOwner(Owner owner);

}
