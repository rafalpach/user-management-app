package com.task.user_management_app.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<User> getUserByName(String name, String surname){
		return em.createNativeQuery("SELECT * FROM APP_USERS where NAME = ? and SURNAME = ?", User.class)
				.setParameter(1, name)
				.setParameter(2, surname)
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		return em.createNativeQuery("SELECT * FROM APP_USERS", User.class)
				.getResultList();
	}
	
	public User getUserById(int id){
		return (User) em.createNativeQuery("SELECT * FROM APP_USERS where ID = ?", User.class)
				.setParameter(1, id)
				.getSingleResult();
	}
	
	public void create(User user){
		em.persist(user);	
	}
	
	public void delete (User user) {
		em.remove(user);
	}
	
	public void update (User user) {
		em.merge(user);
	}
	
	public List<User> getUsersByParameters(String id, String name, String surname, String grade, String salary){
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<User> cq = cb.createQuery(User.class);
	    Root<User> root = cq.from(User.class);

	    Set<Predicate> predicates = new HashSet<Predicate>();
	    
	    if (id != null) {
	        predicates.add(cb.equal(root.get("id"), id));
	    }

	    if (name != null) {
	        predicates.add(cb.equal(root.get("name"), name));
	    }

	    if (surname != null) {
	        predicates.add(cb.equal(root.get("surname"), surname));
	    }
	    
	    if (grade != null) {
	        predicates.add(cb.equal(root.get("grade"), grade));
	    }
	    
	    if (salary != null) {
	        predicates.add(cb.equal(root.get("salary"), salary));
	    }

	    cq.where(predicates.toArray(new Predicate[predicates.size()]));

	    return em.createQuery(cq).getResultList();
	}
	
}
