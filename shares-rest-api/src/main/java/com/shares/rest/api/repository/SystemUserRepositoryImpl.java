package com.shares.rest.api.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.shares.rest.api.entity.CfgDesignation;
import com.shares.rest.api.entity.SystemUser;
import com.shares.rest.api.entity.SystemUser_;
import com.shares.rest.api.hibernate.SafeSession;

public class SystemUserRepositoryImpl implements SystemUserRepositoryCustom, SafeSession {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CfgDesignationRepository cfgDesignationRepository;
	
	@Override
	public List<SystemUser> getAllUsersForTableDisplay() {

		Session session = getTangibleSession(sessionFactory);
		
		StringBuilder hql = new StringBuilder();
		hql.append("select su from SystemUser ");
		hql.append("su join fetch su.designation de where de.cfMajor = 'DSG'");
		Query<SystemUser> qry = session.createQuery(hql.toString(), 
			SystemUser.class);
				
		return qry.getResultList();
	}

	@Override
	public SystemUser getSystemUserByID(int id) {

		Session session = getTangibleSession(sessionFactory);
		
		StringBuilder hql = new StringBuilder();
		hql.append("select su from SystemUser ");
		hql.append("su join fetch su.designation de ");
		hql.append("where de.cfMajor = 'DSG' and su.primarykey=");
		hql.append(id);
		
		Query<SystemUser> qry = session.createQuery(hql.toString(), 
			SystemUser.class);
		
		
		return qry.getSingleResult();
	}
	
	@Override
	public List<SystemUser> getAllTeachers() {
		final String TEACHER = "002";
		Session session = getTangibleSession(sessionFactory);
		CfgDesignation cfgDesignation = cfgDesignationRepository.findCfgDesignationByCode(TEACHER);		

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<SystemUser> criteriaQuery = criteriaBuilder.createQuery(SystemUser.class);
		Root<SystemUser> root = criteriaQuery.from(SystemUser.class);
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(criteriaBuilder.asc(root.get(SystemUser_.FULL_NAME)));
		criteriaQuery.select(root)
		.where(criteriaBuilder.equal(root.get(SystemUser_.DESIGNATION), cfgDesignation))
		.orderBy(orderList);

		Query<SystemUser> qry = session.createQuery(criteriaQuery);
		return qry.getResultList();
	}

	@Override
	public SystemUser updateSystemUser(SystemUser systemUser) {
		
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			
			session.update(systemUser);
			
			transaction.commit();
			
			return systemUser;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		}	
	}
}
