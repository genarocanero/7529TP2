package com.robbery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ListOfStaysUtils {

	static List<Stay> sortByExitTime(List<Stay> list) {
		list.sort(Comparator.comparing(Stay::getExitTime));
		return list;
	}

	static List<Stay> sortByEntranceTime(List<Stay> list) {
		list.sort(Comparator.comparing(Stay::getTimeOfEntrance));
		return list;
	}

	static List<Stay> findExitsAfter(List<Stay> list, int exitTime) {
		List<Stay> exits = new ArrayList<>();

		for (Stay currentStay : list) {
			if (currentStay.getExitTime() >= exitTime) {
				exits.add(currentStay);
			}
		}

		return exits;
	}

	static List<Stay> findEntrancesBefore(List<Stay> list, int entranceTime) {
		List<Stay> entrances = new ArrayList<>();

		for (Stay currentStay : list) {
			if (currentStay.getTimeOfEntrance() < entranceTime) {
				entrances.add(currentStay);
			}
		}

		return entrances;
	}

	static List<Stay> findOtherRegistries(List<Stay> listOfSuspects, List<Stay> listOfRegistries) {
		List<Stay> otherRegistries = new ArrayList<>();

		for (Stay suspect : listOfSuspects) {
			for (Stay registry : listOfRegistries) {
				if (registry.getName().equals(suspect.getName()) && !registry.equals(suspect)) {
					otherRegistries.add(registry);
				}
			}
		}

		return otherRegistries;
	}
}