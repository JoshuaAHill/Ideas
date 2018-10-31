/**
 * Models a simple solid sphere. 
 * This class represents a Ball object. When combined with the GameArena class,
 * instances of the Ball class can be displayed on the screen.
 */
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.lang.Math;

public class Ball 
{
    // The following instance variables define the information needed to represent a Ball
    // Feel free to more instance variables if you think it will support your work... 
    
    private double xPosition;           // The X coordinate of this Ball
    private double yPosition;           // The Y coordinate of this Ball
    private double size;                // The diameter of this Ball
    private String colour;              // The colour of this Ball
    private double xSpeed;
    private double ySpeed;
    private double ballNo;
    private int gravity = -1;
    private int on;
              
                                       

    /**
     * Obtains the current position of this Ball.
     * @return the X coordinate of this Ball within the GameArena.
     */
    public double getXPosition()
    {
        return xPosition;
    }

    /**
     * Obtains the current position of this Ball.
     * @return the Y coordinate of this Ball within the GameArena.
     */
    public double getYPosition()
    {
        return yPosition;
    }

    /**
     * Moves the current position of this Ball to the given co-ordinates
     * @param x the new x co-ordinate of this Ball
     */
    public void setXPosition(double x)
    {
        this.xPosition = x;
    }

    /**
     * Moves the current position of this Ball to the given co-ordinates
     * @param y the new y co-ordinate of this Ball
     */
    public void setYPosition(double y)
    {
        this.yPosition = y;
    }

    /**
     * Obtains the size of this Ball.
     * @return the diameter of this Ball,in pixels.
     */
    public double getSize()
    {
        return size;
    }

    /** 
     * Changes the size of this Ball to the given value.
     * @param s The new size of the Ball.
     */
    public void setSize(double s)
    {
        size = s;
    }

    /**
     * Obtains the colour of this Ball.
     * @return a textual description of the colour of this Ball.
     */
    public String getColour()
    {
        return colour;
    }

    public double getXSpeed(){
        return xSpeed;
    }
    public double getYSpeed(){
        return ySpeed;
    }
    public void setXSpeed(double s){
        xSpeed = s;
    }
    public void setYSpeed(double s){
        ySpeed = s;
    }

    public double getBallNo(){
        return ballNo;
    }
    public void setBallNo(double b){
        ballNo = b;
    }
    //public void Hit(int x){
    //    removeRectangle(x);
    //}

    /**
     * Changes the colour of this Ball to the given value.
     * 
     * @param c The new colour of this Ball. 
     * <BR><BR>
     * Permissable values are 8 bit hexadecimal RGB values in the format #RRGGBB. e.g.  
     * Pure red is "#FF0000"   <BR>
     * Pure green is "#00FF00" <BR>
     * Pure blue is "#0000FF"  <BR>
     * <BR>
     * Alternativley, named colours are also allowed for the following list. e.g. "AQUA" :
     * <BR><BR>
     * ALICEBLUE ANTIQUEWHITE AQUA AQUAMARINE AZURE BEIGE BISQUE BLACK BLANCHEDALMOND BLUE BLUEVIOLET BROWN BURLYWOOD CADETBLUE CHARTREUSE CHOCOLATE CORAL
     * CORNFLOWERBLUE CORNSILK CRIMSON CYAN DARKBLUE DARKCYAN DARKGOLDENROD DARKGRAY DARKGREEN DARKGREY DARKKHAKI DARKMAGENTA DARKOLIVEGREEN DARKORANGE DARKORCHID
     * DARKRED DARKSALMON DARKSEAGREEN DARKSLATEBLUE DARKSLATEGRAY DARKSLATEGREY DARKTURQUOISE DARKVIOLET DEEPPINK DEEPSKYBLUE DIMGRAY DIMGREY DODGERBLUE FIREBRICK
     * FLORALWHITE FORESTGREEN FUCHSIA GAINSBORO GHOSTWHITE GOLD GOLDENROD GRAY GREEN GREENYELLOW GREY HONEYDEW HOTPINK INDIANRED INDIGO IVORY KHAKI LAVENDER LAVENDERBLUSH
     * LAWNGREEN LEMONCHIFFON LIGHTBLUE LIGHTCORAL LIGHTCYAN LIGHTGOLDENRODYELLOW LIGHTGRAY LIGHTGREEN LIGHTGREY LIGHTPINK LIGHTSALMON LIGHTSEAGREEN LIGHTSKYBLUE LIGHTSLATEGRAY
     * LIGHTSLATEGREY LIGHTSTEELBLUE LIGHTYELLOW LIME LIMEGREEN LINEN MAGENTA MAROON MEDIUMAQUAMARINE MEDIUMBLUE MEDIUMORCHID MEDIUMPURPLE MEDIUMSEAGREEN MEDIUMSLATEBLUE
     * MEDIUMSPRINGGREEN MEDIUMTURQUOISE MEDIUMVIOLETRED MIDNIGHTBLUE MINTCREAM MISTYROSE MOCCASIN NAVAJOWHITE NAVY OLDLACE OLIVE OLIVEDRAB ORANGE ORANGERED ORCHID
     * PALEGOLDENROD PALEGREEN PALETURQUOISE PALEVIOLETRED PAPAYAWHIP PEACHPUFF PERU PINK PLUM POWDERBLUE PURPLE RED ROSYBROWN ROYALBLUE SADDLEBROWN SALMON SANDYBROWN
     * SEAGREEN SEASHELL SIENNA SILVER SKYBLUE SLATEBLUE SLATEGRAY SLATEGREY SNOW SPRINGGREEN STEELBLUE TAN TEAL THISTLE TOMATO TURQUOISE VIOLET WHEAT WHITE
     * WHITESMOKE YELLOW YELLOWGREEN.
     *
     */

