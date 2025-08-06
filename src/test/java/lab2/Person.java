package lab2;

import lab3.Lab3_2AgeException;

public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		if(age<=15) {
			throw new Lab3_2AgeException("Age must be above 15");
		}
        this.name = name;
        this.age = age;
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
	

}
