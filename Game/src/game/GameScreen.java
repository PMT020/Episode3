
package game;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;


public class GameScreen extends JPanel {
    
    
    
  
    
    
    private Random random;
    
    private BufferedImage img;
    
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    
    private long lastTime;
    
    private int Frames;
    
    private double timesPerFrame;
    
    private long LastFrame;
    
    
        
        
    
    
    public GameScreen(BufferedImage img){
        this.img = img;
        
        loadSprites();
        
        
        random = new Random();
        
        
    }
    
     private void loadSprites(){
        
        
        for(int y = 0; y < 10; y++ ){
            for(int x = 0; x < 10; x++){
                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        
       
       //g.drawImage(img.getSubimage(SingleSprite * MoveSpriteX , SingleSprite * MoveSpriteY, SingleSprite, SpriteHeight), 0, 0, null);
       //g.drawImage(sprites.get(10), 0, 0, null);
       
       for(int y = 0; y < 29; y++){
           for(int x = 0; x < 29; x++){
               g.drawImage(sprites.get(getRandInt()), x * 32, y *32, null);
           }
       }
       
     
       
       CallFPS();
    }
    
    private void CallFPS(){
          Frames++;
       if(System.currentTimeMillis() - lastTime >= 1000){
        System.out.println("FPS = " + Frames);
        Frames = 0;
        lastTime = System.currentTimeMillis();
    }
    }
    
    private int getRandInt(){
        return random.nextInt(100);
    }
    
   
}
