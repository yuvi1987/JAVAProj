package Package;

public class FirstAssignment {
	
	static int x = 50;
	static int y = 30;
	int a;

	
	public void addition() {
		a = x+y;
		System.out.println("The Added Value is: " + a);
	}
	

	
	public static void main(String[] args) {

		FirstAssignment ins = new FirstAssignment();
		ins.addition();
		
		SubtractClass ins2 = new SubtractClass();
		ins2.subtraction();
		
	}

}

class SubtractClass{
	static int x = 50;
	static int y = 30;
	int b;
	public void subtraction() {
		b = x-y;
		System.out.println("The Subracted Value is: " + b);
	}
}

