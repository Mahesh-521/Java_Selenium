package lab2.com.cg.eis.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lab2.com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public String getInsuranceScheme(Employee emp) {
		double salary = emp.getSalary();
        String designation = emp.getDesignation().toLowerCase();

        if (salary >= 50000 && designation.equals("manager")) {
            return "Scheme A";
        } else if (salary >= 30000 && designation.equals("developer")) {
            return "Scheme B";
        } else if (salary >= 20000 && designation.equals("clerk")) {
            return "Scheme C";
        } else {
            return "No Scheme";
        }
	}

	@Override
	public void displayEmployeeDetails(Employee emp) {
		System.out.println("Employee Details : ");	
		System.out.println("Employee ID : "+emp.getId());
		System.out.println("Employee Name : "+emp.getName());
		System.out.println("Employee Salary : "+emp.getSalary());
		System.out.println("Employee Designation : "+emp.getDesignation());
		System.out.println("Employee Scheme : "+emp.getInsuranceScheme());
	}
	
	public static void writeEmployeeDetailsToFile(List<Employee> employees) {
		
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("employee.txt"))){
			
			for(Employee e:employees) {
				bw.write(e.toString());
				bw.newLine();
			}
			System.out.println("Written to file");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<Employee> readEmployeeDetailsFromFile(){
		List<Employee> employees=new ArrayList<Employee>();
		try(BufferedReader br=new BufferedReader(new FileReader("employee.txt"))){
			String line;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			System.out.println("Reading data from file");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return employees;
	}

}
