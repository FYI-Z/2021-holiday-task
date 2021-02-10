package com.service.serviceImp;

import java.sql.*;
import java.util.*;

import com.entity.SalaryData;
import com.service.SalaryService;
import com.util.DBUtil;



/**
 * des:工资表业务逻辑实现
 * author:邓涛
 * time:2021/2/8 20:36
 * param：
 * return:
 * 
 */


public class AttendanceServiceImp implements SalaryService{

	
	
	/**
	 * des:，重写接口方法，拿到考勤表中数据
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：
	 * return:list
	 * 
	 */
	
	@Override
	public List<SalaryData> list() {
		PreparedStatement stmt = null;
		ResultSet results = null;
		List<SalaryData> list = new ArrayList<SalaryData>();
		String sql = "select *from emp_attendance";
		
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			results = stmt.executeQuery();
			
			while(results.next()) {
				SalaryData salaryData = new SalaryData();
				salaryData.setUsername(results.getString("username"));
				salaryData.setLeave_days(results.getFloat("leave_days"));
				salaryData.setLate_days(results.getInt("late_days"));
				salaryData.setAbsenteeism_days(results.getInt("absenteeism_days"));
				salaryData.setOvertime_hours(results.getFloat("overtime_hours"));
				list.add(salaryData);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * des:拿到工资表和考勤表中所有数据
	 * author:邓涛
	 * time:2021/2/8 20:36
	 * param：
	 * return:list
	 * 
	 */
	
	public List<SalaryData> ListAll(){
		PreparedStatement stmt = null;
		ResultSet results = null;
		List<SalaryData> list = new ArrayList<SalaryData>();
		String sql = "SELECT  emp_salary.username,emp_salary.basic,"
				+ "emp_salary.overtime,emp_salary.commission,"
				+ "emp_salary.bonus,emp_salary.vacate,emp_salary.late,"
				+ "emp_salary.absenteeism,emp_attendance.leave_days,"
				+ "emp_attendance.late_days,emp_attendance.overtime_hours,"
				+ "emp_attendance.absenteeism_days,emp_salary.actual"
				+ " from emp_salary,emp_attendance "
				+ "WHERE emp_salary.username = emp_attendance.username";
		
		try {
			stmt = DBUtil.conn.prepareStatement(sql);
			results = stmt.executeQuery();
			while(results.next()) {
				SalaryData salaryData = new SalaryData();
				salaryData.setUsername(results.getString("username"));
				salaryData.setLeave_days(results.getFloat("leave_days"));
				salaryData.setLate_days(results.getInt("late_days"));
				salaryData.setAbsenteeism_days(results.getInt("absenteeism_days"));
				salaryData.setOvertime_hours(results.getFloat("overtime_hours"));
				salaryData.setBasic(results.getFloat("basic"));
				salaryData.setOvertime(results.getFloat("overtime"));
				salaryData.setCommission(results.getFloat("commission"));
				salaryData.setBonus(results.getFloat("bonus"));
				salaryData.setVacate(results.getFloat("vacate"));
				salaryData.setLate(results.getFloat("late"));
				salaryData.setAbsenteeism(results.getFloat("absenteeism"));
				salaryData.setActual(results.getFloat("actual"));
				list.add(salaryData);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
