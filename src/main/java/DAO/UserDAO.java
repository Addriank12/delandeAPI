package DAO;

import java.util.Optional;

import Models.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    public Optional<User> findByUsername(String username) {
        try {
            return Optional.of(em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", username)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public void save(User user) {
        em.persist(user);
    }

}
