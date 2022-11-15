import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class defines the ability for the user to input colors
 * using JOptionPanes
 * 
 * @author Misha Shostak
 * 
 * @version November 14, 2022
 */
public class ColorChoice extends JFrame implements ActionListener {
    /**
     * Instance variables for elegant functionality of the class
     */
    public static final String DIALOG_NAME = "what-dialog";
    public static final String PANE_NAME = "what-pane";
    private JButton buttonP;
    private JButton buttonN;
    private JPanel fp;
    private Color choice;

    /**
     * Non-parameterized constructor which resets all instance variable and calls the initUI method
     */
    public ColorChoice() {
        buttonP = null;
        buttonN = null;
        fp = null;
        choice = null;
        initUI();
    }

    /**
     * Accessor to return the Color value choice, the user's chosen Color
     *
     * @return Color - The Color value of choice
     */
    public Color getColorChoi() {
        return choice;
    }

    /**
     * Mutator to set a new value for choice to the user's new chosen Color
     *
     * @param newCol The new Color value to set choice to
     */
    public void setColorChoi(Color newCol) {
        choice = newCol;
    }

    /**
     * This method initializes the JOptionPane in which the user chooses to
     * either use JColorChooser or input a String
     */
    private void initUI() {

        //initialize our frame
        JFrame f = new JFrame();
        f.setSize(400, 400);
        f.setLocation(350, 200);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fp = new JPanel();
        fp.setLayout(new GridLayout());
        fp.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JFrame.setDefaultLookAndFeelDecorated(true);

        //create both buttons
        buttonP = new JButton("Pick a colour");
        buttonP.addActionListener(this);
        buttonP.setBounds(50, 150, 100, 30);

        buttonN = new JButton("Give common colour name");
        buttonN.setBounds(50, 150, 200, 30);
        buttonN.addActionListener(this);

        //gives newly made buttons to panel
        fp.add(buttonP);
        fp.add(buttonN);

        //add panel with buttons and pack the frame
        f.add(fp);
        f.pack();

        //setVisible is called via invokeLater()
    }

    /**
     * This methods takes a String and returns that string's corresponding Color value
     * 
     * @param col The String value of the string being converted
     * 
     * @return Color - The Color value of the suspected corresponding colour of the param string
     */
    public Color getColor(String col) {
        Color color = null;
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
     * This Overrides the actionPerformed method from Parent ActionListener class
     * Sets instance variable choice to the user's input via JOptionPanes
     * 
     * @param e ActionEvent Object out of java.awt.event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonP) {
            setColorChoi(JColorChooser.showDialog(null, "Pick a Colour", Color.BLACK));
        }
        if(e.getSource()==buttonN) {
            setColorChoi(getColor(JOptionPane.showInputDialog ("What Colour did you have in mind?")));
        }
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