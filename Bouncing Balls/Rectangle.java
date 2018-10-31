/**
 * Models a simple, solid rectangle. 
 * This class represents a Rectangle object. When combined with the GameArena class,
 * instances of the Rectangle class can be displayed on the screen.
 */
import java.util.ArrayList;
public class Rectangle 
{
    // The following instance variables define the information needed to represent a Ball
    // Feel free to more instance variables if you think it will support your work...
    private double xPosition;            // The X coordinate of this Rectangle
    private double yPosition;            // The Y coordinate of this Rectangle
    private double width;                // The width of this Rectangle
    private double height;               // The height of this Rectangle
    private String colour;               // The colour of this Rectangle
    private int health;                  // Health of the rectangle
    private Text hpText;                 // Displays how much health the rectangle has in the GameArena
    private GameArena game;              // GameArena used
    private ArrayList<Rectangle> list;    // rectangle array list

    /**
     * Remove helth method
     * Decreaces the called on rectangles health variable by 1
     * Updates the rectangles text to reflect this change
     */
    public void removeHealth(){
        health--;
        hpText.setText(Integer.toString(health));
    }

    /**
     * Returns the health of the rectangle
     * @return  The health of the rectangle is returned as an int
     */
    public int getHealth(){
        return health;
    }

    /**
     * Sets the colour of the rectangle according to its current health
     */
    public void colourHealth(){
        if(health > 50)
            setColour("PURPLE");
        if(health < 50)
            setColour("DARKRED");
        if(health < 40)
            setColour("RED");
        if(health < 30)
            setColour("ORANGERED");
        if(health < 25)
            setColour("ORANGE");
        if(health < 20)
            setColour("YELLOW");
        if(health < 15)
            setColour("YELLOWGREEN");
        if(health < 10)
            setColour("LIGHTGREEN");
        if(health < 5)
            setColour("LIGHTYELLOW");

    }

    /**
     * Obtains the current position of this Rectangle.
     * @return the X coordinate of this Rectangle within the GameArena.
     */
    public double getXPosition()
    {
        return xPosition;
    }

    /**
     * Obtains the current position of this Rectangle.
     * @return the Y coordinate of this Rectangle within the GameArena.
     */
    public double getYPosition()
    {
        return yPosition;
    }

    /**
     * Moves the current position of this Rectangle to the given X co-ordinate
     * @param x the new x co-ordinate of this Rectangle
     */
    public void setXPosition(double x)
    {
        this.xPosition = x;
    }

    /**
     * Moves the current position of this Rectangle to the given Y co-ordinate
     * @param y the new y co-ordinate of this Rectangle
     */
    public void setYPosition(double y)
    {
        this.yPosition = y;
    }

    /**
     * Obtains the width of this Rectangle.
     * @return the width of this Rectangle,in pixels.
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * Changes the width of this Rectangle to the given value
     * @param w the new width of this rectangle, in pixels.
     */
    public void setWidth(double w)
    {
        width = w;
    }

    /**
     * Obtains the height of this Rectangle.
     * @return the height of this Rectangle,in pixels.
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * Changes the height of this Rectangle to the given value
     * @param h the new height of this rectangle, in pixels.
     */
    public void setHeight(double h)
    {
        height = h;
    }

    /**
     * Obtains the colour of this Rectangle.
     * @return a textual description of the colour of this Rectangle.
     */
    public String getColour()
    {
        return colour;
    }



    /**
     * Changes the colour of this Rectangle to the given value.
     * 
     * @param c The new colour of this Rectangle. 
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
     */
    public void setColour(String c)
    {
        colour = c;
    }

    /**
     * Constructor. Create a new instance of a Rectangle.
     *
     * @param x The X co-ordinate in the GameArena where this Rectangle will initially be located.
     * @param y The Y co-ordinate in the GameArena where this Rectangle will initially be located.
     * @param w The width of the Rectangle in pixels.
     * @param h The height of the Rectangle in pixels.
     * @param col. The colour of the Ball. @see setColour for a description of permissable colours.
     * @param passedhealth  The health the rectangle should be given
     * @param gameP         The GameArena that the rectangle should be created in
     * @param rectangleList A list of rectangles passed in that when created, this rectangle is added to
     * @param rectangleNo   The number this rectangle is assigned, is used to identify it
     */
    public Rectangle(double x, double y, double w, double h, String col, int passedhealth, GameArena gameP ,ArrayList<Rectangle> rectangleList, int rectangleNo)
    {
        game = gameP;
        xPosition = x;
        yPosition = y;
        width = w;
        height = h;
        colour = col;
        health = passedhealth;
        list = rectangleList;
        hpText = new Text(Integer.toString(health),10,10,15,"BLACK");
        hpText.setXPosition(getXPosition()-5);
        hpText.setYPosition(getYPosition());
        colourHealth();
        rectangleList.add(rectangleNo,this);
        game.addRectangle(this);
        addHealthText();


    }
        public Rectangle(double x, double y, double w, double h, String col)
    {

        xPosition = x;
        yPosition = y;
        width = w;
        height = h;
        colour = col;
        


    }

    /**
     * Move down Method - moves the rectangles down by a given amount (amount)
     * @param amount    - how many pixels to move the rectangle down by
     */
    public void moveDown(double amount){
        setYPosition(getYPosition() + amount);
        hpText.setXPosition(getXPosition()-5);
        hpText.setYPosition(getYPosition());
    }

    /**
     * Check Health Method - if health is below or equal to 0, the rectangle is 'dead' and hence is removed from the list and GameArena given in the constructor
     * @param positionInList    - which rectangle (with position number (positionInList) should be checked
     */
    public void checkHealth(int positionInList){
        if(getHealth() <= 0){
            game.removeRectangle(this);
            game.removeText(hpText);
            list.remove(positionInList);
        }
    }

    /**
     * Removes from the GameArena given in the constructor the rectangles text displaying its health
     */
    public void removeRectangleText(){
        game.removeText(hpText);

    }

    /**
     * Creates in the GameArena given in the constructor a text asset that displays the health of the rectangle it is created on.
     */
    public void addHealthText(){
        game.addText(hpText);
    }

}
