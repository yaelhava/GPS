package GIS;

import Geom.Point3D;

public class LayerMetaData implements Meta_data{
	
	String name;
	
	
	public LayerMetaData(String name) {
		this.name = name;
	}
	
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
