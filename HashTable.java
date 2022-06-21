import java.util.LinkedList;

public class HashTable {
	private LinkedList<Student> arr[];
	public static final int LEN = 8;

	/**
	 * Constructor method initializes array of type LinkedList with length LEN
	 * Each element of the array is initialized to a LinkedList of type Student
	 */
	public HashTable() {
		arr = new LinkedList[LEN];
		for (int i = 0; i < LEN; i++) {
			arr[i] = new LinkedList<Student>();
		}
	}

	/**
	 * Hash function to convert a string to an integer.
	 * 
	 * Precondition: s is a string composed only of alphanumeric characters.
	 * Postcondition: the sum of the ASCII values of s modulo LEN is returned.
	 * 
	 * @param s
	 * @return int
	 */
	public int hashValue(String s) {
		// hash function: sum of ASCII values of characters in the string
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i);
		}
		return sum % LEN;
	}

	/**
	 * Searches for a student with the given name in the hash table.
	 * 
	 * Precondition: name is a string composed of alphanumeric characters.
	 * Postcondition: if the hash table contains a student with the given name,
	 * return true. Otherwise, return false.
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean search(String name) {
		// search for a student with the given name
		int index = hashValue(name);
		LinkedList<Student> list = arr[index];
		for (Student s : list) {
			if (s.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Inserts a student into the hash table.
	 * 
	 * Precondition: name is a string composed of alphanumeric characters.
	 * Postcondition: if the hash table does not contain a student with the given
	 * name, then a student with attributes name and age is inserted into the hash
	 * table. If a student with the given name already exists, then the age of the
	 * student is updated to the given age.
	 * 
	 * @param name
	 * @param age
	 */
	public void insert(String name, int age) {
		// insert a student with the given name and age
		int index = hashValue(name);
		LinkedList<Student> list = arr[index];
		for (Student s : list) {
			if (s.getName().equals(name)) {
				int initialAge = s.getAge();
				s.setAge(age);
				System.out.println("Changing age of " + name + " from " + initialAge + " to " + age);
				return;
			}
		}
		list.addFirst(new Student(name, age));
		System.out.println("Inserting " + name + " with age " + age);
	}

	/**
	 * Removes a student from the hash table.
	 * 
	 * Precondition: name is a string composed of alphanumeric characters.
	 * Postcondition: if the hash table contains a student with the given name, then
	 * the student is removed from the hash table. Otherwise, a message is printed
	 * to the console.
	 * 
	 * @param name
	 */
	public void delete(String name) {
		// delete a student with the given name
		int index = hashValue(name);
		LinkedList<Student> list = arr[index];
		for (Student s : list) {
			if (s.getName().equals(name)) {
				list.remove(s);
				System.out.println("Deleting " + name);
				return;
			} else {
				System.out.println("Student " + name + " not found");
			}
		}
	}

	/**
	 * Returns the age of the student with the given name.
	 * 
	 * Precondition: name is a string composed of alphanumeric characters.
	 * Postcondition: if the hash table contains a student with the given name, then
	 * the age of the student is returned. Otherwise, -1 is returned.
	 * 
	 * @param name
	 * @return int
	 */
	public int getAge(String name) {
		// get the age of a student with the given name
		int index = hashValue(name);
		LinkedList<Student> list = arr[index];
		for (Student s : list) {
			if (s.getName().equals(name)) {
				return s.getAge();
			}
		}
		System.out.println("Student " + name + " not found");
		return -1;
	}

	/**
	 * Increments the age of the student with the given name by 1.
	 * 
	 * Preconditon: name is a string composed of alphanumeric characters.
	 * Postcondition: if the hash table contains a student with the given name, then
	 * the age of the student is incremented by 1. Otherwise, a message is printed
	 * to the console.
	 * 
	 * @param name
	 */
	public void increment(String name) {
		// increment age of a student with the given name
		int index = hashValue(name);
		LinkedList<Student> list = arr[index];
		for (Student s : list) {
			if (s.getName().equals(name)) {
				int initialAge = s.getAge();
				s.setAge(s.getAge() + 1);
				System.out.println("Incrementing age of " + name + " from " + initialAge + " to " + s.getAge());
				return;
			}
		}
		System.out.println("Student " + name + " not found");
	}

	/**
	 * Prints the contents of the hash table.
	 * 
	 * Precondition: arr is an array of LinkesList of type Student.
	 * Postcondition: a string is returned consisting of one line per entry of the
	 * array, including empty linked lists. Each line consists of the name of the
	 * student and the age.
	 * 
	 * @return String
	 */
	public String toString() {
		// call linked list tostring method
		String s = "";
		for (int i = 0; i < LEN; i++) {
			s += arr[i].toString();
			s += "\n";
		}
		return s;
	}
}