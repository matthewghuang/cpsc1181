public class Point3DTester{
	public static void main(String[] args){
		Point3D p1 = new Point3D();
		Point3D p2 = new Point3D(10,12,25);
		p1.move(25,35,85);
		p2.setX(5);
		p2.setY(10);
		p2.setZ(15);
		
		System.out.println(p1);
		System.out.println(p2);
	}
}