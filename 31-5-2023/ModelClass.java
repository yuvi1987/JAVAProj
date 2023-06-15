package com.dal.Model;

public class ModelClass {
	String empname;
	int empno;
	public ModelClass() {
		
	}
	public ModelClass(int EmpNo, String EmpName) {
		this.empno = EmpNo;
		this.empname = EmpName;
	}
	public void setEmpNo(int EmpNo)
	{
		this.empno = EmpNo;
	}
	
	public void setEmpName(String EmpName)
	{
		this.empname = EmpName;
	}
	
	public int getEmpNo() {
		return empno;
	}

	public String getEmpName()
	{
		return empname;
	}

	
	@Override
	public String toString() {
		return "ModelClass [empname=" + empname + ", empno=" + empno + "]";
	}

	

}


