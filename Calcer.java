import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;

/**
 * This class defines the color-wise portion of the virtual agent
 * 
 * @author Misha Shostak
 * 
 * @version November 14, 2022
 */
public class Calcer {
    
    /**
     * This is a constant array with all common colour RGB values
     */
    static final String[] COLSTR = {
        "(0,0,0)","(255,255,255)","(255,0,0)","(0,255,0)",
        "(0,0,255)","(255,255,0)","(0,255,255)","(255,0,255)",
        "(192,192,192)","(128,128,128)","(128,0,0)","(128,128,0)",
        "(0,128,0)","(128,0,128)","(0,128,128)","(0,0,128)"
    };

    /**
     * Parameterized constructor which calls the blend method
     * 
     * @param a Color of choice1
     * @param b Color of choice2
     */
    public Calcer(Color a, Color b) {
        if(b == null){
            System.err.println("b");
        } else if(a == null){
            System.err.println("a");
        }
        else {
            blend(a, b);
        }
    }

    /**
     * Non-parameterized constructor
     */
    public Calcer(){}
    
    /**
     * This method accepts 2 colours and returns the Color value of the 2 colours blended
     * 
     * @param c0 The Color value of the first colour to be blended
     * @param c1 The Color value of the second colour to be blended
     * 
     * @return Color - The Color value of the blend of c0 and c1 
     */
    public static void blend(Color c0, Color c1) {
        double totalAlpha = c0.getAlpha() + c1.getAlpha();
        double weight0 = c0.getAlpha() / totalAlpha;
        double weight1 = c1.getAlpha() / totalAlpha;
    
        double r = weight0 * c0.getRed() + weight1 * c1.getRed();
        double g = weight0 * c0.getGreen() + weight1 * c1.getGreen();
        double b = weight0 * c0.getBlue() + weight1 * c1.getBlue();
        double a = Math.max(c0.getAlpha(), c1.getAlpha());
    
        blendOutput(new Color((int) r, (int) g, (int) b, (int) a));
    }

    /**
     * This method outputs the blended colour via JOptionPane
     * 
     * @param b The Color value of the blended colour
     */
    public static void blendOutput(Color b) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(550, 300));
        frame.getContentPane().setBackground(b);
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * This is a standard toString() method.  
     * 
     * @return String - The String representation of the current object.
     */
    public String toString() {
        return super.toString();
    }
}
