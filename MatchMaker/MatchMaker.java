public class MatchMaker{
	Person[] array = new Person[4];

	public static void main(String [] args_){
		PeopleTest v1 = new PeopleTest();
		v1.match();
	}

	public MatchMaker(){

		array[0] = new Person("Jessica",18,"Biology","female");
		array[1] = new Person("Mike",18,"Maths","male");
		array[2] = new Person("Lucy",18,"Business","female");
		array[3] = new Person("Rebecca",18,"Business","female");
		System.out.println("Starting");

	}
	public void match(){
		for(int i = 0; i<array.length;i++){
			for(int j = 0; j <array.length;j++){
				if(array[i].getAge()==array[j].getAge() && array[i].getGender() != (array[j].getGender()) && array[i].getMajor() != (array[j].getMajor()) && i != j)
				System.out.print("Match :" + array[i].getName() + " And " + array[j].getName() + "\n");
			}
		}
	}
}