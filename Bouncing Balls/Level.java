import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

public class Level implements ActionListener{
	
    private GameArena game;
    private ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();
    private JButton levelBackButton;
    private Text ballNoText = new Text( "Number of Balls: ",0,10,15,"WHITE");
    private Text gravityText = new Text( "Gravity: Off",0,10,15,"WHITE");

    //Extra Ball variables
    private ArrayList<Ball> extraBallList = new ArrayList<Ball>();
    private int extraBallArrayCounter = 0;

    //Gravity Ball variables
    private ArrayList<Ball> gravityBallList = new ArrayList<Ball>();
    private int gravityBallArrayCounter = 0;

    //Ball variables
    private ArrayList<Ball> ballArray = new ArrayList<Ball>();
    private int numberOfBalls;
    private int ballNoCounter = 0;
    private int ballSpacing = 6;
    private double startBallX = 0;
    private double startBallY = 0;

    //Rectangle Variables
    private double rectangleSpacing = 55;
    private double rectangleStartY = 25+rectangleSpacing*3; //first row * by the number of rows to display after that initially.
    private int rectangleHeight = 52;
    private int rectangleLength = 52;

    //Toggles
    private int ballsInPlay = -1;
    private int gameIsPlayingToggle = 0;


    /** Constructor - Runs when a level is called for. This creates the number of balls given, cteates the bricks according to the parameters given.
     * @param game1             The gameArena that is copied to the local variables, so that it can be used in other methods.
     * @param numberOfBallsP    The number of balls this level should start with. Passed into local varaibles so it can be used in other methods
     * @param rowDensityStart   What density from 0(none) to 10(max) of bricks there should be on the lowest bricks in the level
     * @param rowDensityMax     What density from 0(none) to 10(max) of bricks there should be on the highest bricks in the level
     * @param numberOfRows      How many rows of bricks the level should have
     * @param Health            What health the first brick should have
     * @param maxHealth         How much health the last bricks in the level should have
     * @param healthGain        How quickly 0(none) to (no max) the bricks health increaces from 'Health' to 'maxHealth' as bricks are added
     * @param densityGain       How quickly 0(none) to (no max) the desnisy of bricks should increace from the start density to the max density. Should be positive if start density is lower than max, negative if vice verca.
     * @param chanceOfExtra     The chance 0(none) to 10(max) of an extra ball being created instead of a brick -- If set too high, there will be few bricks
     * @param chanceOfGravity   The chance 0(none) to 10(max) of a gravity ball being created instead of a brick -- If set too high, there will be few bricks
     * @param chanceOfDecrease  The chance 0(none) to 10(max) of the health of a brick decreacing rather than increacing -- should be higher than chanceOfExtra and changeOfGravity to function
     * @param backButton        The button passed from the creator that allows a return to the creator at any time.
     */
    public Level(GameArena game1, int numberOfBallsP, double rowDensity, double rowDensityMax, int numberOfRows, double Health, int maxHealth, double healthGain, double densityGain, double chanceOfExtra, double chanceOfGravity, double chanceOfDecrease, JButton backButton){
        //variables
        double rectangleStartX = 35;
        int rectangleNo = 0;
        int rectanglesPerRow = 18;

        //Assignments from passed to local variables
        game = game1;
        levelBackButton = backButton;
        numberOfBalls = numberOfBallsP;
        //Health is the 'start health'

        //add Text
        ballNoText.setXPosition(game.getArenaWidth()-200);
        ballNoText.setYPosition(game.getArenaHeight() -20);
        game.addText(ballNoText);
        gravityText.setXPosition(game.getArenaWidth()-350);
        gravityText.setYPosition(game.getArenaHeight() -20);
        game.addText(gravityText);

        //Add action listener to passed button
        levelBackButton.addActionListener(this);
        
        //Set Ball Start Location
        startBallX = game.getArenaWidth()/2+2;
        startBallY = game.getArenaHeight() - 50;
        
        //Create balls.
        for(int i = 0;i<numberOfBalls;i++){
             ballArray.add(new Ball(game.getArenaWidth()/2+2,game.getArenaHeight() - 50,8,"WHITE",0,0,ballNoCounter));
             game.addBall(ballArray.get(i));
             ballNoCounter+=ballSpacing;
        }

        //create bricks and special balls
        for(int i = 0; i<numberOfRows;i++){
                        //counter = fist position on right             counter < 18 * spacing (+start X so bricks are inline)      increace counter by Spacing (right place for centre of next brick)
            for(double xLocationCounter = rectangleStartX ; xLocationCounter < rectanglesPerRow*rectangleSpacing+rectangleStartX ; xLocationCounter+=rectangleSpacing){
                double randomNumber = Math.random()*10;
                
                if(randomNumber<chanceOfExtra && randomNumber < chanceOfGravity){         //to avoid getting extra and gravity balls on the same space - if the 
                    if(randomNumber>5){addExtraBall(xLocationCounter);}
                    else{addGravityBall(xLocationCounter);}                        
                }
                else{
                //Add Extra balls
                    if(randomNumber < chanceOfExtra){
                        addExtraBall(xLocationCounter);
                    }
                //Add Gravity balls
                    if(randomNumber < chanceOfGravity){
                        addGravityBall(xLocationCounter);
                    }    
                }
                
                //Add Normal Bricks
                if( randomNumber > chanceOfExtra && randomNumber > chanceOfGravity && randomNumber < rowDensity){
                    Rectangle brick = new Rectangle(xLocationCounter, rectangleStartY, rectangleHeight, rectangleLength, "Red", (int)Health, game, rectangleList, rectangleNo);

                    rectangleNo++;
                    if(Health<maxHealth){
                        System.out.println("random number " + (int)randomNumber);
                        if(Health < maxHealth/2){
                            if(randomNumber<chanceOfDecrease && Health > 5)
                                Health -= 2;
                            if(randomNumber>=chanceOfDecrease && randomNumber < 5)
                                Health +=healthGain;
                            if(randomNumber>5)
                                Health+=healthGain*2;
                        }
                        if(Health >= maxHealth/2-1){
                            if(randomNumber<chanceOfDecrease && Health > 5)
                                Health -= 2;
                            if(randomNumber>chanceOfDecrease && randomNumber < 4)
                                Health +=healthGain;
                        }                    
                    }
                    if(Health == maxHealth){
                        if(randomNumber<1)
                            Health -= 3;
                    }
                    while(Health>maxHealth){
                        Health--;
                    }
                }
            }
            System.out.println(rowDensity);
            if(rowDensity < rowDensityMax)
            rowDensity += densityGain; //Gradually, lines will be more filled with blocks
            System.out.println(rowDensity);
            rectangleStartY -= rectangleSpacing;

        }

    }

