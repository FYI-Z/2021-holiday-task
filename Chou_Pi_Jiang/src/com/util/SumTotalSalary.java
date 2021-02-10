package com.util;

/**
 * des:计算员工实发工资
 * author:邓涛
 * time:2021/2/8 20:36
 * param：
 * return:
 * 
 */

public class SumTotalSalary {
	public static String SumSalary(String basic, String overtime, String commission, String bonus, String vacate, String late, String absenteeism) {
		float sum = 0;
		String actual = null;
		sum +=Float.parseFloat(basic)+Float.parseFloat(overtime)
		+Float.parseFloat(commission)+Float.parseFloat(bonus)
		+Float.parseFloat(vacate)+Float.parseFloat(late)
		+Float.parseFloat(absenteeism);
		actual = Float.toString(sum);
		return actual;
		
	}
}
