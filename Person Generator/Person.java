public class Person{
	private String name;
	private int age;
	private String major;
	private String gender;

	public Person(String n, int a, String m, String g){
		name = n;
		age = a;
		major = m;
		gender = g;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getMajor(){
		return major;
	}
	public String getGender(){
		return gender;
	}

}