    /**
     * Action event for the 'back button' that allows Level to return to the caller. The level is ended
     * @param e - e is the name of the action event
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == levelBackButton){
        endLevel();
        gameIsPlayingToggle = 1;
        }
    }

    /**
     * Play Loop. This is the loop that runs the game, it controls the movement of balls, bricks and win/loose conditions
     * @return  - 0 is returned if the level has been completed, and -1 is returned if the level is failed.
     */
    public int play(){

        int extraBallHitToggle = 0;
        int ballsToAdd = 0;
        int gravityCheck = 0;
        int gravityToggle = -1;
        double angleSpeed = 0;
        int firstBallLost = 0;
        int ballMoveCounter = 0;
        Pointer pointer = new Pointer();


        
        while(gameIsPlayingToggle == 0){ //there are still bricks left, and none have hit the bottom 

        System.out.println(rectangleList.size());

        //Check if there are rectangles left - and hence the game is still in play
        if(rectangleList.size()<=0){
            gameIsPlayingToggle = 0;
            endLevel();
            return 1; //game won
        }

        //update the text to display the number of balls
        ballNoText.setText("Number of Balls: " + Integer.toString(numberOfBalls));

        //Create pointer for this round
        angleSpeed = pointer.start(game,angleSpeed,levelBackButton,startBallX,startBallY); 

        //Set all balls speed, returned from pointer
        for(int i =0 ;i<numberOfBalls;i++){         
            ballArray.get(i).setYSpeed(-10+Math.abs(angleSpeed));
            ballArray.get(i).setXSpeed(angleSpeed);   
        }

        //move balls loop - increment BallsInPlay counter so the balls don't all go at once.
        while(ballsInPlay != 0 && gameIsPlayingToggle == 0){
            ballsInPlay = 0;
            for(int i = 0 ;i<numberOfBalls;i++){
                if(ballMoveCounter > ballArray.get(i).getBallNo()){
                    ballArray.get(i).move(game);
                    ballArray.get(i).checkCollision(rectangleList, rectangleLength, rectangleHeight, game);
                    gravityCheck = ballArray.get(i).checkGravityCollision(gravityBallList,game,10);
                    if(ballArray.get(i).getYPosition()<game.getArenaHeight()-50)
                    extraBallHitToggle = ballArray.get(i).checkExtraCollision(extraBallList, game, 10);


                    if(extraBallHitToggle == 1){
                        ballsToAdd++;
                        extraBallHitToggle = 0;

                    }
                    //if gravity toggle has been hit (checkGravityCollision) then change the gravity of all the balls
                    
                    if(gravityCheck == 1){
                        for(int j = 0 ; j<numberOfBalls; j++){
                            if(gravityToggle < 0){
                                ballArray.get(j).setGravity();
                                gravityText.setText("Gravity: On");
                            }
                            else{
                                ballArray.get(j).unsetGravity();
                                gravityText.setText("Gravity: Off");
                            }
                        }
                        gravityToggle = -gravityToggle;
                    }
                    

                }
                //set the location of the balls to be fired to the location of the first ball to drop off the screen
                if(ballArray.get(i).getYPosition()>game.getArenaHeight() - 50){
                    if(firstBallLost == 0){
                    startBallX = ballArray.get(i).getXPosition();
                    firstBallLost = 1;
                    System.out.println("First Ball Lost - X = " + startBallX);
                    }
                }
                else ballsInPlay ++;

            }
            if(ballMoveCounter<numberOfBalls*ballSpacing){
                ballMoveCounter++;
            }
            game.update();
        }

        //Move the blocks down the screen, all the balls have been lost
        for(int i = 0 ; i< rectangleList.size() ; i++){
            Rectangle moveRectangle = rectangleList.get(i);
            moveRectangle.moveDown(rectangleSpacing);
            if(moveRectangle.getYPosition()+moveRectangle.getHeight()*2>game.getArenaHeight()){
                endLevel();
                return 0; //game lost
            }
        }
        //Move extra ball icons down the screen
        for(int i = 0 ; i< extraBallList.size() ; i++){ 
            Ball moveBall = extraBallList.get(i);
            moveBall.moveDown(rectangleSpacing);
            if(moveBall.getYPosition()+moveBall.getSize()*2>game.getArenaHeight()){   //removes the extra ball icon if it gets too low on the screen - but the game continues
                game.removeBall(moveBall);
            }
        }
        //move gravity balls down the screen
        for(int i = 0 ; i< gravityBallList.size() ; i++){ 
            Ball moveBall = gravityBallList.get(i);
            moveBall.moveDown(rectangleSpacing);
            if(moveBall.getYPosition()+moveBall.getSize()*2>game.getArenaHeight()){   //removes the gravity ball icon if it gets too low on the screen - but the game continues
                game.removeBall(moveBall);
            }
        }
        //Check location of ball - if it is too close to the edge, move it inwards towards the middle of the GameArena
        if(startBallX>game.getArenaWidth()-10)
            startBallX -=10;
        if(startBallX<10)
            startBallX=+10;
        //Add any extra balls
        if(ballsToAdd>0){
            for(int i = 0; i<ballsToAdd;i++){
            Ball extraBall = (new Ball(game.getArenaWidth()/2,game.getArenaHeight() - 50,8,"TOMATO",0,0,ballNoCounter));
            ballArray.add(extraBall);
            game.addBall(extraBall);
            ballNoCounter+=ballSpacing;
            numberOfBalls ++;
            }
        }

        // reset balls and arrow to the location of where the first ball landed, reset Gravity to off

        for(int i =0 ;i<numberOfBalls;i++){        
            ballArray.get(i).setYSpeed(0);
            ballArray.get(i).setXSpeed(0);
            ballArray.get(i).setXPosition(startBallX);
            ballArray.get(i).setYPosition(game.getArenaHeight() - 50);
            ballArray.get(i).unsetGravity();
        }
            gravityText.setText("Gravity: Off");
        
        //reset variables to original values for the next round.

        ballsToAdd = 0;
        angleSpeed = 0;
        ballMoveCounter = 0;
        ballsInPlay = -1;
        firstBallLost = 0;
        gravityToggle = -1; //unset Gravity after each round
        }
        endLevel();
        return 0;
    }

