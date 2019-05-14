package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@PersistenceContext(name="capas")
	 private EntityManager entityManager;
	
	@Override
	public List<Student> findALL() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb= new StringBuffer();
		sb.append("select * from public.student");
		Query query = entityManager.createNativeQuery(sb.toString(),Student.class);
		List<Student> resultset= query.getResultList();
		
		return resultset;
	}

	@Override
	public Student findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		  Student student= entityManager.find(Student.class, code);
		return student;
	}

	@Transactional
	public int save(Student s, Integer newRow) throws DataAccessException {
		try {
			if(newRow==1) entityManager.persist(s);
			else entityManager.merge(s);
			entityManager.flush();
			return 1;
		}
		catch(Throwable e) {
			e.printStackTrace();
			return 1;
		}
	
	}

	@Transactional
	public int delete(String name) throws DataAccessException {
		
		try{
			StringBuffer sb= new StringBuffer();
			sb.append("select * from public.student WHERE s_name=:name");
			Query query = entityManager.createNativeQuery(sb.toString(),Student.class);
			 query.setParameter("name", name);
			 Student student= (Student) query.setMaxResults(1).getSingleResult();
			 entityManager.remove(student);	
		return 1;
	}
	catch(Throwable e) {
		e.printStackTrace();
		return 1;

	}
	}
}


