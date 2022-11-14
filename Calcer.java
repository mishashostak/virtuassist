import javax.swing.*;
import java.awt.Color;

/**
 * This class defines the color-wise portion of the virtual agent
 * 
 * @author Misha Shostak
 * 
 * @version November 14, 2022
 */
public class Calcer{
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
        ColorChoice cc = new ColorChoice();
        while(true){
            SwingUtilities.invokeLater(() -> cc.setVisible(true));
            blendc0 = cc.getColorChoi();
            if(blendc0 == null){
                break;
            }
        }
        while(true){
            SwingUtilities.invokeLater(() -> cc.setVisible(true));
            blendc1 = cc.getColorChoi();
            if(blendc1 == null){
            break;
            }
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
        System.out.println("What is Color 1/2 for blending (");
        
        JFrame frame = new JFrame("Blend of 2 colors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBackground(b);
        JOptionPane.showMessageDialog(null,"","Blended Colour", JOptionPane.INFORMATION_MESSAGE);
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