    public void setColour(String c)
    {
        colour = c;
    }

    /**
     *
     * Constructor. Create a new instance of a Ball.
     *
     * @param x The X co-ordinate in the GameArena where this Ball will initially be located.
     * @param y The Y co-ordinate in the GameArena where this Ball will initially be located.
     * @param diameter The size (diameter) of the Ball in pixels.
     * @param col. The colour of the Ball. @see setColour for a description of permissable colours.
     * @param xs The X Speed of the Ball
     * @param ys The Y Speed of the Ball
     * @param bn The ball number of this instance
     *
     */

    public Ball(double x, double y, double diameter, String col, double xs, double ys, double bn)
    {
        xPosition = x;
        yPosition = y;
        size = diameter;
        colour = col;
        xSpeed = xs;
        ySpeed = ys;
        ballNo = bn;
    }

    /**
     * Alternative Constructor - used for 'special' balls
     * @param x         The X co-ordinate in the GameArena where this Ball will initially be located.
     * @param y         The Y co-ordinate in the GameArena where this Ball will initially be located.
     * @param diameter  The size (diameter) of the Ball in pixels.
     * @param col       The colour of the Ball. @see setColour for a description of permissable colours.
     */
    public Ball(double x, double y, double diameter, String col)
    {
        xPosition = x;
        yPosition = y;
        size = diameter;
        colour = col;
    }

    /**
     * Controls the moving of the ball, and the bouncing off the edge of the GameArena (game)
     * @param game  The GameArena that the ball is located in
     */
    public void move(GameArena game){
        //collision with walls of the passed GameArena
        if (getXPosition() > game.getArenaWidth() -size)
                xSpeed = -xSpeed;
        if (getXPosition() < 0 + size)
                xSpeed = -xSpeed;
        if (getYPosition() > game.getArenaHeight()-50){
                ySpeed = 0;
                xSpeed = 0;
        }
        if (getYPosition() < 8 + size)
                ySpeed = -ySpeed;
        if(gravity > 0)
            ySpeed += 0.05;

        //Move the balls in relation to their current speed
        setXPosition(getXPosition() + xSpeed);
        setYPosition(getYPosition() + ySpeed);


}

    /**
     * MoveDown method - moves the balls down by a given value (amount)
     * @param amount    How far to move the ball down in pixels
     */
    public void moveDown(double amount){
        setYPosition(getYPosition()+amount);
    }

