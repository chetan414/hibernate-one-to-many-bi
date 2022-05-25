package com.ty.onetomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobileSim {
	public static void main(String[] args) {
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		List<Sim> sims = new ArrayList();
		
		
		Mobile mobile = new Mobile();
		mobile.setName("POCO");
		mobile.setCost(23000);
		
		Sim sim = new Sim();
		sim.setProvider("VI");
		sim.setType("3G");
		sim.setImei(123456789098765l);
		sim.setMobile(mobile);
		
		Sim sim2 = new Sim();
		sim2.setProvider("Airtel");
		sim2.setType("4G");
		sim2.setImei(123451234598765l);
		sim2.setMobile(mobile);
		
		sims.add(sim);
		sims.add(sim2);
		
		mobile.setSims(sims);
		
		
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim);
		entityManager.persist(sim2);
		entityTransaction.commit();
	}
}
