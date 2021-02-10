package com.entity;

/*
 * description: 部门管理的实体类
 * author: 李章
 * time: 2021.02.08
 * the name of the class: Departments
 * */
public class Departments {
	private String name;		
	private String operator;
	public Departments() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
}
