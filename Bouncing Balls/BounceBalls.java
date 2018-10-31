import java.util.ArrayList;
import java.util.Iterator;

public class BounceBalls{
    private ArrayList<Ball> list = new ArrayList<Ball>();
    private int gravityBallArrayCounter = 0;
    private int numberOfBalls = 100;
	private GameArenaOriginal game = new GameArenaOriginal(1000,750);
	private String[] a = {"MAGENTA","CYAN","ORANGE","RED","LIME","YELLOW","WHITE"};

	public static void main (String[] args){
		BounceBalls play = new BounceBalls();
		
	}	

	public BounceBalls(){

		int j = 0;
		for(int i = 0 ; i < 100 ; i++){

			Ball ball = new Ball(Math.random()*1000,Math.random()*1000,20,a[j],Math.random()*3,Math.random()*3,0);
			list.add(ball);
			game.addBall(ball);
			if(j == 6)
				j = 0;
			else
				j++;

		}
		while(true){
			Iterator<Ball> ballIterator = list.iterator();
        	while(ballIterator.hasNext()){
            Ball itterationBall = ballIterator.next();
			itterationBall.checkBallCollision(list,30,game);
			itterationBall.move(game);
        	}
			game.update();
		}

	}
}