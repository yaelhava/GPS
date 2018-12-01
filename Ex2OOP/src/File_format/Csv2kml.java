package File_format;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.text.AbstractDocument.Content;

import Algorithms.MultiCSV;
import GIS.ElementGIS;
import GIS.GIS_layer;
import GIS.GIS_project;
import GIS.LayerGIS;
import GIS.Meta_data;
import GIS.ProjectGIS;
import GIS.metaDataGIS;
import Geom.ElementGeom;

public class Csv2kml {

	MultiCSV multiProject;
	ElementGIS element;
	LayerGIS layer;
	StringBuilder content;

	
	public StringBuilder exportKmlFile(ProjectGIS project) {
	//	multiProject = new MultiCSV(path);
	//	project = multiProject.getProject();
		//ArrayList<String> content = new ArrayList<String>();
		content = new StringBuilder();
		
		String kmlProjectStart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n" +
				"<Document>\n" +
				"<Style id=\"red\"><IconStyle>\r\n" + 
				"<Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href>\r\n" + 
				"</Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle>\r\n" + 
				"<Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href>\r\n" +
				"</Icon></IconStyle></Style><Style id=\"green\"><IconStyle>\r\n" +
				"<Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href>\r\n" +
				"</Icon></IconStyle></Style>\n";

		content.append(kmlProjectStart);
		
		Iterator itLayer = project.iterator();
		while(itLayer.hasNext()) {
			String kmlLayerStart = "<Folder>\n";
			content.append(kmlLayerStart);
			layer = (LayerGIS) itLayer.next();
			Iterator itElement = layer.iterator();
			while(itElement.hasNext()) {
				element = (ElementGIS) itElement.next();
				metaDataGIS metaDataElement = (metaDataGIS) element.getData();
				ElementGeom geom = (ElementGeom) element.getGeom();
				
				String kmlElement = "<Placemark>\n" +
						"<name>" + metaDataElement.getSSID() +"</name>\n" +
						"<description>" + metaDataElement.getType() + ", " + metaDataElement.getAccuracyMeters()+"</description>\n" +
						"<Point>\n" +
						"<coordinates>" + geom.getY() + ", " + geom.getX() + "</coordinates>" +
						"</Point>\n" +
						"<TimeStamp>\n" + 
						"<when>" + metaDataElement.getFirstSeen() + "</when>" + 
						"</TimeStamp>\n" +
						"</Placemark>\n";
				content.append(kmlElement);
			}
			String kmlLayerEnd = "</Folder>\n";
			content.append(kmlLayerEnd);
		}

		String kmlProjectEnd = "</Document>\n" + 
							   "</kml>"; 
		content.append(kmlProjectEnd);
		return content;
	}
	
}
