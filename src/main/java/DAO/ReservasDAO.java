package DAO;

import java.util.List;

import Models.Reservas;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;

@Stateless
public class ReservasDAO extends GenericDAO<Reservas, Integer> {

    @Override
    public Reservas get(Integer param) {
        Reservas entity = em.find(Reservas.class, param);
		return entity;
    }

    @Override
    public List<Reservas> getAll() {
        String jpql = "SELECT l FROM Reservas l";
		Query query = em.createQuery(jpql);
		return query.getResultList();
    }

}