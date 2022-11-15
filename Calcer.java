import javax.swing.*;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * This class defines the color-wise portion of the virtual agent
 * 
 * @author Misha Shostak
 * 
 * @version November 14, 2022
 */
public class Calcer implements WindowListener{
    /**
     * Instance variables of 2 Colors for the blend functionality
     */
    private Color blendc0;
    private Color blendc1;
    
    /**
     * This is a constant array with all common colour RGB values
     */
    final String[] colStrings = {
        "(0,0,0)","(255,255,255)","(255,0,0)","(0,255,0)",
        "(0,0,255)","(255,255,0)","(0,255,255)","(255,0,255)",
        "(192,192,192)","(128,128,128)","(128,0,0)","(128,128,0)",
        "(0,128,0)","(128,0,128)","(0,128,128)","(0,0,128)"
    };

    /**
     * Non-parameterized constructor which initializes instance variables
     * The initial blendc0 Color value is null
     * The initial blendc1 Color value is null
     */
    public Calcer() {
        blendc0 = null;
        blendc1 = null;
    }

    /**
     * This method defines the user's input colours for blending utilizing the ColorChoice class
     */
    public void blendInput() {
        ColorChoice c0 = new ColorChoice();
        while(true){
            while(c0.getColorChoi()==null){
                SwingUtilities.invokeLater(() -> c0.setVisible(true));
            }
            blendc0 = c0.getColorChoi();
            break;
        }
        ColorChoice c1 = new ColorChoice();
        while(true){
            while(c1.getColorChoi()==null){
                SwingUtilities.invokeLater(() -> c1.setVisible(true));
            }
            blendc1 = c1.getColorChoi();
            break;
        }
        Color blendFinal = blend(blendc0, blendc1);
        blendOutput(blendFinal);
    }
    
    /**
     * This method accepts 2 colours and returns the Color value of the 2 colours blended
     * 
     * @param c0 The Color value of the first colour to be blended
     * @param c1 The Color value of the second colour to be blended
     * 
     * @return Color - The Color value of the blend of c0 and c1 
     */
    public Color blend(Color c0, Color c1) {
        double totalAlpha = c0.getAlpha() + c1.getAlpha();
        double weight0 = c0.getAlpha() / totalAlpha;
        double weight1 = c1.getAlpha() / totalAlpha;
    
        double r = weight0 * c0.getRed() + weight1 * c1.getRed();
        double g = weight0 * c0.getGreen() + weight1 * c1.getGreen();
        double b = weight0 * c0.getBlue() + weight1 * c1.getBlue();
        double a = Math.max(c0.getAlpha(), c1.getAlpha());
    
        return new Color((int) r, (int) g, (int) b, (int) a);
    }

    /**
     * This method outputs the blended colour via JOptionPane
     * 
     * @param b The Color value of the blended colour
     */
    public void blendOutput(Color b) {
        JFrame frame = new JFrame("Blend of 2 colors");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(b);
        frame.setForeground(b);
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setLocation(400, 400);
        frame.pack();
        frame.addWindowListener(this);
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

    /**
     * Overriding methods of WindowListener which define behaviour depend on the status of the window
     * 
     * @param e WindowEvent object
     */

    /*overriding windowActivated() method of WindowListener interface*/
     @Override
    public void windowActivated(WindowEvent e) {
    }
    
    /**
     * Overriding windowClosed() method of WindowListener interface which prints the given string when window is closed
     * 
     * @param e WindowEvent object
     */  
    @Override
    public void windowClosed(WindowEvent e) {

    }

    /*overriding windowClosing() method of WindowListener interface which prints the given string when we attempt to close window from system menu*/
    @Override
    public void windowClosing(WindowEvent e) {
    }
    /*overriding windowDeactivated() method of WindowListener interface which prints the given string when window is not active*/
    @Override
    public void windowDeactivated(WindowEvent e) {  
    }
    /*overriding windowDeiconified() method of WindowListener interface which prints the given string when window is modified from minimized to normal state*/
    @Override
    public void windowDeiconified(WindowEvent e) {
    }
    /*overriding windowIconified() method of WindowListener interface which prints the given string when window is modified from normal to minimized state*/
    @Override
    public void windowIconified(WindowEvent e) {
    }
    /*overriding windowOpened() method of WindowListener interface which prints the given string when window is first opened*/
    @Override
    public void windowOpened(WindowEvent e) {
    }
}
