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
import com.sun.jna.platform.win32.WinUser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Window;
import javax.swing.JFrame;

/**
 *
 * @author Davide
 */
public class Overlay extends JFrame{

    public Overlay() throws HeadlessException {
        setUndecorated(true);
    }

        
    public void start (){
        pack();
        setBounds(this.getGraphicsConfiguration().getBounds());
        setLocationRelativeTo(null);
        
        setAlwaysOnTop(true);
        AWTUtilities.setWindowOpaque(this, false);
        setTransparent(this);
        
        setBackground(new Color (0, true));
        
        setVisible(true);
    }
    
    private static void setTransparent(Component w) {
        WinDef.HWND hwnd = getHWnd(w);
        int wl = User32.INSTANCE.GetWindowLong(hwnd, WinUser.GWL_EXSTYLE);
        wl = wl | WinUser.WS_EX_LAYERED | WinUser.WS_EX_TRANSPARENT;
        User32.INSTANCE.SetWindowLong(hwnd, WinUser.GWL_EXSTYLE, wl);
    }

    /**
     * Get the window handle from the OS
     */
    private static WinDef.HWND getHWnd(Component w) {
        WinDef.HWND hwnd = new WinDef.HWND();
        hwnd.setPointer(Native.getComponentPointer(w));
        return hwnd;
    }
    
    public void stop()
    {
        setVisible(false);
    }
    
}
