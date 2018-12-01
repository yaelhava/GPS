package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CSVreader {
	String path;
	
	
	public CSVreader(String path) {
		this.path = path;
	}

	
	public ArrayList<String[]> CSVReader()  {
		ArrayList<String[]> list = new ArrayList<String[]>();
		String csvFile = path;
		String line = "";
		String cvsSplitBy = ",";



		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
		{
			int counter =0;
			while ((line = br.readLine()) != null) {
				if(counter>0) {
					String[] userInfo = line.split(cvsSplitBy);
					list.add(userInfo);
				}
				counter++;

				//				if(counter > 1)
				//				System.out.println("MAC:" + userInfo[0] + " , SSID: " + userInfo[1] +
				//						" AuthMode: " + userInfo[2] + " FirstSeen: " 
				//						+ userInfo[3] + "Channel: " + userInfo[4]+ "RSSI: " + userInfo[5]
				//								+ "CurrentLatitude: " + userInfo[6]+ "CurrentLongitude: " + userInfo[7] +
				//								"AltitudeMeters: " + userInfo[8]+ "AltitudeMeters: " + userInfo[9]
				//										+ "Type: " + userInfo[10]);
			}

		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return list;
	}


	}