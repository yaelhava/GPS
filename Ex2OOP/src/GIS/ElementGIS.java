package GIS;

import Coords.MyCoords;
import Geom.ElementGeom;
import Geom.Geom_element;
import Geom.Point3D;

public class ElementGIS implements GIS_element {

	metaDataGIS data;
	ElementGeom point;
	MyCoords coords;
	
	public ElementGIS(metaDataGIS data,ElementGeom point) {
		this.data = data;
		this.point = point;
	}
	
	@Override
	public Geom_element getGeom() {
		return point;
	}

	@Override
	public Meta_data getData() {
		return data;
	}

	@Override
	public void translate(Point3D vec) { 
		Point3D p = new Point3D(point.getX(), point.getY(),point.getZ());
		p = coords.add(p, vec);
		point.setX(p.x());
		point.setY(p.y());
		point.setZ(p.z());
	}

}
