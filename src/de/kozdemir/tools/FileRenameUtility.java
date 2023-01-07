package de.kozdemir.tools;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileRenameUtility {
//	public static void main(String[] a) {
//		System.out.println("FileRenameUtility");
//		FileRenameUtility renameUtility = new FileRenameUtility();
//		renameUtility.fileRename("L:\\WBS LearnSpace 3D VIDEOS");
////	renameUtility.fileRename("G:\\");
//	}
//
//	private void fileRename(String folder) {
//		File file = new File(folder);
//		System.out.println("Reading this " + file.toString());
//		if (file.isDirectory()) {
//			File[] files = file.listFiles();
//			List<File> filelist = Arrays.asList(files);
//			filelist.forEach(f -> {
//				if (!f.isDirectory() && (f.getName().lastIndexOf("_Trim") > 0)) {
//					System.out.println(f.getAbsolutePath());
//					String newName = f.getAbsolutePath().replace(f.getName(), f.getName().replaceAll("_Trim", ""));
//					boolean isRenamed = f.renameTo(new File(newName));
//					if (isRenamed)
//						System.out.println(String.format("Renamed this file %s to  %s", f.getName(), newName));
//					else
//						System.out.println(String.format("%s file is not renamed to %s", f.getName(), newName));
//				}
//			});
//
//		}
//	}
//}
	

	public static void main(String[] a) {
		System.out.println("FileRenameUtility");
		FileRenameUtility renameUtility = new FileRenameUtility();
		renameUtility.fileRename("L:\\WBS LearnSpace 3D VIDEOS");
	}

	private void fileRename(String folder) {
		File file = new File(folder);
		System.out.println("Reading this " + file.toString());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			List<File> filelist = Arrays.asList(files);
			filelist.forEach(f -> {
				if (!f.isDirectory() && f.getName().startsWith("WBS LearnSpace 3D ")) {
					System.out.println(f.getAbsolutePath());
					String newName = f.getAbsolutePath().replace(f.getName(), f.getName().substring(18));
					boolean isRenamed = f.renameTo(new File(newName));
					if (isRenamed)
						System.out.println(String.format("Renamed this file %s to  %s", f.getName(), newName));
					else
						System.out.println(String.format("%s file is not renamed to %s", f.getName(), newName));
				}
			});

		}
	}
}