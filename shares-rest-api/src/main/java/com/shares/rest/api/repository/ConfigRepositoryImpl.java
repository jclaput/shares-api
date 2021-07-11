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
import org.springframework.context.annotation.Lazy;

import com.shares.rest.api.entity.Config;
import com.shares.rest.api.hibernate.SafeSession;

public class ConfigRepositoryImpl implements ConfigRepositoryCustom, SafeSession {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	@Lazy
	private ConfigRepository configRepository;  
	
	@Override
	public Config findConfigByMajorMinor(String cfMajor, String cfMinor) {
			
		Transaction transaction = null;
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Config> query = builder.createQuery(Config.class);
			Root<Config> root = query.from(Config.class);
			query.select(root).where(builder.equal(root.get("cfMajor"), cfMajor)).where(builder.equal(root.get("cfMinor"), cfMinor));
			Query<Config> q = session.createQuery(query);
			Config config = q.getSingleResult();
			
			transaction.commit();
			
			return config;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			
			return null;
		}	
	}
	
	@Override
	public Config findConfigByMajorMinorSingleResult(String cfMajor, String cfMinor) {
					
			Session session = getTangibleSession(sessionFactory); 
						
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Config> criteriaQuery = criteriaBuilder.createQuery(Config.class);
			Root<Config> root = criteriaQuery.from(Config.class);
			criteriaQuery.select(root)
			.where(criteriaBuilder.equal(root.get("cfMajor"), cfMajor))
			.where(criteriaBuilder.equal(root.get("cfMinor"), cfMinor));
			
			Query<Config> qry = session.createQuery(criteriaQuery);
			Config config = qry.getSingleResult();
			
			return config;
	}
	
	@Override
	public List<Config> findConfigByMajorWithSort(String cfMajor) {
		
		Session session = getTangibleSession(sessionFactory); 
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Config> criteriaQuery = criteriaBuilder.createQuery(Config.class);
		Root<Config> root = criteriaQuery.from(Config.class);
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(criteriaBuilder.asc(root.get("cfGeneral2")));
		orderList.add(criteriaBuilder.asc(root.get("cfGeneral1")));
		criteriaQuery.select(root)
		.where(criteriaBuilder.equal(root.get("cfMajor"), cfMajor))
		.orderBy(orderList);		
		
		Query<Config> qry = session.createQuery(criteriaQuery);
		return qry.getResultList();
	}
	

}
