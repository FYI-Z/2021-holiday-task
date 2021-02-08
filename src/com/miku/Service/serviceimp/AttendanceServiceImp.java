package com.miku.Service.serviceimp;

import java.sql.*;
import java.util.*;

import com.miku.Entity.SalaryData;
import com.miku.Service.SalaryService;
import com.miku.Util.DBUtil;

public class AttendanceServiceImp implements SalaryService{

	@Override
	public List<SalaryData> list() {
		return null;
	}
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