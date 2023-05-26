package MulInter;

public interface InterSample {

}

interface ISample1{
	public void Test1();
}
interface ISample2 {
	public void Test2();
}
interface ISample3 extends ISample1,ISample2{
	public void Test3();
}
