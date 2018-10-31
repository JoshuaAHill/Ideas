import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pointer implements ActionListener{
    private JButton levelBackButton;
    private int toggle = 0;
    private GameArena levelGame;
    private Arrow localArrow;

    /**
     * Pointer, moved by pressing the right and left arrow keys, changes the values of 'angle speed' depending on its position, right is +tive left -tive
     * @param game              GameArena passed in for the pointer to be displayed on
     * @param angleSpeed        The angle speed variable that is changed as the pointer is moved left and right
     * @param backButton        A button that is passed to this class, this button returns to the caller class
     * @param startX            Used when definding the bounds to how far the pointer can move to the right and left
     * @param startY            used to set the bottom of the arrow to the correct hight.
     * @return
     */
	public double start(GameArena game, double angleSpeed, JButton backButton, double startX, double startY){
        levelGame = game;
        levelBackButton = backButton;
        levelBackButton.addActionListener(this);
        Arrow arrow = new Arrow(startX,startY,game.getArenaWidth()/2+2,game.getArenaHeight()-150,3,"RED",game); //(sets the original location to +2 to match the ball - to the ball bounces more reliably if fired straight up)
		arrow.setStart(startX,game.getArenaHeight() - 50);        
        arrow.setEnd(startX,game.getArenaHeight()-150);
        localArrow = arrow;
        //double moveAngle = 0;
        //arrow.setEnd(arrow.getStartY()-100*Math.sin(moveAngle), arrow.getStartY()-100*Math.cos(moveAngle));

        while(toggle == 0){

            if(game.rightPressed() == true && arrow.getEndX()<arrow.getStartX()+90 && arrow.getEndX()>=arrow.getStartX()){
                arrow.setEnd(arrow.getEndX()+1,arrow.getEndY()+1);
                angleSpeed = angleSpeed + 0.1;
            }
            if(game.rightPressed() == true && arrow.getEndX()>=arrow.getStartX()-90 && arrow.getEndX()<=arrow.getStartX()){
                arrow.setEnd(arrow.getEndX()+1,arrow.getEndY()-1);
                angleSpeed = angleSpeed + 0.1; 
            }
            if(game.leftPressed() == true && arrow.getEndX()>arrow.getStartX()-90 && arrow.getEndX()<=arrow.getStartX()){
                arrow.setEnd(arrow.getEndX()-1,arrow.getEndY()+1);
                angleSpeed = angleSpeed - 0.1;
            }
            if(game.leftPressed() == true && arrow.getEndX()<=arrow.getStartX()+90 && arrow.getEndX()>=arrow.getStartX()){
                arrow.setEnd(arrow.getEndX()-1,arrow.getEndY()-1);
                angleSpeed = angleSpeed - 0.1;
            }
       
            if(game.spacePressed() == true){               
                arrow.removeArrow(game);
                return angleSpeed;
            }

            game.update();

        }
        arrow.removeArrow(game);
        return 0;

	}

    /**
     *  Action event for the 'back button' that allows Level to return to the caller.
     * @param e - e is the name of the action event
     */
        public void actionPerformed(ActionEvent e) {
        if(e.getSource() == levelBackButton){
            localArrow.removeArrow(levelGame);
            toggle = 1;
        }
    }

}