/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeprotector;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Davide
 */
public class UIUtils {
    
    public static final String RESOURCE_FOLDER = "/res/";
    
    public static BufferedImage readImageResource (String resourceName) throws IOException
    {
        try {
            return ImageIO.read(EyeProtector.class.getResourceAsStream(RESOURCE_FOLDER + resourceName));
        } catch (IOException ex) {
            Logger.getLogger(UIUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        throw new IOException("Resource couldn't be found");
    }
}
