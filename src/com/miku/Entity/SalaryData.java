package com.miku.Entity;

public class SalaryData {
	private String username;
	private float basic;
	private float overtime;
	private float commission;
	private float bonus;
	private String msg;
	
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
	private float vacate;
	private float late;
	private float absenteeism;
	private float actual;
}