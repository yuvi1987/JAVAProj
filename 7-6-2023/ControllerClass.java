package com.dal.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
	public void LoadEmployeToList() {
		list = empdao.LoadEmployee();
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
	public void WriteIntoFile() {
		//Serialization
		try {
				FileOutputStream fo = new FileOutputStream("Employee.txt");
				ObjectOutputStream obj = new ObjectOutputStream(fo);
				
					obj.writeObject(list);
					System.out.println("Object write in to file - Serialization");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	@SuppressWarnings("unchecked")
	public void GetDataFromFile() {
		//DeSerialization
		FileInputStream fi=null;
		try {
			fi = new FileInputStream("Employee.txt");
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectInputStream ip=null;
		try {
			ip = new ObjectInputStream(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		List<ModelClass> lv1=null;
		try {
			lv1 = (ArrayList<ModelClass>) ip.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Get from file - Deserializatin");
 		System.out.println(lv1);
 	
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
   
    public void SortEmployee() {
    	Collections.sort(list);
    	System.out.println(list);
    }
    
    public void SortEmployeeNoComparator() {
    	Collections.sort(list, ModelClass.empnumberComparator);
    	System.out.println(list);
    }
    public void SortEmpNameComparator() {
    	Collections.sort(list, ModelClass.empnameComparator);
    	System.out.println(list);
    }
}
