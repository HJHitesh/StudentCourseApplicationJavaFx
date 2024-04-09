package com.sas.studentApplication.DOA;

import com.sas.studentApplication.Config.HibernateConfig;
import com.sas.studentApplication.DTO.ApplicationDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ApplicationDetailDoaImpl implements ApplicationDetailDOA {
    @Override
    public boolean save(ApplicationDetail applicationDetail) {
        Session session = HibernateConfig.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(applicationDetail);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public List<ApplicationDetail> getAllApplicationDetails() {
        Session session = HibernateConfig.getSession();
        Transaction transaction = null;
        try {
            session.beginTransaction();
            Query<ApplicationDetail> query = session.createQuery("FROM ApplicationDetail ORDER BY appId DESC", ApplicationDetail.class);
            List<ApplicationDetail> applicationDetails = query.list();
            session.getTransaction().commit();
            return applicationDetails;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public List<ApplicationDetail> getApplicationDetailsByUserId(int userId) {
        try (Session session = HibernateConfig.getSession()) {
            Query<ApplicationDetail> query = session.createQuery("FROM ApplicationDetail WHERE userId = :userId", ApplicationDetail.class);
            query.setParameter("userId", userId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ApplicationDetail> getApplicationDetailsByStatus(String status) {
        try (Session session = HibernateConfig.getSession()) {
            Query<ApplicationDetail> query = session.createQuery("FROM ApplicationDetail WHERE status = :status", ApplicationDetail.class);
            query.setParameter("status", status);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ApplicationDetail> getApplicationDetailsByUserIdAndStatus(int userId, String status) {
        try (Session session = HibernateConfig.getSession()) {
            Query<ApplicationDetail> query = session.createQuery("FROM ApplicationDetail WHERE userId = :userId AND status = :status", ApplicationDetail.class);
            query.setParameter("userId", userId);
            query.setParameter("status", status);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
