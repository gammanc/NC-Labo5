package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.student");
		Query query = entityManager.createNativeQuery(sb.toString(),Student.class);
		List<Student> resultset = query.getResultList();
		return resultset;
	}

	@Override
	public Student findOne(Integer code) throws DataAccessException {
		Student student = entityManager.find(Student.class, code);
		return student;
	}

}
