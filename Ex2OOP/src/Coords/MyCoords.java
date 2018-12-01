package Coords;

import java.util.Arrays;

import Geom.Point3D;

public class MyCoords implements coords_converter{
	private final int EarthRadius = 6371000;
	private  double lonNorm;

	private double x;		//לא בטוח שצריך ף עשינו אולי רק בשביל המיין
	private double y;
	private double z;

	

	public MyCoords(int i, int j, int k) {
		this.x = i;
		this.y = j;
		this.z = k;
	}
	/** 
	 * computes a new point which is the gps point transformed by a 3D vector (in meters)
	 * @param gps: the gps point
	 * @param local_vector_in_meter: the vector value in mater
	 * @return p: the new point after adding the vector to the gps
	 */

	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		double x= ((Math.asin(local_vector_in_meter.x()/EarthRadius))/Math.PI)*180;
		lonNorm = Math.cos((gps.x() * Math.PI)/180);
		double y= ((Math.asin(local_vector_in_meter.y()/(EarthRadius*lonNorm)))/Math.PI)*180;
		double z= local_vector_in_meter.z();
		Point3D p= new Point3D(x + gps.x(),y + gps.y(),z + gps.z());


		return p;
	}
	/**
	 *  computes the 3D distance (in meters) between the two gps like points
	 *  @param gps0 - the first point
	 *  @param gps1 - the second point
	 *  @return the distance between the two points
	 */

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		double distance = 0;
		double x = Math.sin(Math.PI * (gps1.x() - gps0.x()) /180) * EarthRadius;
		lonNorm = Math.cos((gps0.x() * Math.PI)/180);
		double y = Math.sin(Math.PI * (gps1.y() - gps0.y()) /180) * EarthRadius * lonNorm;
		
		distance = Math.sqrt(x*x + y*y);
		return distance;
	}

	/**
	 *  computes the 3D vector (in meters) between two gps like points
	 *  @param gps0 - the first point
	 *  @param gps1 - the second point  
	 *  @return the vector between the two points
	 */

	
	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		double x = Math.sin(Math.PI * (gps1.x() - gps0.x()) /180) * EarthRadius;
		lonNorm = Math.cos((gps0.x() * Math.PI)/180);
		double y = Math.sin(Math.PI * (gps1.y() - gps0.y()) /180) * EarthRadius * lonNorm;
		double z = gps1.z() - gps0.z();
		Point3D vectorInMeter = new Point3D(x, y, z);		
		return vectorInMeter;
	}

	/** computes the polar representation of the 3D vector be gps0-->gps1 
	 *	@param gps0 - the first point
	 *  @param gps1 - the second point  
	 *  @return the azimuth between the two points
	 */
	
	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double[] azimuth = new double[3];
		double radianGps0_x = Math.toRadians(gps0.x());
		double radianGps0_y = Math.toRadians(gps0.y());
		double radianGps1_x = Math.toRadians(gps1.x());
		double radianGps1_y = Math.toRadians(gps1.y());
		
		Point3D p0 = new Point3D(radianGps0_x, radianGps0_y, gps0.z());
		Point3D p1 = new Point3D(radianGps1_x, radianGps1_y, gps1.z());

		
		azimuth[0] = gps0.angleXY(p1);
		azimuth[1] = gps0.angleZ(gps1);
		azimuth[2] = gps0.distance2D(gps1);
		return azimuth;
	}

	/**
	 * return true if this point is a valid lat, lon, alt coordinate: [-180,+180],[-90,+90],[-450, +inf]
	 * @param p - the point to check if is in the valid range
	 * @return true if is in the range false if not
	 */
	
	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		// TODO Auto-generated method stub
		return false;
	}


	public String toString() {
		return "(" + this.x + "," + this.y + "," + this.z + ")";
	}


	public static void main (String[]arg) {//לא לשכוח למחוק1!!!!!!!!!!!!!!!!!!1
		Point3D v= new Point3D (337.6989921, -359.2492069,-20 );
		Point3D p0= new Point3D (32.103315,35.209039,670);
		MyCoords n= new MyCoords (0,0,0);
		MyCoords nn= new MyCoords (0,0,0);

		Point3D p1= n.add(p0, v);
		System.out.println("add: " + n.add(p0, v));
		System.out.println("dis: " + n.distance3d(p0, p1));
		
		System.out.println("vector meter: " + n.vector3D(p0, p1));
		System.out.println("azimuth: " +  Arrays.toString(nn.azimuth_elevation_dist(p0, p1)));
	}
}