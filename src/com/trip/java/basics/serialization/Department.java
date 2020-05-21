package com.trip.java.basics.serialization;

import java.io.Serializable;

public class Department implements Serializable
{
	private String name;
	private long subjecs;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSubjecs() {
		return subjecs;
	}
	public void setSubjecs(long subjecs) {
		this.subjecs = subjecs;
	}
	
	@Override
	public String toString() {
		return "Department [name=" + name + ", subjecs=" + subjecs + "]";
	}
	
	
}
