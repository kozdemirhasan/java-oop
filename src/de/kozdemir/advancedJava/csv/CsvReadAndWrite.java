package de.kozdemir.advancedJava.csv;

import java.io.IOException;

public class CsvReadAndWrite {

	 public static void main(String[] args) throws IOException, CsvException {

	        String fileName = "c:\\test\\csv\\country.csv";
	        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
	            List<String[]> r = reader.readAll();
	            r.forEach(x -> System.out.println(Arrays.toString(x)));
	        }

}
