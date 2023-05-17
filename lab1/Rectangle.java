/**
	class Rectangle defines a rectangle with width and height
*/
public class Rectangle{
	// instance fields
	private double height;
	private double width;

	// constructors
	//----------------

	/** 
		default constructor
		Constructs a new Rectangle with height and width equal to 0
	*/
	public Rectangle(){
		this.height = 0.0;
		this.width = 0.0;	
	}
	/** 
		Constructs a new Rectangle with height and width equal to given width and height

		@param w width of the rectangle
		@param h height of the rectangle
	*/
	public Rectangle(double h, double w){
		height = h;
		width = w;
	}

	// accessor methods
	//----------------

	/** 
		@return  returns the width of the rectangle
	*/
	public double getWidth(){
		return this.width;	
	}
	/** 
		@return  returns the height of the rectangle
	*/
	public double getHeight(){
		return this.height;	
	}
	/** 
		@return  returns the area of the rectangle
	*/
	public double getArea(){
		return this.width * this.height;	
	}
	/** 
		@return  returns the circumference of the rectangle
	*/
	public double getCircumference(){
		return 2 * (this.width + this.height);
	}


	// mutator methods
	//----------------

	/** 
		@param w sets the width of the rectangle
	*/
	public void setWidth(int w){
		this.width = w;	
	}
	/** 
		@param h sets the height of the rectangle
	*/
	public void setHeight(int h){
		this.height = h;	
	}
}