    /**
     * Collision method - checks all the balls for collision with any rectangle in a given array (that must be filled with rectangles)
     * Calls rectangle methods if a collision is detected, and the balls speeds are reversed accordingly so mimic the ball bouncing off of the rectangle.
     * @param list              The Array List of rectangles to check for collision with
     * @param rectangleLength   How long are the rectangles in this list
     * @param rectangleHeight   How high are the rectangles in this list
     * @param game              The GameArena that the ball and rectangles are located in
     */
    public void checkCollision(ArrayList<Rectangle> list, int rectangleLength, int rectangleHeight, GameArena game){
        for(int i = 0;i<list.size();i++){
            Rectangle collisionRectangle = list.get(i);
            //General area check to speed up processing - only checks rectangles that are in a given range
            if(getXPosition()<collisionRectangle.getXPosition()+100 && getXPosition()>collisionRectangle.getXPosition()-100 && getYPosition()<collisionRectangle.getYPosition()+100 && getYPosition()>collisionRectangle.getYPosition()-100){
                if(getXPosition()+size>collisionRectangle.getXPosition()-rectangleLength/2 && getXPosition()-size<collisionRectangle.getXPosition()+rectangleLength/2 && getYPosition()-size-2 < collisionRectangle.getYPosition()+rectangleHeight/2 && getYPosition()>collisionRectangle.getYPosition() && (Math.abs(collisionRectangle.getXPosition() - getXPosition()) < Math.abs(collisionRectangle.getYPosition() - getYPosition())) && ySpeed<0){
                    ySpeed = -ySpeed; //BOTTOM
                    collisionRectangle.removeHealth();
                    collisionRectangle.colourHealth();
                    collisionRectangle.checkHealth(i);
                    break;
                }
                if(getXPosition()+size>collisionRectangle.getXPosition()-rectangleLength/2 && (getXPosition()-size)<collisionRectangle.getXPosition()+rectangleLength/2 && getYPosition()+size+2 > collisionRectangle.getYPosition()-rectangleHeight/2 && getYPosition()<collisionRectangle.getYPosition() && (Math.abs(collisionRectangle.getXPosition() - getXPosition()) < Math.abs(collisionRectangle.getYPosition() - getYPosition())) && ySpeed>0){
                    ySpeed = -ySpeed;  //TOP
                    collisionRectangle.removeHealth();
                    collisionRectangle.colourHealth();
                    collisionRectangle.checkHealth(i);
                    break;
                }
                try { Thread.sleep(0); }
                catch (Exception e) {};

                if(getYPosition()+size>collisionRectangle.getYPosition()-rectangleHeight/2 && getYPosition()-size<collisionRectangle.getYPosition()+rectangleHeight/2 && getXPosition()-size < collisionRectangle.getXPosition()+rectangleLength/2 && getXPosition()>collisionRectangle.getXPosition() && (Math.abs(collisionRectangle.getYPosition() - getYPosition()) < Math.abs(collisionRectangle.getYPosition() - getXPosition())) && xSpeed<0){
                    xSpeed = -xSpeed;  //RIGHT
                    collisionRectangle.removeHealth();
                    collisionRectangle.colourHealth();
                    collisionRectangle.checkHealth(i);
                    break;
                }
                if(getYPosition()+size>collisionRectangle.getYPosition()-rectangleHeight/2 && (getYPosition()-size)<collisionRectangle.getYPosition()+rectangleHeight/2 && getXPosition()+size > collisionRectangle.getXPosition()-rectangleLength/2 && getXPosition()<collisionRectangle.getXPosition() && (Math.abs(collisionRectangle.getYPosition() - getYPosition()) < Math.abs(collisionRectangle.getXPosition() - getXPosition())) && xSpeed>0){
                    xSpeed = -xSpeed; //LEFT
                    collisionRectangle.removeHealth();
                    collisionRectangle.colourHealth();
                    collisionRectangle.checkHealth(i);
                    break;
                }
            }
        }         
    }

