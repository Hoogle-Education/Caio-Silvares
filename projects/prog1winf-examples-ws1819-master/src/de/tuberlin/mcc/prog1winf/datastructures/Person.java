package de.tuberlin.mcc.prog1winf.datastructures;

public class Person implements Comparable<Person> {

	private String name;
	
	private int age;
	
	private double height;

	public Person(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public int compareTo(Person other) {
		int ageComparison = Integer.compare(this.age, other.age);
		
		if(ageComparison != 0)
			return ageComparison;
		
		return Double.compare(this.height, other.height);
	}
	
	
	
}
