package com.dal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.dal.Model.ModelClass;
import com.dal.dao.EmployeeDAO;
//import java.util.Scanner;
public class ControllerClass {
    //	Scanner sc = new Scanner();
	List<ModelClass> list = new ArrayList<>();
	ModelClass mc;// = new ModelClass();
	//Consumer<ModelClass> mc1 = m -> System.out.println(m);
	//Supplier<ModelClass> gs = ()-> {return mc;}; 
	//Consumer
	EmployeeDAO empdao = new EmployeeDAO();
	Consumer<List<ModelClass>> conlst = li->{
		 li.forEach(e ->System.out.println(e));
	 };
	 //Supplier
	 Supplier<List<ModelClass>> suplst =()->{return list;}; 
	public void addEmployee(int Empno, String Empname)
	{
		//	sc.nextLine();
		//mc.setEmpName("Arya"); 
		//mc.setEmpNo(101);
		 mc = new ModelClass(Empno,Empname); 
		list.add(mc);
		empdao.InsertEmployee(mc);
		
				
	}
	public void UpdateEmplyee(int Empno,String Empname) {
		mc=new ModelClass(Empno,Empname);
		
		for(int index=0;index<list.size();index++)
		{
			if(list.get(index).getEmpNo() == Empno)
			{
				list.set(index, mc);
				break;
			}
			
		}
		empdao.UpdateEmployee(mc);
	}
	public void DeleteEmployee(int Empno) {
		
		for(int index=0;index<list.size();index++)
		{
			if(list.get(index).getEmpNo() == Empno)
			{
				list.remove(index);
				break;
			}
			
		}
		empdao.DeleteEmployee(Empno);
	}
    public void ViewEmployee()
    {
    	conlst.accept(list);
    	//System.out.println("Employe Name:"+mc.getEmpName());
		//System.out.println("Employee No:"+mc.getEmpNo());
    	//mc1.accept(mc);
    	System.out.println("Data from DB");
    	empdao.ShowEmployee();
    }
    public List<ModelClass> GetEmployee() {
    	//System.out.println(gs.get());
    	//gs.get().forEach(e->System.out.println(e););
    	return suplst.get();
    }
    	
    
}
