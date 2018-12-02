package File_format;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.html.HTMLDocument.Iterator;

import GIS.ElementGIS;
import GIS.LayerGIS;
import GIS.metaDataGIS;
import Geom.ElementGeom;

	/**
	 * this class takes a csv file and inserts every line to an element object.
	 * @author yael hava and naama hartuv
	 */

public class CSV2elements 
{
	private String path;
	private LayerGIS l;

	/**
	 * constructor
	 * @param path - the given cvs file's path
	 */
	
	public CSV2elements(String path) {
		this.path = path;
		l = new LayerGIS();
		toElem();
	}

	/**
	 * create an array list with elements and add any element to a layer.
	 */
	
	private void toElem() {
		CSVreader r = new CSVreader(path);
		ArrayList<String[]> arr = r.CSVReader();

		for(int i=1; i<arr.size(); i++) {
			l.add(toElem(arr.get(i)));
		}
	}

	/**
	 * enters data and coordinate to a created element.
	 * @param arr - the line
	 * @return e - the element with the data and the coordinate
	 */
	
	private ElementGIS toElem(String arr[]) {
		metaDataGIS data = new metaDataGIS(arr);
		ElementGeom point = new ElementGeom(arr);
		ElementGIS e = new ElementGIS(data, point);
		return e;
	}

	/**
	 * getter for the layer created at this class
	 * @return l - the layer
	 */
	
	public LayerGIS getLayer() {
		return l;
	}

}




