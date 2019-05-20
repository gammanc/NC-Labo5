package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	public int save(Student s, Integer newRow) throws DataAccessException {
		try {
			if(newRow == 1) entityManager.persist(s);
			else entityManager.merge(s);
			entityManager.flush();
			return 1;
		}catch(Throwable t) {
			t.printStackTrace();
			return 1;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int delete(Student s) throws DataAccessException {
		try {
				entityManager.remove(entityManager.contains(s) ? s : entityManager.merge(s));
				entityManager.flush();			
		}catch(Throwable t) {
			t.printStackTrace();
			return 0;
		}
		return 0;
	}

}
