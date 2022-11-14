import javax.swing.*;
import java.awt.Color;
import java.util.*;

/**
 * This class defines the color-wise portion of the virtual agent
 * 
 * @author Misha Shostak
 * 
 * @version November 13, 2022
 */
public class Calcer{
    /**
     * Instance variables for the blend functionality
     */
    private Color blendc0, blendc1;
    
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
     * This method defines the user's input colours for blending
     */
    public void blendInput() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Do you have the name of the FIRST colour or would you like to pick it?\n\"name\" if you'd like to input the name of a colour\n\"pick\" if you'd like to pick a colour");
            while(true){
                String namOrPick1 = input.nextLine().toLowerCase();
                if (namOrPick1.equals("name")){
                    System.out.println("What colour did you have in mind?");
                    blendc0 = getColor(input.nextLine());
                    break;
                }
                if (namOrPick1.equals("pick")){
                    blendc0 = JColorChooser.showDialog(null, "Pick the first Colour", Color.BLACK);
                    break;
                }
            }
            System.out.println("Do you have the name of the SECOND colour or would you like to pick it?\n\"name\" if you'd like to input the name of a colour\n\"pick\" if you'd like to pick a colour");
            while(true){
                String namOrPick2 = input.nextLine().toLowerCase();
                if (namOrPick2.equals("name")){
                    System.out.println("What colour did you have in mind?");
                    blendc1 = getColor(input.nextLine());
                    break;
                }
                if (namOrPick2.equals("pick")){
                    blendc1 = JColorChooser.showDialog(null, "Pick the second Colour", Color.BLACK);
                    break;
                }
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
     * This methods takes a String and returns that string's corresponding Color value
     * 
     * @param col The String value of the string being converted
     * 
     * @return Color - The Color value of the suspected corresponding colour of the param string
     */
    public Color getColor(String col) {
        Color color = Color.WHITE;
        switch (col.toLowerCase()) {
        case "black":
            color = Color.BLACK;
            break;
        case "blue":
            color = Color.BLUE;
            break;
        case "cyan":
            color = Color.CYAN;
            break;
        case "darkgray":
            color = Color.DARK_GRAY;
            break;
        case "gray":
            color = Color.GRAY;
            break;
        case "green":
            color = Color.GREEN;
            break;
        case "yellow":
            color = Color.YELLOW;
            break;
        case "lightgray":
            color = Color.LIGHT_GRAY;
            break;
        case "magneta":
            color = Color.MAGENTA;
            break;
        case "orange":
            color = Color.ORANGE;
            break;
        case "pink":
            color = Color.PINK;
            break;
        case "red":
            color = Color.RED;
            break;
        case "white":
            color = Color.WHITE;
            break;
            }
        return color;
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
