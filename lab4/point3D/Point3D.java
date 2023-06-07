public class Point3D extends Point2D{
	private double z;
	public Point3D(){
		super(); // call super class constructor
		z=0;
	}
	public Point3D(double x, double y, double z){
		super(x,y);// must be first statement
		this.z = z;
	}

	public void move(double x, double y, double z){
		super.move(x,y);
		this.z = z;

	}
	public double getZ(){
		return z;
	}
	public void setZ(double z){
		this.z = z;
	}
	@Override
	public String toString(){
		return super.toString()+", z: "+ z;
	}
	
}