    /**
     * End level method - Removes all the level assets (rectangles, balls, text) from the GameArena
     */
    public void endLevel(){
        
        //remove standard balls from GameArena
        for(int i = 0; i<numberOfBalls;i++)
            game.removeBall(ballArray.get(i));
        
        //remove extra balls
        Iterator<Ball> extraBallListIterator = extraBallList.iterator();
        while(extraBallListIterator.hasNext()){
            Ball itterationBall = extraBallListIterator.next();
            game.removeBall(itterationBall);
        }
        extraBallList.clear();
        
        //remove gravity balls
        Iterator<Ball> gravityBallListIterator = gravityBallList.iterator();
        while(gravityBallListIterator.hasNext()){
            Ball itterationBall = gravityBallListIterator.next();
            game.removeBall(itterationBall);
        }
        gravityBallList.clear();
        
        //remove blocks (rectangles) from GameArena
        Iterator<Rectangle> rectangleListIterator = rectangleList.iterator();
        while(rectangleListIterator.hasNext()){
            Rectangle itterationRectangle = rectangleListIterator.next();
            itterationRectangle.removeRectangleText();
            game.removeRectangle(itterationRectangle);
        }
        rectangleList.clear();
    
        //remove text
        game.removeText(ballNoText);
        game.removeText(gravityText);

    }

    /**
     * Function to add an extra ball to the level to save on code duplication
     * @param xLocationCounter
     */
    public void addExtraBall(double xLocationCounter){
        Ball extraBall  = new Ball(xLocationCounter,rectangleStartY,10,"WHITE");
        extraBallList.add(extraBall);
        game.addBall(extraBall);
        extraBallArrayCounter++;
    }

    /**
     * Function to add an gravity ball to the level to save on code duplication
     * @param xLocationCounter
     */
    public void addGravityBall(double xLocationCounter){
        Ball gravityBall  = new Ball(xLocationCounter,rectangleStartY,10,"GREEN");
        gravityBallList.add(gravityBall);
        game.addBall(gravityBall);
        extraBallArrayCounter++; 
    }


}

	
