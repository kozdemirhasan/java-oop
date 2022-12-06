package de.kozdemir.uebung13;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyDirectory {

	private static String sdName;
	private static String ddName;
	private static String sdl;
	private static String ddl;

	public static void main(String[] args) {

		sdl = "D:\\aaa";
		sdName = sdl.substring(sdl.lastIndexOf("\\") + 1, sdl.length());
//		System.out.println(sdName);

		ddl = "C:\\bbb";
		ddName = ddl.substring(ddl.lastIndexOf("\\") + 1, ddl.length());
//		System.out.println(ddName);

		try {

			copyDirectory(sdl, ddl);

		} catch (FileAlreadyExistsException e) {
			System.out.println(ddName + " hat breits" + ddl);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void copyDirectory(String sourceDirectoryLocation, String destinationDirectoryLocation)
			throws IOException {
		Files.walk(Paths.get(sourceDirectoryLocation)).forEach(source -> {
			Path destination = Paths.get(destinationDirectoryLocation,
					source.toString().substring(sourceDirectoryLocation.length()));
			try {
				Files.copy(source, destination);
			} catch (IOException e) {
				System.out.println(ddName + " hat breits" + ddl);
				e.printStackTrace();
			}
		});
	}

}
