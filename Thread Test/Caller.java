public class Caller{
	
	public static void main(String[] args){

	for(int i = 0; i < 10 ; i++){
		MyThread mt = new MyThread();
		Thread t = new Thread(mt);
		t.start();
	}

	System.out.println("Im from the main thread!");
	}


}