import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.TitledBorder;
class EggMover{
    
    ActionListener al;
    Timer timer;
    Egg egg;
    Bowl b;
    boolean allowed=true;
    
    public EggMover(Egg eg,Bowl bl){
    egg=eg;
    b=bl;
    al=new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            egg.setMy(egg.MY+1);
            if(isAllowed()){
                if(egg.fallsInBowl(b)){
                    egg.reset();
                    b.updateScore();
                }
            }
                if(egg.r.y+egg.r.height>b.r.y+b.r.height/2&&!egg.fallsInBowl(b)){
                    allowed=false;
                    if(egg.r.y+egg.r.height*2>=275){
                        egg.reset();
                        b.lifes-=1;
                        b.score-=10;
                        b.updateLife();
                    }
                }
            
                else{
                    allowed=true;
               }
        }
    };
    timer= new Timer(5,al);
    }
    void setInitialDelay(int i){
        timer.setInitialDelay(i);
    }
    
    boolean isAllowed(){
        return allowed;
    }
    
    void move(){
        timer.start();
    }
    
    void stop(){
        timer.stop();
    }
}
