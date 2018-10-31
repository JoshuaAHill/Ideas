import java.util.ArrayList;


public class Message{


	private ArrayList<Rectangle> queue = new ArrayList<>();
	public Message(){
		System.out.println("recieved");

	}
	public void newMessage(GameArena game){
	Rectangle background = new Rectangle(100,100,500,100,"BLUE");
	queue.add(background);
	int j = 0;
	while(j<20){
		queue(i).setYPosition(getYPosition() + 50);
		}
	}

	public void show(GameArena game){
		int i = 0;
		while(i<20){
			game.addRectangle(queue.get(i));
			i++;
			System.out.println("itteratiing queue");
		}
		game.update();

	}
}