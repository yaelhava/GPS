package Algorithms;

import java.io.File;
import java.io.PrintWriter;

import File_format.CSV2elements;
import File_format.Csv2kml;
import GIS.ProjectGIS;

public class MultiCSV {
	ProjectGIS p;
	String dir;
	Csv2kml csv2kml;

	public MultiCSV(String dir) { 
		this.dir = dir;
		p = new ProjectGIS();
		scan(dir);
	}
	public void scan(String path) {
		File folder = new File(path);
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				scan(file.getPath());
			}
			else if(file.getName().endsWith(".csv")) {
				CSV2elements e = new CSV2elements(file.getPath());
				p.add(e.getLayer());
			}

		}
		
	}

	public ProjectGIS getProject() {
		return p;
	}


	public void export() {
		csv2kml = new Csv2kml();
		StringBuilder s = csv2kml.exportKmlFile(p);
		try {
			PrintWriter export = new PrintWriter(new File("MyLovelyFile.kml"));
			export.write(s.toString());
			export.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
