package DAO;

import java.util.List;

import Models.UserInfo;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;

@Stateless
public class UserInfoDAO extends GenericDAO<UserInfo, String>{

    @Override
    public UserInfo get(String param) {
        UserInfo entity = em.find(UserInfo.class, param);
		return entity;
    }

    @Override
    public List<UserInfo> getAll() {
        String jpql = "SELECT ui FROM UserInfo ui";
		Query query = em.createQuery(jpql);
		return query.getResultList();
    }

}
