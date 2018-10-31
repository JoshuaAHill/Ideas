import java.util.Random;
public class NameGenerator{
	
	private String[] start  = new String[] {"J","J","J","M","M","M","S","S","S","D","D","C","C","B","B","K","K","A","R","L","T","P","E","G","W","N","H"}; //26
	private String[] doubleL = new String[] {"th","he","an","ed","ti","as","rt","ve"};	//7
	private String[] second = new String[] {"h","h","o","o","e","e","i","i","a","a","a","u","n","r","t"}; //14
	private String[] third = new String[] {"e","e","e","s","s","a","a","r","r","n","i"}; //10
	private String[] last = new String[] {"e","e","s","s","t","t","d","d","n","n","r","r","y","f","i","o","g","h","a","k","m","p","u","w"}; //23
	private Random randomNumber=new Random();
	private int nameLength;

	public static void main(String[] args){
		NameGenerator gen = new NameGenerator();
		for(int i =0;i<20;i++)
			gen.createName();
	}


	public void createName(){
		nameLength = 0;
		while(nameLength<3)
			nameLength = randomNumber.nextInt(7);
		System.out.print(nameLength + " --- ");
		int a = 0;
		int previous = -1;
		int previous2 = -1;
		a = randomNumber.nextInt(27);
		System.out.print(start[a]);
		nameLength--;
		nameLength--;
		if(a<7){
				for(int i = 0; i<=nameLength/2;i++){
					a = randomNumber.nextInt(10);
						if(a == 0){
							a = randomNumber.nextInt(7);
							System.out.print(doubleL[a]);
						}
						else{
							a = randomNumber.nextInt(14);
							while(a == previous){
							a = randomNumber.nextInt(14);
							}
							System.out.print(second[a]);
							previous = a;
						}
				}
				for(int i = 0; i<=nameLength/2;i++){
					a = randomNumber.nextInt(10);
					if(a == 0){
						a = randomNumber.nextInt(7);
						System.out.print(doubleL[a]);
						}
					else{
						a = randomNumber.nextInt(10);
						while(a == previous2){
							a = randomNumber.nextInt(10);
							}
						System.out.print(third[a]);
						previous2 = a;

					}
				}
		}
		else{
			for(int i = 0; i<=nameLength/3 * 2;i++){
					a = randomNumber.nextInt(10);
						if(a == 0){
							a = randomNumber.nextInt(7);
							System.out.print(doubleL[a]);
						}
						else{
							a = randomNumber.nextInt(14);
							while(a == previous){
							a = randomNumber.nextInt(14);
							}
							System.out.print(second[a]);
							previous = a;
						}
				}
				for(int i = 0; i<=nameLength/3	;i++){
					a = randomNumber.nextInt(10);
					if(a == 0){
						a = randomNumber.nextInt(7);
						System.out.print(doubleL[a]);
						}
					else{
						a = randomNumber.nextInt(10);
						while(a == previous2){
							a = randomNumber.nextInt(10);
							}
						System.out.print(third[a]);
						previous2 = a;

					}
				}
		}
				a = randomNumber.nextInt(4);
				if(nameLength>3  || a<1){
				a = randomNumber.nextInt(23);
				System.out.print(last[a]);
				}
				System.out.println();


	}



}