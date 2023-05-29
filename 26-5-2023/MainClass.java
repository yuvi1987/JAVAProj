package mypack;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.Serializable;

import com.dedalus.controller.EmployeeController;
import com.dedalus.controller.EmployeeInterface;
import com.dedalus.exception.UserNotFoundException;


public class MainClass implements Serializable {

	public static void main(String[] args) {
		System.out.println("Welcome to EMS :)");
		EmployeeController ec = new EmployeeController();
		Scanner sc = new Scanner(System.in);
		String ch=null;
		try {
			String un = null;
			String pwd = null;

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter Username");
			un = br.readLine();
			System.out.println("Enter Password");
			pwd = br.readLine();

			if (un.equals("Gokul") && pwd.equals("12345")) {
				System.out.println("Welcome " + un);
		
		do {
		System.out.println("Enter your choice");
		System.out.println("1. Add Employee");
		System.out.println("2. View Employee");
		System.out.println("3. Serialize");
        System.out.println("4. Deserialize");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:{
			try {
			System.out.println("Loading... Please wait.");
            Thread.sleep(2000);}
			catch (InterruptedException e) {	
				ec.addEmployee();
				e.printStackTrace();
			}			
			break;
		}

		case 2: {
			try {
			System.out.println("Loading... Please wait.");
            Thread.sleep(2000);}
			catch (InterruptedException e) {
			ec.viewEmployee();
			e.printStackTrace();
			}			
			break;
		}

        case 3: {
            try {
                FileOutputStream fileOut = new FileOutputStream("mainObject.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(ec); 
                out.close();
                fileOut.close();
                System.out.println("Serialized data is saved in mainObject.ser");
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            break;
        }

        case 4: {
            try {
                FileInputStream fileIn = new FileInputStream("mainObject.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                EmployeeController deserializedEc = (EmployeeController) in.readObject(); 
                in.close();
                fileIn.close();
                System.out.println("Loading... Please wait.");
                Thread.sleep(2000);
                deserializedEc.viewEmployee(); 
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            break;
        }

        default: {
            System.out.println("Enter a valid number");
            break;
        }
    }

    System.out.println("Do u want to continue Y | y");
    ch = sc.next();

} while (ch.equals("Y") || ch.equals("y"));
System.out.println("Thanks for using our system.");
System.exit(0);
} else {
throw new UserNotFoundException();
}

} catch (UserNotFoundException unf) {
unf.printStackTrace();
} catch (Exception ae) {
System.out.println("IO");
} finally {
System.out.println("Finally .....");
}
System.out.println("Main Ends");
}
} 
