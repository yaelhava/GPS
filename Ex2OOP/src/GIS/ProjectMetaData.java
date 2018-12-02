package GIS;

import Geom.Point3D;

public class ProjectMetaData implements Meta_data{

	private String name;
	
	/**
	 * constructor
	 * @param name - the name of the project
	 */
	
	public ProjectMetaData(String name) {
	this.name = name;
	}
	
	/**
	 * getter for the name
	 * @return name - the name of the project
	 */
	
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
