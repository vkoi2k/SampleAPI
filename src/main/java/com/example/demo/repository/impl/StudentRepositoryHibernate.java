package com.example.demo.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;


@Repository
public class StudentRepositoryHibernate implements StudentRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public StudentRepositoryHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Student> findAll() {
		Session session = sessionFactory.getCurrentSession();
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
//		Root<Student> root = criteriaQuery.from(Student.class);
//		
//		
////		Predicate nameEqual = criteriaBuilder.equal(root.get("name"), "a");
////		criteriaQuery.select(root).where(nameEqual);
//		
////		Predicate iNLike = criteriaBuilder.like(root.get("identityNumber"), "1%");
////		criteriaQuery.select(root).where(iNLike);
//		
//		criteriaQuery.select(root);
//		Query<Student> query = session.createQuery(criteriaQuery);
//		List<Student> list = query.getResultList();
//		return list;
		return session.createQuery("FROM Student",Student.class).getResultList();
	}

	@Override
	public Student findById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Student.class, id);
	}

	@Override
	public void insert(Student s) {
		Session session = sessionFactory.getCurrentSession();
		session.save(s);
	}

	@Override
	public void update(Student s) {
		Session session = sessionFactory.getCurrentSession();
		session.update(s);
	}

	@Override
	public void delete(Student s) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(s);
	}

}
