 
import java.util.ArrayList;
public class Lights{
	

	public static void main(String [] args){
		ArrayList<Rectangle> list = new ArrayList<>();
		GameArena game = new GameArena(1920,1080);
		int number_width = game.getArenaWidth();
		int number_hight = game.getArenaHeight();
		int counter = 0;
		Rectangle rec = new Rectangle(50,50,20,20,1);
		

		String red = "0xFF0000";
		String green = "0xFFFFFF";
		int blue = 0x100000;
		rec.setColour(Integer.toString(blue));

		game.addRectangle(rec);
		game.update();
}



/*
		for(int i = 1 ; i<number_width;i+=15){
			for(int j = 1; j<number_hight;j+=15){
				Rectangle r = new Rectangle(i,j,15,15,counter);
				game.addRectangle(r);
				list.add(r);
				counter+=1;
				if(counter >= 7){
					counter = 0;
				}
			}
		}
		while(true){
			for(int i = 0; i < list.size(); i++)
				list.get(i).cycle();
			game.update();

		}
*/









}