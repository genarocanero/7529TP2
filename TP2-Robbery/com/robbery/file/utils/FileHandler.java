package com.robbery.file.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileHandler {

	private FileHandler() {

	}

	public static List<Stay> parse(String filePath) throws IOException {

		List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);

		List<Stay> stayList = new ArrayList<>();

		for (String line : lines) {
			String[] lineParts = line.split(",");
			try {
				Stay stay = new Stay(lineParts[0], Integer.valueOf(lineParts[1]),
						Integer.valueOf(lineParts[2].replace(".", "")));
				stayList.add(stay);
			} catch (Exception e) {
				System.out.println("Invalid input file");
			}
		}

		return stayList;
	}

	public static void writeFile(List<List<Stay>> suspectGroups) throws IOException {

		FileWriter fileWriter = new FileWriter("sospechosos.txt");

		for (List<Stay> suspectList : suspectGroups) {
			StringBuilder line = new StringBuilder();
			int count = 0;
			for (Stay suspect : suspectList) {
				count++;
				line.append(suspect.getName()).append(" ").append(suspect.getStayTime());
				if (count < suspectList.size()) {
					line.append(",");
				}
			}
			fileWriter.write(line.toString());
		}

		fileWriter.close();
	}

}
