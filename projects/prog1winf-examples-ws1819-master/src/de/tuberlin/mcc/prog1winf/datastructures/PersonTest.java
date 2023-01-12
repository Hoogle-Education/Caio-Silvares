package de.tuberlin.mcc.prog1winf.datastructures;

public class PersonTest {

	public static void main(String[] args) {
		
		Person jhon = new Person("Jhon C", 23, 1.8);
		
		BTree<Person> people = new BTree<>();
		
		people.insert(jhon);
		
		
	}
	
}
