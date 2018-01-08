package org.iii.utils;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ApplicationUtils {

	private static final String LINE_BREAK = "\\r?\\n";

    public static File getDataSource(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return null; 
        } else {
            return file;
        }
    }

    public static String parseFile(File file) throws IOException {
        Scanner scanner = new Scanner(file);
		return scanner.useDelimiter("\\Z").next();
    }

    public static List<String> parseFromContent(String content) {
        if (content == null || content.trim().length() == 0) {
            return Collections.emptyList();
        } else {
            String[] lines = content.split(LINE_BREAK);
            return Arrays.asList(lines);
        }
    }
}
