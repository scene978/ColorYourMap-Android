package com.example.coloryourmap;

public class TravelPlan {
	String name;
	String date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public TravelPlan(String name, String date) {
		super();
		this.name = name;
		this.date = date;
	}

}
