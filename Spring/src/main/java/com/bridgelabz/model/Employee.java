package com.bridgelabz.model;

public class Employee {
	private String name;

	public Employee() {
		this.name = "default name";

	}

	public String getName() {
		return name;
	}

	/**
	 * @param name- employee name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
