package GIS;

import Coords.MyCoords;
import Geom.ElementGeom;
import Geom.Geom_element;
import Geom.Point3D;

	/**
	 * this class represents the lines from the csv file, one line is element.
	 * @author yael hava and naama hartuv
	 */

public class ElementGIS implements GIS_element {

	private metaDataGIS data;
	private ElementGeom point;
	private MyCoords coords;
	
	/**
	 * constructor
	 * @param data - the data in one line
	 * @param point	- the coordinate of one line
	 */
	
	public ElementGIS(metaDataGIS data,ElementGeom point) {
		this.data = data;
		this.point = point;
	}
	
	/**
	 * @return point - the coordinate
	 */
	
	@Override
	public Geom_element getGeom() {
		return point;
	}

	/**
	 * @return data - the data of one line
	 */
	
	@Override
	public Meta_data getData() {
		return data;
	}

	/**
	 * computes a point which is the element point transformed by a 3D vector (in meters)
	 * @param vec - the 3D vector in meters
	 */
	
	@Override
	public void translate(Point3D vec) { 
		Point3D p = new Point3D(point.getX(), point.getY(),point.getZ());
		p = coords.add(p, vec);
		point.setX(p.x());
		point.setY(p.y());
		point.setZ(p.z());
	}

}
