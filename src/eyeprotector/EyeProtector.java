/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeprotector;

import com.sun.awt.AWTUtilities;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author Davide
 */
public class EyeProtector {

    public static void main(String[] args) throws IOException, InterruptedException {
    
        BufferedImage img = UIUtils.readImageResource("eye2.png");
        
        Overlay o = new Overlay();
        
        ActionsVisualizer v = new ActionsVisualizer();
        
        o.add(v);
                
        o.start();
        
        
        ScheduledExecutorService ex = Executors.newScheduledThreadPool(1);
        
        ex.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    v.setDrawEye(true);
                    Thread.sleep(100);
                    v.setDrawEye(false);
                } catch (InterruptedException ex1) {
                    Logger.getLogger(EyeProtector.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }, 5, 5, TimeUnit.SECONDS);
        
        TTTAnimator anim = new TTTAnimator(20, v);
        
        ex.scheduleWithFixedDelay(anim, 20, 20, TimeUnit.MINUTES);
        
    }
}
