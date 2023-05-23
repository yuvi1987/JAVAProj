package Package;

class FirstAssignment {
	
	static int x = 50;
	static int y = 30;
	int a;
	int b;
	
	public void addition() {
		a = x+y;
		System.out.println("The Added Value is: " + a);
	}
	
	public void subtraction() {
		b = x-y;
		System.out.println("The Subracted Value is: " + b);
	}
	
	public static void main(String[] args) {

		FirstAssignment ins = new FirstAssignment();
		ins.addition();
		
		FirstAssignment ins2 = new FirstAssignment();
		ins2.subtraction();
		
	}

}

