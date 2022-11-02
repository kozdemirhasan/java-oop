package de.kozdemir.advancedJava.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class OpenCsvExample {

	public static void main(String[] args) throws IOException, CsvException {

		// Csv file read
		String fileName = "country.csv";
		try {
			try (CSVReader reader = new CSVReader(new FileReader(fileName))) {

				List<String[]> r = reader.readAll();
				r.forEach(x -> System.out.println(Arrays.toString(x)));
			}
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " not found!");
		}

	}

}