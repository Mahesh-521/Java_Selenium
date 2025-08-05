package lab2.com.cg.eis.pl;

import lab2.com.cg.eis.bean.Employee;
import lab2.com.cg.eis.service.EmployeeServiceImpl;

public class Lab2_3 {

	public static void main(String[] args) {

		Employee emp = new Employee(1, "mahesh", 35000, "Developer");
		
		EmployeeServiceImpl service=new EmployeeServiceImpl();
		
		String scheme=service.getInsuranceScheme(emp);
		emp.setInsuranceScheme(scheme);
		
		service.displayEmployeeDetails(emp);
		

	}

}
