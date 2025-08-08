package lab4;

import java.util.ArrayList;

import lab2.com.cg.eis.bean.Employee;
import lab2.com.cg.eis.service.EmployeeServiceImpl;

public class Lab4_3 {

	public static void main(String[] args) {

		Employee e1=new Employee(1, "mahesh", 23000, "developer");
		Employee e2=new Employee(2, "rahul", 18000, "tester");
		Employee e3=new Employee(3, "sai", 15000, "developer");
		
		ArrayList<Employee> list=new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		EmployeeServiceImpl.writeEmployeeDetailsToFile(list);
		
		EmployeeServiceImpl.readEmployeeDetailsFromFile();
		

	}

}
