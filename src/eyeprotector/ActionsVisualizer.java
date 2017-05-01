/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeprotector;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Davide
 */
public class ActionsVisualizer extends JPanel{
    
    private boolean drawEye = false;
    private double draw202020Perc = 0;

    public ActionsVisualizer() {
        setBackground(new Color(0, true));
        setOpaque(false);
    }
    
    
    
    protected void paintComponent(Graphics g) {
                
                super.paintComponent(g);
                
               
                
                Graphics2D g2 = (Graphics2D)g;
                
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                
                g2.setColor(new Color(1, 1, 1, 0));
                g2.fillRect(0, 0, getHeight(), getWidth());
                
                if (drawEye)
                {
                    try {
                        BufferedImage img = UIUtils.readImageResource("eye2.png");
                        
                        g2.drawImage(img, getWidth()/2-img.getWidth()/2, getHeight()/2-img.getHeight()/2, null);

                    } catch (IOException ex) {
                        Logger.getLogger(EyeProtector.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                if(draw202020Perc > 0)
                {
                    g2.setColor(new Color(0, 0, 0, 50));
                    
                    int x = (int)((1-draw202020Perc/100.0)*getWidth());
                    int width = (int)((draw202020Perc/100.0)*getWidth());
                    
                    g2.fillRect(x, 0, width, getHeight());
                }
                
    }

    public void setDrawEye(boolean drawEye) {
        this.drawEye = drawEye;
        repaint();
    }
    
    public void setDraw202020Perc (double perc){
        this.draw202020Perc = perc;
        repaint();
    }
    
    
}
