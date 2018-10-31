
public class ProxyBoxDriver{

	/**
	 * Main function - create a new stage from which levels will be called.
	 * @param args
	 */
	public static void main(String [] args){

		GameArena game = new GameArena(1000,800);
		Ball[] list= new Ball[400];
		//create rectangles
		int toggle = 1;
		int i = 0;
		int j = 0;
		int xloc = 25;
		int yloc = 25;
		
		while(toggle == 1){
			Ball rec = new Ball(xloc,yloc,5,"BLUE",0,0,j);
			list[i] = rec;
			game.addBall(rec);
			i++;
			j++;
			if(xloc<950)
				xloc+=50;
			else{
				xloc = 25;
				yloc +=50;
			}
			if(yloc>800)
				toggle = 0;
		}
		list[170].setOn(3);
		list[169].setOn(3);
		list[150].setOn(3);
		list[149].setOn(3);
		int p = 0;
		int none = 0;
		while(true){
			p = 0;
			for(p = 0; p<318 ; p++){
				list[p].proxy(list,p);
				if(list[p].getOn() == 1 || list[p].getOn() == 2 || list[p].getOn() ==3)
					none++;



			}
			if(none == 0){
					list[170].setOn(3);
					list[169].setOn(3);
					list[150].setOn(3);
					list[149].setOn(3);

			}
			none = 0;
			try { Thread.sleep(100); }
            catch (Exception e) {};	
			game.update();
		}

	}

}