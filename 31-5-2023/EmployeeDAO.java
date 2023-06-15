package com.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dal.Model.ModelClass;
import com.dal.util.MydbConnection;
public class EmployeeDAO {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	public void InsertEmployee(ModelClass mc)
	{
		con = MydbConnection.getMyConnection();
		try {
			ps = con.prepareStatement("insert into dalemp values (?,?) ");
			ps.setInt(1, mc.getEmpNo());
			ps.setString(2, mc.getEmpName());
			int nrows = ps.executeUpdate();
			System.out.println("No. of rows inserted" +nrows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ShowEmployee() {
		con = MydbConnection.getMyConnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from dalemp");
			while (rs.next())
			{
				System.out.println(rs.getInt(1) + " --" + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void UpdateEmployee(ModelClass mc) {
		con = MydbConnection.getMyConnection();
		try {
			ps = con.prepareStatement("Update dalemp set EmpName=? where EmpNo = ?");
			ps.setString(1, mc.getEmpName());
			ps.setInt(2, mc.getEmpNo());
			int noofrows = ps.executeUpdate();
			System.out.println("Update no. of rows"+noofrows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DeleteEmployee(int EmpNo) {
		con = MydbConnection.getMyConnection();
		try {
			ps=con.prepareStatement("Delete from dalemp where EmpNo = ?");
			ps.setInt(1, EmpNo);
			int noofrows = ps.executeUpdate();
			System.out.println("Delete no of record" +noofrows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
