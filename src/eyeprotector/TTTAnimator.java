/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyeprotector;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davide
 */
public class TTTAnimator implements Runnable{

    private double animTimeSec;
    private ActionsVisualizer visual;   
    private final static double CYCLE_DECREASE = 0.2;
    private final static double CYCLE_MAX = 100.0;
    
    public TTTAnimator(double animTimeSec, ActionsVisualizer visual) {
        this.animTimeSec = animTimeSec;
        this.visual = visual;
    }

    
    
    @Override
    public void run() {
        double iters = CYCLE_MAX/CYCLE_DECREASE;
        int wait = (int)((animTimeSec*1000)/iters);
        
        for (double d = 100; d >= 0; d-=CYCLE_DECREASE)
        {
            try {
                visual.setDraw202020Perc(d);
                Thread.sleep(wait);
            } catch (InterruptedException ex) {
                Logger.getLogger(TTTAnimator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
