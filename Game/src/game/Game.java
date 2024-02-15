
package game;

import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class Game extends JFrame {
    
   private GameScreen gameScreen;
   
   private BufferedImage SpriteSheet;
   
    private double timesPerFrame;
    
    private long LastFrame;
   
    private int Frames;
   

   public Game(){
       
       timesPerFrame = 100000000.0 / 60.0;
       
       
       importSprite(); //Calls method to find the grass in folder path
       
        
       setSize(640, 640);
       
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       gameScreen = new GameScreen(SpriteSheet);
       add(gameScreen);
       setVisible(true);
       //Adds the Screen
       
   }
   
   public void importSprite(){
       
       InputStream is = getClass().getResourceAsStream("/SpriteSheet/SpriteSheet.png"); //Finds the Path for the images
       try {       
           SpriteSheet = ImageIO.read(is);
       } catch (IOException ex) {
           Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
       }
      
         
       
       
       
   }
   private void LoopGame(){
       while(true){
         if(System.nanoTime()- LastFrame >= timesPerFrame){
           
          
           
           LastFrame = System.nanoTime();
           repaint();
       }else{
           //Do nothing
       }
   }
   }
   //Creates Window and calls "gameScreen" Class
    public static void main(String[] args) {
        Game game = new Game();
        game.LoopGame();
        //Calls the Constructor that opens window
    }
    
}
