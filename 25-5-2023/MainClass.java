package com.dal.view;
import com.dal.controller.ControllerClass;
import java.util.function.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.util.*;
import java.awt.print.PrinterGraphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import com.dal.Exception.*;
import com.dal.Model.ModelClass;
public class MainClass {

	
	public static void main(String[] args) {
		try {
		System.out.println("Welcome to EMS :)");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(isr);
		System.out.println("Enter user name");
		String usr = bf.readLine();
		System.out.println("Enter password");
		String pass = bf.readLine();
		System.out.println("Please wait loading...");
		Thread.sleep(3000);
		//BiPredicate
		BiPredicate<String, String> usrpass = (u,p) ->{
			 return (u.equals("sara") && p.equals("May"));
		};
		if(!usrpass.test(usr,pass))
		{
			throw new UserNotFound();
		}
		
		ControllerClass cc = new ControllerClass();
		cc.LoadEmployeToList();
		Scanner sc = new Scanner(System.in);
		String co = null;
		do {
			
			System.out.println("Enter your choice");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Get Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Sort Employee by EmpNo");
			System.out.println("7. Sort Employee by EmpNo Comparator");
			System.out.println("8. Sort Employee by EmpName Comparator");
			System.out.println("9. Serialization");
			System.out.println("10. DeSerialization");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter employee number");
				int eno = Integer.parseInt(bf.readLine());
				System.out.println("Enter emplyee name");
				String enam = bf.readLine();
				cc.addEmployee(eno,enam);
				break;
			case 2:
				cc.ViewEmployee();
				break;
			case 3:
				List<ModelClass> li =cc.GetEmployee();
				li.forEach(e-> System.out.println(e));
				break;
			case 4:
				System.out.println("Enter update employee number");
				   eno = Integer.parseInt(bf.readLine());
				System.out.println("Enter update employee name");
				   enam = bf.readLine();
				cc.UpdateEmplyee(eno, enam);
				break;
			case 5:
				System.out.println("Enter delete employee number");
				eno = Integer.parseInt(bf.readLine());
				cc.DeleteEmployee(eno);
				break;
			case 6:
				cc.SortEmployee();
				break;
			case 7:
				cc.SortEmployeeNoComparator();
				break;
			case 8:
				cc.SortEmpNameComparator();
				break;
			case 9:
				cc.WriteIntoFile();
				break;
			case 10:
				cc.GetDataFromFile();
				break;
			default:
				System.out.println("Enter valid number");
				break;
			}
			System.out.println("Do you want to continue y/n");
			co = sc.next();
			
		}while(co.equals("y") || co.equals("Y"));
		}
		catch(UserNotFound un) {
			un.printStackTrace();
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Exit Application");
		System.exit(0);
			
		
	}

}
