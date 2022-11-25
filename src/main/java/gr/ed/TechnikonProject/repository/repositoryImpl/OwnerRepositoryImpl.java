package gr.ed.TechnikonProject.repository.repositoryImpl;

import gr.ed.TechnikonProject.model.User;
import gr.ed.TechnikonProject.repository.OwnerRepository;
import jakarta.persistence.EntityManager;

import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;


public class OwnerRepositoryImpl implements OwnerRepository {
       protected EntityManager entityManager;


    public OwnerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public int create(User t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return t.getOwnerId();
    }

    @Override
    public User read(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> read() {
        return entityManager.createQuery("from Owner", User.class).getResultList();
    }

    @Override
    public Optional<User> readOwnerVat(String vat) {
        String selectString = "select * from owner where ownerVat=?";
        Query sqlQuery = entityManager.createNativeQuery(selectString, User.class);
        sqlQuery.setParameter(1, vat);
        try {
            User owner = (User) sqlQuery.getSingleResult();
            return Optional.of(owner);
        } catch (Exception NoResultException) {
            return Optional.empty();
        }

    }

    @Override
    public Optional<User> readOwnerEmail(String email) {
        String selectString = "select * from owner where ownerEmail=?";
        Query sqlQuery = entityManager.createNativeQuery(selectString, User.class);
        sqlQuery.setParameter(1, email);
        try {
            User owner = (User) sqlQuery.getSingleResult();
            return Optional.of(owner);
        } catch (Exception NoResultException) {
            return Optional.empty();
        }
    }

    @Override
    public boolean updateAddress(String vatNumber, String newAddress) throws Exception {
        Optional<User> owner = readOwnerVat(vatNumber);
        if (owner.isPresent()) {
            try {
                User owner2 = owner.get();
                owner2.setOwnerAddress(newAddress);
                entityManager.getTransaction().begin();
                entityManager.merge(owner2);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                throw new Exception(e);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEmail(String vatNumber, String newEmail) throws Exception {
        Optional<User> owner = readOwnerVat(vatNumber);
        if (owner.isPresent()) {
            try {
                User owner2 = owner.get();
                owner2.setOwnerEmail(newEmail);
                entityManager.getTransaction().begin();
                entityManager.merge(owner2);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                throw new Exception(e);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePassword(String vatNumber, String newPassword) throws Exception {
        Optional<User> owner = readOwnerVat(vatNumber);
        if (owner.isPresent()) {
            try {
                User owner2 = owner.get();
                owner2.setOwnerPwd(newPassword);
                entityManager.getTransaction().begin();
                entityManager.merge(owner2);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                throw new Exception(e);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        User persistentInstance = entityManager.find(User.class, id);
        if (persistentInstance != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(persistentInstance);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return true;
    }

}
