package com.robbery.file.utils;

public class Stay {

	private String name;

	private int timeOfEntrance;

	private int stayTime;

	Stay(String name, int timeOfEntrance, int stayTime) {
		this.name = name;
		this.timeOfEntrance = timeOfEntrance;
		this.stayTime = stayTime;
	}

	String getName() {
		return name;
	}

	int getTimeOfEntrance() {
		return timeOfEntrance;
	}

	int getStayTime() {
		return stayTime;
	}

	int getExitTime() {
		return timeOfEntrance + stayTime;
	}

}