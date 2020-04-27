//Author: Soren Thrawl

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

class tTile extends JPanel implements MouseListener{
    private boolean isRed;

    tTile(Boolean t) {
        super();
        
        isRed = true;
        addMouseListener(this);
    }

    tTile() {
        super();
        isRed = false;

        addMouseListener(this);
    }
    
    public void setToRed(){
        isRed = true;
    }

    public String toString(){
       return "";
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isRed) {
            g.setColor(Color.red);
            g.fillRect(0, 0, 100, 100);
        }
        
    }

    
    public void mouseClicked(MouseEvent e){
        System.out.println("Clicked");
        isRed = false;
        repaint();
    };

    public void mouseReleased(MouseEvent e){};
    public void mouseExited(MouseEvent e) {};
    public void mouseEntered(MouseEvent e){};
    public void mousePressed(MouseEvent e){};
}