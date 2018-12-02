package Geom;

	/**
	 * this class represents the coordinate of one element from the csv file
	 * @author yael hava and naama hartuv
	 */

public class ElementGeom implements Geom_element{

	private Point3D point;
	private String[] s;
	private double x;
	private double y;
	private double z;


	/**
	 * a constructor 
	 * @param a - is the line that contain the point
	 */

	public ElementGeom(String[] a) {
		this.s = a;
		x = Double.parseDouble(s[6]);
		y = Double.parseDouble(s[7]);
		z = Double.parseDouble(s[8]);
		point = new Point3D(x, y, z);
	}

	/**
	 * getter for x
	 * @return x
	 */
	
	public double getX() {
		return x;
	}

	/**
	 * getter for y
	 * @return y
	 */
	
	public double getY() {
		return y;
	}

	/**
	 * getter for z
	 * @return z
	 */
	
	public double getZ() {
		return z;
	}

	/**
	 * setter for x
	 * @return x
	 */
	
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * setter for y
	 * @return y
	 */
	
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * setter for z
	 * @return z
	 */
	
	public void setZ(double z) {
		this.z = z;
	}
	/**
	 * distance in 3D
	 * @param p - the point we get
	 * @return the distance between the point that we have and the point we get
	 */

	@Override
	public double distance3D(Point3D p) {
		return point.distance3D(p);
	}
	/**
	 * distance in 2D
	 * @param p - the point we get
	 * @return the distance between the point that we have and the point we get
	 */

	@Override
	public double distance2D(Point3D p) {
		return point.distance2D(p);
	}

}
