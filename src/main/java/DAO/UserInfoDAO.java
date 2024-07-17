package DAO;

import java.util.List;

import Models.UserInfo;
import jakarta.persistence.Query;

public class UserInfoDAO extends GenericDAO<UserInfo, Integer>{

    @Override
    public UserInfo get(Integer param) {
        UserInfo entity = em.find(UserInfo.class, param);
		return entity;
    }

    @Override
    public List<UserInfo> getAll() {
        String jpql = "SELECT ui FROM UsersInfo ui";
		Query query = em.createQuery(jpql);
		return query.getResultList();
    }

}
