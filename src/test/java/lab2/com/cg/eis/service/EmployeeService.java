package lab2.com.cg.eis.service;

import lab2.com.cg.eis.bean.Employee;

public interface EmployeeService {
	
	String getInsuranceScheme(Employee emp);
    void displayEmployeeDetails(Employee emp);

}
