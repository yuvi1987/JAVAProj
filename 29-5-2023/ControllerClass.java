package com.dal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.dal.Model.ModelClass;
//import java.util.Scanner;
public class ControllerClass {
    //	Scanner sc = new Scanner();
	List<ModelClass> list = new ArrayList<>();
	//ModelClass mc;// = new ModelClass();
	//Consumer<ModelClass> mc1 = m -> System.out.println(m);
	//Supplier<ModelClass> gs = ()-> {return mc;}; 
	//Consumer
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
		
		list.add(new ModelClass(Empno,Empname));
		
				
	}
    public void ViewEmployee()
    {
    	conlst.accept(list);
    	//System.out.println("Employe Name:"+mc.getEmpName());
		//System.out.println("Employee No:"+mc.getEmpNo());
    	//mc1.accept(mc);
    }
    public List<ModelClass> GetEmployee() {
    	//System.out.println(gs.get());
    	//gs.get().forEach(e->System.out.println(e););
    	return suplst.get();
    }
    	
    
}
