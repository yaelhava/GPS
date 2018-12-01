package File_format;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.html.HTMLDocument.Iterator;

import GIS.ElementGIS;
import GIS.LayerGIS;
import GIS.metaDataGIS;
import Geom.ElementGeom;

public class CSV2elements 
{
	private String path;
	private LayerGIS l;

	public CSV2elements(String path) {
		this.path = path;
		l = new LayerGIS();
		toElem();
	}

	private void toElem() {
		CSVreader r = new CSVreader(path);
		ArrayList<String[]> arr = r.CSVReader();

		for(int i=1; i<arr.size(); i++) {
			l.add(toElem(arr.get(i)));
		}
	}

	private ElementGIS toElem(String arr[]) {
		metaDataGIS data = new metaDataGIS(arr);
		ElementGeom point = new ElementGeom(arr);
		ElementGIS e = new ElementGIS(data, point);
		return e;
	}

	public LayerGIS getLayer() {
		return l;
	}

}




