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
		//Connection conn = null;
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
}
