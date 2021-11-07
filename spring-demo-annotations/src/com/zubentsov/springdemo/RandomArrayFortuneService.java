package com.zubentsov.springdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomArrayFortuneService implements FortuneService {

	@Value("${pathToArrayOfString}")
	String pathToArray;

	List<String> collection = new ArrayList<String>();

	Random random = new Random();

	@Override
	public String getFortune() {

		if (collection.isEmpty()) {
			loadValues();
		}

		int index = random.nextInt(collection.size());
		return collection.get(index);
	}

	private void loadValues() {
		try (Scanner sc = new Scanner(new File(pathToArray))) {
			while (sc.hasNextLine()) {
				collection.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
