import java.util.Random;
// All casses have package access
public class GeometricShapeTester{
	
	private GeometricShape[] shapes;
	public static void main(String[] args){
		GeometricShapeTester shapeTester = new GeometricShapeTester();
		System.out.println("\nTest case 1:");
		double average = shapeTester.findAverage();
		System.out.println("average: "+Math.round(average));
		
		System.out.println("\nTest case 2:");
		GeometricShape s = shapeTester.getMax();
		System.out.println(s);


		GeometricShape[] shapes = shapeTester.getShapes();
		System.out.println("\nTest case 3:");
		System.out.println("list of the shapes:");
		for(GeometricShape e:shapes)
			System.out.println(e);

		System.out.println("\nTest case 4:");
		shapeTester.sort();
		System.out.println("shapes sorted in ascending order based on their area:");
		for(GeometricShape e:shapes)
			System.out.println(e);

	}
	public GeometricShapeTester(){
		shapes = new GeometricShape[20];
		Random rand = new Random();
		int option;
		final int COORD = 50;
		final int LENGTH1 = 50;
		final int LENGTH2 = 100;
		for(int i=0; i<shapes.length; i++){
			option=rand.nextInt(4);
			switch(option){
				case 0:
				shapes[i]= new Rectangle(
								rand.nextInt(COORD),
								rand.nextInt(COORD),
								rand.nextInt(LENGTH2),
								rand.nextInt(LENGTH2));
				break;
				case 1:
				shapes[i]= new Square(
								rand.nextInt(COORD),
								rand.nextInt(COORD),
								rand.nextInt(LENGTH2));
				break;
				case 2:
				shapes[i]= new Oval(
								rand.nextInt(COORD),
								rand.nextInt(COORD),
								rand.nextInt(LENGTH1),
								rand.nextInt(LENGTH2));
				break;
				case 3:
				shapes[i]= new Circle(
								rand.nextInt(COORD),
								rand.nextInt(COORD),
								rand.nextInt(LENGTH1));
			}
		}	
	}
	public double findAverage(){
		if (shapes.length == 0) {
			return 0;
		}

		double average = 0;

		for (GeometricShape s : shapes) {
			average += s.getArea();
		}

		average /= shapes.length;

		return average;
	}
	public GeometricShape getMax(){
		if (shapes.length == 0) {
			return null;
		}

		GeometricShape min = shapes[0];

		for (GeometricShape s : shapes) {
			if (s.getArea() < min.getArea()) {
				min = s;
			}
		}

		return min;
	}
	public void sort(){
		for (int i = 0; i < shapes.length; i++) {
			int smallest_i = -1;

			for (int j = i + 1; j < shapes.length; j++) {
				if (smallest_i == -1 || shapes[j].getArea() < shapes[smallest_i].getArea()) {
					smallest_i = j;
				}
			}

			if (smallest_i != -1 && shapes[smallest_i].getArea() < shapes[i].getArea()) {
				GeometricShape tmp = shapes[smallest_i];
				shapes[smallest_i] = shapes[i];
				shapes[i] = tmp;
			}
		}
	}

	public GeometricShape[] getShapes(){
		return shapes;
	}
}


