
import java.awt.Color;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.JLabel;

class Bowl{

    int MX,MY;
    Rectangle r;
    JLabel l;
    int score=0,lifes=10;
    Bowl(){
    }
    
    void setMx(int dx){
        MX=dx;
    }
    
    void setOutputComponent(JLabel lb){
        l=lb;
    }
    
    void updateScore(){
      l.setText("Score = "+ (score+=10)+"          Lifes = "+(lifes));
    }
    
    void updateLife(){
        l.setText("Score = "+ (score+=10)+"          Lifes = "+(lifes));
    }
    
    void setMy(int dy){
        MY=dy;
    }
    
    boolean contains(Point p){
        return r.contains(p);
    }
    
    void drawOn(Graphics2D g){
        GradientPaint gp1= new GradientPaint(MX-15,MY-10,Color.LIGHT_GRAY,MX-15+30/2,MY-10+30/2,Color.WHITE,true);
        g.setPaint(gp1);
        g.fillArc(MX-15, MY-10, 30, 30, 0, -180);
        GradientPaint gp2= new GradientPaint(MX,MY,Color.WHITE,MX,MY+10,Color.DARK_GRAY.brighter());
        g.setPaint(gp2);
        g.fillOval(MX-15, MY, 30, 10);
        r=new Rectangle(MX-15,MY,30,20);
    }
}