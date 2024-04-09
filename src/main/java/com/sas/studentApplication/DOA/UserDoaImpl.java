package com.sas.studentApplication.DOA;

import com.sas.studentApplication.Config.HibernateConfig;
import com.sas.studentApplication.DTO.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class UserDoaImpl implements UserDOA {
    @Override
    public User validateUser(String userName, String password) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSession()) {
            String sqlQuery = "SELECT * FROM User WHERE UserName = :username AND Password = :password";
            NativeQuery<Object[]> query = session.createNativeQuery(sqlQuery);
            query.setParameter("username", userName);
            query.setParameter("password", password);

            List<Object[]> results = query.list();
            if (!results.isEmpty()) {
                Object[] row = results.get(0);
                User user = new User();
                user.setId((Integer) row[0]);
                user.setUserName((String) row[1]);
                user.setPassword((String) row[2]);
                user.setRole((String) row[3]);
                user.setStatus((String) row[4]);
                user.setCreatedOn((String) row[5]);
                user.setUpdateOn((String) row[6]);
                user.setCreatedBy((Integer) row[7]);
                return user;
            } else {
                return null; // No matching user found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
