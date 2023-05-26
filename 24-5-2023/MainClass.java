package MulInter;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntClass obj = new IntClass();
		obj.Test1();
		obj.Test2();
		obj.Test3();
	}

}
class IntClass implements ISample3{
	public void Test1() {
		System.out.println("Test1 implementation");
	}
	public void Test2() {
		System.out.println("Test2 implementation");
	}
	public void Test3() {
		System.out.println("Test3 implementation");
	}
}