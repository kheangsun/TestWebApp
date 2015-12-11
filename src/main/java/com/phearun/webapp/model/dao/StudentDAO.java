package com.phearun.webapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.phearun.webapp.model.dto.StudentDTO;

public class StudentDAO {
	
	private Connection con = null;
	private DataSource dataSource = null;
	
	public StudentDAO(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public ArrayList<StudentDTO> getStudent(){
		ArrayList<StudentDTO> students = new ArrayList<StudentDTO>();
		try{
			con = dataSource.getConnection();
			String sql = "SELECT * FROM student";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				StudentDTO student =  new StudentDTO();
				student.setId(rs.getInt("id"));
				student.setLname(rs.getString("last_name"));
				student.setFname(rs.getString("first_name"));
				student.setGender(rs.getString("gender"));
				student.setImage(rs.getString("image"));
				students.add(student);
			}
			return students;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return students;
	}

	public boolean addStudent(StudentDTO stu) {
		try{
			con = dataSource.getConnection();
			String sql = "INSERT INTO student(last_name, first_name, gender, age, birthdate, register_date) VALUES(?,?,?,?,?,?)";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, stu.getLname());
			p.setString(2, stu.getFname());
			p.setString(3, stu.getGender());
			p.setInt(4, stu.getAge());
			p.setString(5, stu.getBirthdate());
			p.setString(6, stu.getRdate());
			if(p.executeUpdate()>0)
				return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteStudent(int id) {
		try{
			con = dataSource.getConnection();
			String sql = "DELETE FROM student WHERE id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			if(p.executeUpdate()>0)
				return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return false;
	}

	public StudentDTO viewStudent(int id) {
		try{
			con = dataSource.getConnection();
			String sql = "SELECT * FROM student WHERE id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				StudentDTO student = new StudentDTO();
				student.setId(rs.getInt("id"));
				student.setFname(rs.getString("first_name"));
				student.setLname(rs.getString("last_name"));
				student.setGender(rs.getString("gender"));
				student.setImage(rs.getString("image"));
				student.setAge(rs.getInt("age"));
				student.setRdate(rs.getString("register_date"));
				student.setBirthdate(rs.getString("birthdate"));
				
				return student;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean updateStudent(StudentDTO stu) {
		try{
			con = dataSource.getConnection();
			String sql = "UPDATE student SET first_name=?, last_name=?, gender=?, age=?, register_date=?, birthdate=? WHERE id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, stu.getFname());
			p.setString(2, stu.getLname());
			p.setString(3, stu.getGender());
			p.setInt(4, stu.getAge());
			p.setString(5, stu.getRdate());
			p.setString(6, stu.getBirthdate());
			p.setInt(7, stu.getId());
			if(p.executeUpdate()>0)
				return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}

	public StudentDTO getOneStudent(int id) {
		try{
			con = dataSource.getConnection();
			String sql = "SELECT * FROM student WHERE id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				StudentDTO student = new StudentDTO();
				student.setId(rs.getInt("id"));
				student.setFname(rs.getString("first_name"));
				student.setLname(rs.getString("last_name"));
				student.setGender(rs.getString("gender"));
				student.setImage(rs.getString("image"));
				student.setAge(rs.getInt("age"));
				student.setRdate(rs.getString("register_date"));
				student.setBirthdate(rs.getString("birthdate"));
				return student;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
