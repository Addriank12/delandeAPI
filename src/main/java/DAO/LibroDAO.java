package DAO;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import Models.Libro;

@Stateless
public class LibroDAO extends GenericDAO<Libro, String> {

    @Override
    public Libro get(String param) {
        Libro entity = em.find(Libro.class, param);
		return entity;
    }

    @Override
    public List<Libro> getAll() {
        String jpql = "SELECT l FROM Libro l";
		Query query = em.createQuery(jpql);
		return query.getResultList();
    }

}
