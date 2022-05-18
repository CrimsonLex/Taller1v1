package com.icesi.samaca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.icesi.samaca.model.person.Address;
import com.icesi.samaca.model.sales.Salestaxrate;

@Repository
@Scope("Singleton")
public class SalesTaxRateDaoImp implements SalesTaxRateDAO {
	
	@PersistenceContext
	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(Salestaxrate sT) {
		// TODO Auto-generated method stub
		entityManager.persist(sT);
	}

	@Override
	public void update(Salestaxrate sT) {
		
		entityManager.merge(sT);
		
	}

	@Override
	public List<Salestaxrate> findAll() {
		Query query= entityManager.createQuery("SELECT s FROM Salestaxrate s");
		return query.getResultList();
		
	}

	@Override
	public Salestaxrate findById(Integer sTId) {
		// TODO Auto-generated method stub
		return entityManager.find(Salestaxrate.class, sTId);
		
	}

	@Override
	public List<Salestaxrate> findByStateprovince(Integer stPId) {
		
		
		  
		  	String jpql = "SELECT s FROM Salestaxrate s WHERE s.stateprovince.stateprovinceid = '"+stPId+"'";
			return entityManager.createQuery(jpql,Salestaxrate.class).getResultList();
		 
	}

	@Override
	public List<Salestaxrate> findByName(String name) {
		

	  	String jpql = "SELECT s FROM Salestaxrate s WHERE s.name = '"+name+"'";
		return entityManager.createQuery(jpql,Salestaxrate.class).getResultList();
	 
	}

}
