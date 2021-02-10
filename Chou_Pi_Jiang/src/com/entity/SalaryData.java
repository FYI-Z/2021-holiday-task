package com.entity;

/**
 * des:职工工资实体类
 * author:邓涛
 * time:2021/2/8 20:36
 * param:@
 * return:无
 * 
 */

public class SalaryData {
	private String username;
	private float basic;
	private float overtime;
	private float commission;
	private float bonus;
	private String msg;
	private float leave_days;
	private int late_days;
	private int absenteeism_days;
	private float overtime_hours;
	private float vacate;
	private float late;
	private float absenteeism;
	private float actual;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getBasic() {
		return basic;
	}
	public void setBasic(float basic) {
		this.basic = basic;
	}
	public float getOvertime() {
		return overtime;
	}
	public void setOvertime(float overtime) {
		this.overtime = overtime;
	}
	public float getCommission() {
		return commission;
	}
	public void setCommission(float commission) {
		this.commission = commission;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	public float getVacate() {
		return vacate;
	}
	public void setVacate(float vacate) {
		this.vacate = vacate;
	}
	public float getLate() {
		return late;
	}
	public void setLate(float late) {
		this.late = late;
	}
	public float getAbsenteeism() {
		return absenteeism;
	}
	public void setAbsenteeism(float absenteeism) {
		this.absenteeism = absenteeism;
	}
	public float getActual() {
		return actual;
	}
	public void setActual(float actual) {
		this.actual = actual;
	}
	
	public float getLeave_days() {
		return leave_days;
	}
	public void setLeave_days(float leave_days) {
		this.leave_days = leave_days;
	}
	public int getLate_days() {
		return late_days;
	}
	public void setLate_days(int late_days) {
		this.late_days = late_days;
	}
	public int getAbsenteeism_days() {
		return absenteeism_days;
	}
	public void setAbsenteeism_days(int absenteeism_days) {
		this.absenteeism_days = absenteeism_days;
	}
	public float getOvertime_hours() {
		return overtime_hours;
	}
	public void setOvertime_hours(float overtime_hours) {
		this.overtime_hours = overtime_hours;
	}
}
