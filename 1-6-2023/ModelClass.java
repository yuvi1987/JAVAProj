package com.dal.Model;

import java.util.Comparator;

public class ModelClass implements Comparable<ModelClass> {

	 String empname;
	 int empno;
//	public ModelClass() {
//		super();
//	}
	public ModelClass(int EmpNo, String EmpName) {
		//super();
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
	public int compareTo(ModelClass o) {
		// TODO Auto-generated method stub
		return this.empno - o.empno;
	}
	
	@Override
	public String toString() {
		return "ModelClass [empname=" + empname + ", empno=" + empno + "]";
	}

	public static Comparator<ModelClass> empnumberComparator = new Comparator<ModelClass>() {
		
		@Override
		public int compare(ModelClass o1, ModelClass o2) {
			// TODO Auto-generated method stub
			return o1.empno - o2.empno;
		}
	};
	
	public static Comparator<ModelClass> empnameComparator =(o1, o2) -> o1.getEmpName().compareTo(o2.getEmpName()) ;

}


