package GIS;

import Geom.Point3D;

	/**
	 * this class saves the data of a layer
	 * @author yael hava and naama hartuv
	 */

public class LayerMetaData implements Meta_data{
	
	private String name;
	
	/**
	 * constructor
	 * @param name - the name of the layer
	 */
	
	public LayerMetaData(String name) {
		this.name = name;
	}
	
	/**
	 * getter for the name
	 * @return - the name
	 */
	
	public String getName() {
		return this.name;
	}
	
	
	
	@Override
	public long getUTC() {
		return 0;
	}

	
	@Override
	public Point3D get_Orientation() {
		return null;
	}

}
