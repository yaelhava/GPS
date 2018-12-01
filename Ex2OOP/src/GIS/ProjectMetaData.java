package GIS;

import Geom.Point3D;

public class ProjectMetaData implements Meta_data{

	String name;
	
	public ProjectMetaData(String name) {
	this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public long getUTC() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}

}
