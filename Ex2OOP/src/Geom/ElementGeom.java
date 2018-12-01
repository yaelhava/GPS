package Geom;

public class ElementGeom implements Geom_element{

	Point3D point;
	String[] s;
	double x;
	double y;
	double z;


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

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

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
