import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Game extends JPanel implements KeyListener
{
    private Player player;
    private ArrayList <Enemy> enemies;
    private ArrayList<Bullet> bullets;
    private ArrayList <Cover> covers;
    
    //constructor - sets the initial conditions for this Game object
    public Game(int width, int height) //1000, 800
    {
        //make a panel with dimensions width by height with a black background
        this.setLayout( null );//Don't change
        this.setBackground( Color.BLACK );
        this.setPreferredSize( new Dimension( width, height ) );//Don't change

        //initialize the instance variables
        player = new Player(500,500,50,60);
        enemies = new ArrayList<Enemy>(2);
        	enemies.add(new Enemy(400,5,5,5));
        	enemies.add(new Enemy(410,5,5,5));
        bullets = new ArrayList<Bullet>(0);
        covers = new ArrayList<Cover>(0);
       
        this.addKeyListener(this);//allows the program to respond to key presses - Don't change

        this.setFocusable(true);//I'll tell you later - Don't change
    }

    //This is the method that runs the game
    public void playGame()
    {
        boolean over = false;
        while( !over )
        {
            
            try
            {
            	player.act();//calls the draw method in the Player class
                for(Enemy ship : enemies){
                  ship.act();
                }
                for(Bullet booom : bullets){
                  booom.act();
                }
                for(Cover cover : covers){
                  cover.act();
                }
                Thread.sleep( 20 );//pause for 200 milliseconds
            }catch( InterruptedException ex ){}
            
            this.repaint();//redraw the screen with the updated locations; calls paintComponent below
        }
    }

    //Precondition: executed when repaint() or paintImmediately is called
    //Postcondition: the screen has been updated with current player location
    public void paintComponent( Graphics page )
    {
        super.paintComponent( page );//I'll tell you later.
        player.draw( page );//calls the draw method in the Player class
        for(Enemy ship : enemies){
          ship.draw(page);
        }
        for(Bullet booom : bullets){
          booom.draw(page);
        }
        for(Cover cover : covers){
          cover.draw(page);
        }
    }

    //not used but must be present
    public void keyReleased( KeyEvent event )
    {  
        if( event.getKeyCode() == KeyEvent.VK_RIGHT ){
            player.setAct("stay");
        }else if( event.getKeyCode() == KeyEvent.VK_LEFT ){
            player.setAct("stay");
        } 

    }

    //tells the program what to do when keys are pressed
    public void keyPressed( KeyEvent event )
    {
        if( event.getKeyCode() == KeyEvent.VK_RIGHT ){
            player.setAct("moveRight");
        }else if( event.getKeyCode() == KeyEvent.VK_LEFT ){
            player.setAct("moveLeft");
        } 

    }

    //not used but must be present
    public void keyTyped( KeyEvent event )
    {
    	
    }

    public boolean objectsCollided(Thing one, Thing two){
        int[] bb1 = one.getBoundingBox();
        int[] bb2 = two.getBoundingBox();
        boolean v1 = bb2[1] > bb1[1] && bb2[1] < bb1[3];
        boolean v2 = bb2[3] > bb1[1] && bb2[3] < bb1[3];
        boolean h1 = bb2[0] > bb1[0] && bb2[0] < bb1[2];
        boolean h2 = bb2[2] > bb1[0] && bb2[2] < bb1[2];
        return (v1 || v2) && (h1 || h2);
    }
}