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
class Egg{

    int MX,MY;
    Rectangle r;
    Random random= new Random();
    
    Egg(){
        
    }
    
    boolean fallsInBowl(Bowl b){
        return r.intersects(b.r);
    }
    
    void setMx(int dx){
       MX=dx; 
    }
    
    void setMy(int dy){
        MY=dy;
    }
    
    public void reset(){
        setMy(30);
        setMx(30+random.nextInt(Main.FWIDTH-40));
    }
    
    void drawOn(Graphics2D g){
        GradientPaint gp= new GradientPaint(MX,MY,Color.GRAY.brighter(),MX+5,MY+15/2,Color.lightGray.brighter());
        g.setPaint(gp);
        g.fillOval(MX, MY, 10, 15);
        r=new Rectangle(MX,MY,10,15/2);
    }
}