public class Tutorial3{
	public static void main(String[] args){
		// Part 1:
		System.out.println("Test case: IDCard");
		IDCard c1 = new IDCard("Jack","123456");
		System.out.println(c1);
		IDCard c2 = new IDCard("Jack","123456");
		IDCard c3 = new IDCard("Mary","653456");
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));

		System.out.println("------------------");

	  // Part 2:
		System.out.println("Test case: CallingCard");
		CallingCard cc1 = new CallingCard("Hennry","123456",234);
		System.out.println(cc1);
		CallingCard cc2 = new CallingCard("Hennry","123456",234);
		CallingCard cc3 = new CallingCard("Mike","653456",234);
		System.out.println(cc1.equals(cc2));
		System.out.println(cc1.equals(cc3));
  

		System.out.println("------------------");

	  // Part 3:
		System.out.println("Test case: Driver");
		DriverLicense d1 = new DriverLicense("Jack","1001001",2026);
		System.out.println(d1);
		DriverLicense d2 = new DriverLicense("Jack","1001001",2026);
		DriverLicense d3 = new DriverLicense("Jack","1001002",2026);
		System.out.println(d2.equals(d1));
		System.out.println(d2.equals(d3));
	}
}


class Card{
	private String name;

	public Card(){
		name = "";
	}

	public Card(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
  
	@Override
	public String toString(){
		return "Card holder: " + name;
	}

	@Override
	public boolean equals(Object obj){
		Card another = (Card) obj;
		return name.equals(another.getName());
	}
}

class IDCard extends Card
{
	private String idNumber;

	public IDCard(String name, String id){
		super(name);
		this.idNumber = id;
	}

	public String getIDnumber(){
		return this.idNumber;
	}

	@Override
	public String toString(){
		return super.toString() + ", id: " + this.idNumber;
	}

	@Override
	public boolean equals(Object obj){
		IDCard other = (IDCard)obj;

		return super.equals(obj) && this.idNumber.equals(other.idNumber);
	}
}

class CallingCard extends Card
{
	private String cardNumber;
	private int pin;

	public CallingCard(String name, String number, int pin){
		super(name);
		this.cardNumber = number;
		this.pin = pin;
	}

	 

	public String getCardNumber() {
		return this.cardNumber;
	}

	@Override
	public String toString(){
		return super.toString() + ", card number: " + this.cardNumber + ", pin number: " + this.pin;
	}

	@Override
	// Note that we do not check the equality of pin numbers
	public boolean equals(Object obj){
		CallingCard other = (CallingCard)obj;

		return super.equals(obj) && this.cardNumber == other.cardNumber;
	}
}

class DriverLicense extends IDCard{
	private int expYear;

	public DriverLicense(String name, String id, int expYear)   {
		super(name, id);
		this.expYear = expYear;
	}
	
	public int getExpYear()
	{
		return expYear;
	}

  @Override
	public String toString(){
		return super.toString() + ", expiry date: " + this.expYear;
	}

	 @Override
	public boolean equals(Object obj){
		DriverLicense other = (DriverLicense)obj;

		return super.equals(obj) && this.expYear == other.expYear;
	}
	
}





