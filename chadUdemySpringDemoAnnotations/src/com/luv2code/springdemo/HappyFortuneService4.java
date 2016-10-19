package com.luv2code.springdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService4 implements FortuneService {
	private ArrayList<String> data = new ArrayList<>();

	private Random myRandom = new Random();

	private ArrayList<String> readFile(String fileName) {
		File file = new File(fileName);
		ArrayList<String> fortunes = new ArrayList<>();
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				fortunes.add(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			fortunes.add("File not found");
			return fortunes;
		}
		return fortunes;
	}

	@Override
	public String getFortune() {
		data = readFile("fortunes.txt");
		int index = myRandom.nextInt(data.size());
		return "HappyFortuneService4 - " + data.get(index);
	}

}
