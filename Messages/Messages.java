import java.util.ArrayList;


public class Messages{
	
private ArrayList<Message> queue = new ArrayList<>();

	public static void main(String [] args){

		GameArena game = new GameArena(1000,800);
		Message message = new Message();
		System.out.println("hello");

		while(true){
			System.out.println("start loop");
			if(game.upPressed()){
				System.out.println("up");
				message.newMessage(game);
			}
			if(game.downPressed()){
				System.out.println("down");
				message.show(game);
			}
		}
	}



}