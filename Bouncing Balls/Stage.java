import java.lang.Math;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;


/**
 * Stage Class - Creates and handles the interface for the game, creates and runs levels when needed
 */
public class Stage implements ActionListener{

//data
//private int windowHeight = 800;
//private int windowLength = 500;
private GameArena game = new GameArena(1000,700);
private JFrame window;
private JPanel mainPanel = new JPanel();
private GridBagLayout layout = new GridBagLayout();
private GridBagConstraints c = new GridBagConstraints();
private JLabel titleLabel = new JLabel("~~ Welcome To Brick Breaker ~~");
private JButton[] levelButtons = new JButton[3];
private JButton backButton = new JButton("Back");
private int levelToPlay = 0;
private int levelStatusCode = -1;
private Text introText = new Text("Welcome To Brick Breaker",-250,game.getArenaHeight()/2,400,"WHITE");
private Text infoText = new Text("Pick a Level to play from the right hand panel\nUse the arrow keys to aim and the space key fire balls in the direction of the arrow\nBreak bricks by hitting them the amount of times\ndisplayed on them\nHit white circles to gain extra balls, Hit Green balls to toggle gravity on and off\nYou win the level by destroying all of the bricks, you loose if any of the bricks hit the bottom of the screen.\n      Good luck!",20,game.getArenaHeight()-170,17,"GHOSTWHITE");

//methods


    /**
     * Constructor for the stage. Creates the frames, panels and adds content to them such as titles, buttons to change level and the GameArena
     */
    public Stage(){
        //set up window
        window = new JFrame();
        window.setTitle("Brick Breaker");
        window.setContentPane(mainPanel);
        mainPanel.setLayout(layout);

        //Add GameArena
        c.gridx = 0; c.gridwidth = 3; c.gridy = 0; c.gridheight = 5;
        game.addGamePanel(mainPanel,c); //uses custom method in GameArena to do this
        //Add 'Title' Text Label
        c.gridwidth = 1; c.gridheight = 1; c.gridx = 3; c.weighty = 0.5;
        mainPanel.add(titleLabel,c);

        //colour the main panel
        mainPanel.setBackground(Color.black);

        //colour the panel text
        titleLabel.setForeground(Color.white);

        //add White border line between game arena and buttons
        Line border = new Line(game.getArenaWidth(),game.getArenaHeight(),game.getArenaWidth(),0,1,"WHITE");
        game.addLine(border);


        //Add buttons to button array and add buttons to panel
        for(int i = 0;i<3;i++){
            c.gridy = i+1;
            JButton button = new JButton();
            levelButtons[i] = button;
            mainPanel.add(levelButtons[i],c);
            levelButtons[i].addActionListener(this);

        }
        //Give text to Buttons
        levelButtons[0].setText("Easy");
        levelButtons[1].setText("Medium");
        levelButtons[2].setText("Hard");
        
        //Add 'Back' Button
        c.gridy = 4;
        mainPanel.add(backButton,c);
        backButton.addActionListener(this);

        //Finalize window settings
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;

        //Add text to intro
        game.addText(introText);
        for (int i = 0;i<36;i++){
            introText.setXPosition(introText.getXPosition()+14);
            introText.setSize(introText.getSize()-10);
            game.update();
        }
        game.addText(infoText);


        //finally update the GameArena to reflect these changes
        game.update();
    }
    /**
    * Main Loop - waits for a 'level' to be set when a button is clicked, then the level is made in this loop - to avoid Illegal monitorState exceptions
    */
    public void play(){    
        while(true){
            // do nothing wilst waiting for a level to be selected        
            try { Thread.sleep(0); }
            catch (Exception e) {};
            //level to play has been set to 1 - start the 'easy' level
            if(levelToPlay == 1){
                infoText.setText("");
                Level easy = new Level(game,10,2,6,20,1,22,0.35,0.1,0.5,0.2,0.8,backButton);
                levelStatusCode = easy.play();
                if(levelStatusCode == 1){
                    infoText.setText("Well Done! Easy level completed. Try the Medium Level \n Pick a Level to play from the right hand panel");
                }
                if(levelStatusCode == 0){
                    infoText.setText("Easy Level Failed, try again!");
                    levelToPlay = -1;
                }
                levelToPlay = 0;
                game.addText(introText);
                game.update();
            }
            //level to play has been set to 2 - start the 'medium' level
            if(levelToPlay == 2){
                infoText.setText("");
                Level medium = new Level(game,20,3,5,25,2,32,0.3,0.1,0.5,0.2,0.8,backButton);
                levelStatusCode = medium.play();
                if(levelStatusCode == 1){
                    infoText.setText("Well Done! Medium level completed. Try the Hard Level \n Pick a Level to play from the right hand panel");
                }
                if(levelStatusCode == 0){
                    infoText.setText("Medium Level failed - try again");
                    levelToPlay = -1;
                }
                levelToPlay = 0;
                game.addText(introText);
                game.update();
            }
            //level to play has been set to 3 - start the 'hard' level
            if(levelToPlay == 3){
                infoText.setText("");
                Level hard = new Level(game,35,3,6,35,4,60,0.2,0.2,1,0.2,0.8,backButton);
                levelStatusCode = hard.play();
                if(levelStatusCode == 1){
                    infoText.setText("Well Done! Hard level completed. \n Pick a Level to play from the right hand panel");
                }
                if(levelStatusCode == 0){
                    infoText.setText("Hard Level failed - try again");
                    levelToPlay = -1;
                }
                
                levelToPlay = 0;
                game.addText(introText);
                game.update();
            }
        }   
    }


    /**
     * Action lister for the level select buttons, changes the 'levelToPlay' according to which button has been pressed
     * @param e e is the name of the action event
     */
    public void actionPerformed(ActionEvent e) {

        game.removeText(introText);
        if(e.getSource() == levelButtons[0]){
 
            levelToPlay = 1;
        }
        if(e.getSource() == levelButtons[1]){
 
            levelToPlay = 2;
        }
        if(e.getSource() == levelButtons[2]){
 
            levelToPlay = 3;
        }
        if(e.getSource() == backButton){

            System.out.println("Back"); 
            infoText.setText("Pick a Level to play from the right hand panel");
     

        }
    }


}
