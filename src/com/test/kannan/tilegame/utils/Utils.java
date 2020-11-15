package com.test.kannan.tilegame.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	
	public static String loadFileAsString(String path)  {
		StringBuilder builder = new StringBuilder();
		String line;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));

			while((line = br.readLine()) != null) 
				builder.append(line + "\n");
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
		
	}
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
