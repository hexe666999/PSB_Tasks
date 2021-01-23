package com.company;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws ParseException, IOException {

		if(args.length == 0){
			System.out.println("Please add paths for input and output Data in program arguments");
			System.exit(-1);
		}

		ArrayList<LogObject> logObjects = LogProcessor.processor(new File(args[0]));

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(args[1])));

		bufferedWriter.write("1) Most used methods:");
		bufferedWriter.write(System.lineSeparator());
		FindApiFunction.printMap(FindApiFunction.findMostUsedApiFunctions(logObjects), bufferedWriter);

		bufferedWriter.write("2) Busiest host - ");
		FindMaxUsedHost.findFirstLastConnectionTime(logObjects, bufferedWriter
		);
		bufferedWriter.write("3) Busiest minute -");
		BusiestMinuteFinder.findBusiestMinute(logObjects, bufferedWriter);

		bufferedWriter.flush();
		bufferedWriter.close();


	}

}

