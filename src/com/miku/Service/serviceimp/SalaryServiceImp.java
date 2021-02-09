package com.miku.Service.serviceimp;

import java.sql.*;
import java.util.*;

import com.miku.Entity.SalaryData;
import com.miku.Entity.UserData;
import com.miku.Service.SalaryService;
import com.miku.Util.DBUtil;
/*
 *author:邓涛 
 * 
*/
public class SalaryServiceImp implements SalaryService{
	
	public List<SalaryData> list(){
		PreparedStatement stmt = null;
		ResultSet results = null;
		List<SalaryData>list  = new ArrayList<SalaryData>();
		String sql = "select *from emp_salary";
		
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			results = stmt.executeQuery();
			
			while(results.next()) {
				SalaryData salaryData = new SalaryData();
				salaryData.setUsername(results.getString("username"));
				salaryData.setBasic(results.getFloat("basic"));
				salaryData.setOvertime(results.getFloat("overtime"));
				salaryData.setCommission(results.getFloat("commission"));
				salaryData.setBonus(results.getFloat("bonus"));
				salaryData.setVacate(results.getFloat("vacate"));
				salaryData.setLate(results.getFloat("late"));
				salaryData.setAbsenteeism(results.getFloat("absenteeism"));
				salaryData.setActual(results.getFloat("actual"));
				salaryData.setMsg(results.getString("confirm"));
				list.add(salaryData);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public List<SalaryData> listSearch(String username) {
		PreparedStatement stmt = null;
		ResultSet results= null;
		List<SalaryData> listSearch = new ArrayList<SalaryData>();
		String sql =  " SELECT  emp_salary.username,emp_salary.basic," + 
				"emp_salary.overtime,emp_salary.commission," + 
				"emp_salary.bonus,emp_salary.vacate,emp_salary.late," + 
				"emp_salary.absenteeism,emp_attendance.leave_days," + 
				"emp_attendance.late_days,emp_attendance.overtime_hours," + 
				"emp_attendance.absenteeism_days,emp_salary.actual " + 
				"from emp_salary,emp_attendance " + 
				"WHERE emp_salary.username = '"+username+"' AND emp_attendance.username='"+username+"'";
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			results = stmt.executeQuery();
			
			while(results.next()) {
				SalaryData salaryData = new SalaryData();
				salaryData.setUsername(results.getString("username"));
				salaryData.setBasic(results.getFloat("basic"));
				salaryData.setOvertime(results.getFloat("overtime"));
				salaryData.setCommission(results.getFloat("commission"));
				salaryData.setBonus(results.getFloat("bonus"));
				salaryData.setVacate(results.getFloat("vacate"));
				salaryData.setLate(results.getFloat("late"));
				salaryData.setAbsenteeism(results.getFloat("absenteeism"));
				salaryData.setActual(results.getFloat("actual"));
				listSearch.add(salaryData);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listSearch;
	}
}
