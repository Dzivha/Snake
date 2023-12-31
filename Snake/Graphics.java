import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Graphics extends JPanel implements ActionListener  {
    private Timer t= new Timer(100, this);
    public String state;
    private Snake s;
    private Food f;
    private Game game;

    public Graphics(Game g) {
        t.start();
        state="START";
        game=g;
        s=g.getPlayer();
        f=g.getFood();
        
        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0,0,Game.width*Game.dimension+5, Game.height*Game.dimension+5);

        if(state.equalsIgnoreCase("START")){
            g2d.setColor(Color.white);
            g2d.drawString("Press Space", Game.width/2 * Game.dimension - 40, Game.height/2 * Game.dimension - 20);
        }
        else if(state.equalsIgnoreCase("RUNNING")){
            
            g2d.setColor(Color.red);
            g2d.fillRect(f.getX()*Game.dimension,f.getY()*Game.dimension,Game.dimension,Game.dimension);
            

            g2d.setColor(Color.green);
            for(Rectangle r:s.getBody()){
            g2d.fill(r);
        }
         }
        else {
            g2d.setColor(Color.white);
            g2d.drawString("Score: " + (s.getBody().size()-3), Game.width/2 * Game.dimension - 40, Game.height/2 * Game.dimension - 20);
        }

        }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
        game.update();
    }
    
}
