package com.accenture.lkm.RESTdemo;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.accenture.lkm.dao.StudentDaoImpl;

@Path("students")
public class StudentResource {

	StudentDaoImpl studentdao = new StudentDaoImpl();

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> getStudentlist() throws SQLException {
		return studentdao.getStudents();

	}

	@GET
	@Path("student/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student getStudent(@PathParam("id") int id) throws SQLException {
		return studentdao.findbyId(id);
	}

	@POST
	@Path("createstudent")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student createStudent(Student student) {
		studentdao.createStudent(student);
		return student;
	}

	@DELETE
	@Path("student/{id}")
	public Student deleteStudent(@PathParam("id") int id) throws SQLException {
		Student s = getStudent(id);

		if (s.getId() != 0) {
			studentdao.deleteStudent(id);
		}
		return s;
	}

	@PUT
	@Path("updateStudent")
	public Student updateStudent(Student student) throws SQLException
	{
		if(studentdao.findbyId(student.getId()) != null)
		{
			studentdao.updateStudent(student);;
		}
		else
		{
			studentdao.createStudent(student);
		}
		return student;
	}
}
