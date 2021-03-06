package com.robbery;

import java.util.ArrayList;
import java.util.List;

public class Detective {

	private static final int MIN_EXIT_TIME = 40;
	private static final int MAX_EXIT_TIME = 120;
	private static final int MAX_SUSPECTS = 10;
	private static final int MIN_SUSPECTS = 5;

	public static List<List<Stay>> discoverSuspectGroups(List<Stay> listOfRegistries) {

		List<Stay> staysOrderedByExitTime = ListOfStaysUtils.sortByExitTime(listOfRegistries);

		List<Stay> exitsAfterMinTime = ListOfStaysUtils
				.findExitsAfter(staysOrderedByExitTime, MIN_EXIT_TIME);

		List<List<Stay>> listOfSuspectGroups = new ArrayList<>();

		for (Stay currentStay : exitsAfterMinTime) {
			List<Stay> sublistOfExitsAfterCurrent = ListOfStaysUtils
					.findExitsAfter(exitsAfterMinTime, currentStay.getExitTime());

			List<Stay> listOfSuspectStays = ListOfStaysUtils
					.findEntrancesBefore(sublistOfExitsAfterCurrent, currentStay.getExitTime());

			if ((listOfSuspectStays.size() <= MAX_SUSPECTS
					&& listOfSuspectStays.size() >= MIN_SUSPECTS)) {

				ListOfStaysUtils.sortByEntranceTime(listOfSuspectStays);
				if ((currentStay.getExitTime() - listOfSuspectStays.get(0).getTimeOfEntrance()) <= MAX_EXIT_TIME &&
					(currentStay.getExitTime() - listOfSuspectStays.get(0).getTimeOfEntrance()) >= MIN_EXIT_TIME) {

					List<Stay> otherRegistries = ListOfStaysUtils
							.sortByExitTime(ListOfStaysUtils
									.findOtherRegistries(listOfSuspectStays, listOfRegistries));

					if (otherRegistries.isEmpty() ||
							otherRegistries.get(otherRegistries.size() - 1).getExitTime()
									< listOfSuspectStays.get(listOfSuspectStays.size() - 1)
									.getTimeOfEntrance()) {

						listOfSuspectGroups.add(listOfSuspectStays);
					}
				}
			}
		}

		return listOfSuspectGroups;

	}

}
