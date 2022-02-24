package com.accenture.lkm.dao;

import java.sql.SQLException;
import java.util.List;

import com.accenture.lkm.RESTdemo.Student;

public interface StudentDao {
	
	public List<Student> getStudents() throws SQLException;
	
	public void createStudent(Student s);
	
	public Student findbyId(int id) throws SQLException;
	
	public void updateStudent(Student s); 
}
