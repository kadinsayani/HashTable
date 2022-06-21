public class Student {
	private String name;
	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return int
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return String
	 */
	public String toString() {
		String s = name + ":" + Integer.toString(age);
		return s;
	}
}