    /**
     * Check for collision with special ball type 'extra balls'
     * @param ballList  The list of balls to check for collisions with
     * @param game      The GameArena where the balls are located
     * @param ballSize  How big are the balls in the list (diameter, in pixels)
     * @return          Returns a 1 if a collision is detected, 0 if no collision is detected
     */
    public int checkExtraCollision(ArrayList<Ball> ballList, GameArena game, int ballSize){
        for(int i = 0; i < ballList.size() ; i++){
            if(ballList.size() > 0 && getXPosition()+size>ballList.get(i).getXPosition()-ballSize && getXPosition()-size < ballList.get(i).getXPosition()+ballSize && getYPosition()+size>ballList.get(i).getYPosition()-ballSize && getYPosition()-size < ballList.get(i).getYPosition()+ballSize){// && ballList.get(i).getYPosition()<getYPosition()+size && ballList.get(i).getYPosition()>getYPosition()-size){
                System.out.println("Hit Extra Ball");
                game.removeBall(ballList.get(i));
                ballList.remove(ballList.get(i));
                return 1;
            }   
        }
        return 0;
    }

    /**
     * Check for collision with special ball type 'gravity balls'
     * @param ballList  The list of balls to check for collisions with
     * @param game      The GameArena where the balls are located
     * @param ballSize  How big are the balls in the list (diameter, in pixels)
     * @return          Returns a 1 if a collision is detected, 0 if no collision is detected
     */
    public int checkGravityCollision(ArrayList<Ball> ballList, GameArena game, int ballSize){
        for(int i = 0; i < ballList.size() ; i++){
            if(ballList.size() > 0 && getXPosition()+size>ballList.get(i).getXPosition()-ballSize && getXPosition()-size < ballList.get(i).getXPosition()+ballSize && getYPosition()+size>ballList.get(i).getYPosition()-ballSize && getYPosition()-size < ballList.get(i).getYPosition()+ballSize){// && ballList.get(i).getYPosition()<getYPosition()+size && ballList.get(i).getYPosition()>getYPosition()-size){
                System.out.println("Hit gravity Ball");
                game.removeBall(ballList.get(i));
                ballList.remove(ballList.get(i));
                return 1;
            }   
        }
    return 0;
    }

    /**
     * Sets the gravity option to true, the ball will now fall down as if gravity is effecting it.
     */
    public void setGravity(){
        gravity = 1;
    }

    /**
     * Sets the gravity option to false, the ball will now not be effected by 'gravity' and move in a linear fashion
     */
    public void unsetGravity(){
        gravity = -1;
}

public void setColourOn(){
        if(on == 0)
            setColour("BLACK");
        if(on == 1)
            setColour("LIGHTSKYBLUE");
        if(on == 2)
            setColour("BLUE");
        if(on == 3)
            setColour("DARKBLUE");
    }
    public void setOn(int num){
        on = num;
        setColourOn();
    }
    public int getOn(){
        return on;
    }
    public void proxy(Ball[] array2, int rectanglePosition){
        double rand = Math.random()*10;
        if(rectanglePosition<20)
            return;
        if(rectanglePosition>299)
            return;
        if( rectanglePosition == 0)
            return;
        if(array2[rectanglePosition].getOn() == 3){
            if(rand > 1)
                setOn(3);
        }
        if(array2[rectanglePosition+1].getOn() == 3|| array2[rectanglePosition-20].getOn() == 3 || array2[rectanglePosition+20].getOn() == 3 || array2[rectanglePosition-1].getOn() == 3)
            if(rand>5)
                setOn(2);
            else
                setOn(3);

        if(array2[rectanglePosition+1].getOn() == 2|| array2[rectanglePosition-20].getOn()==2 || array2[rectanglePosition+20].getOn() == 2 || array2[rectanglePosition-1].getOn() == 2)
            if(rand>5)
                setOn(3);
            else
                setOn(1);

        if(array2[rectanglePosition+1].getOn()== 1|| array2[rectanglePosition-20].getOn()==1 || array2[rectanglePosition+20].getOn() == 1 || array2[rectanglePosition-1].getOn() == 1)
            if(rand>5)
                setOn(0);
            else
                setOn(2);

        if(array2[rectanglePosition+1].getOn() != 3 && array2[rectanglePosition-20].getOn()!=3 && array2[rectanglePosition+20].getOn() != 3 && array2[rectanglePosition-1].getOn() != 3)
                setOn(0);

    }
}
