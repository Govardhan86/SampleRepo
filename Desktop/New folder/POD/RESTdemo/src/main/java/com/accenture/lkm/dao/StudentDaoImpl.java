package com.accenture.lkm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accenture.lkm.RESTdemo.Student;

public class StudentDaoImpl implements StudentDao{
	Connection con=null;

	public StudentDaoImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemos","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public List<Student> getStudents() throws SQLException {
		
		List<Student> s=new ArrayList<Student>();
		
		String sql="select * from student";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			Student stu=new Student();
			stu.setId(rs.getInt(1));
			stu.setName(rs.getString(2));
			stu.setAddress(rs.getString(3));
			
			s.add(stu);
		}
		
		return s;
	}

	@Override
	public void createStudent(Student s) {
		String sql="insert into student values(?,?,?)";
		
		try { PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, s.getId());
		ps.setString(2, s.getName());
		ps.setString(3, s.getAddress());
		ps.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();}
		
	}

	@Override
	public Student findbyId(int id) throws SQLException {
		
		String sql="select * from student where id="+id;
		
		Student stu=new Student();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{
			stu.setId(rs.getInt(1));
			stu.setName(rs.getString(2));
			stu.setAddress(rs.getString(3));	
		}
		
		return stu;
		
	}
	public void deleteStudent(int id) {
		String sql="delete from student where id=?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	@Override
	public void updateStudent(Student s) {
		
		String sql="update student set address=? where id=?";
		
		PreparedStatement st;
		try {
			st=con.prepareStatement(sql);
			st.setString(1, s.getAddress());
			st.setInt(2, s.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
