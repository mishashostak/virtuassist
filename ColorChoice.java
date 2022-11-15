import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class defines the ability for the user to input colors
 * using JOptionPanes
 * 
 * @author Misha Shostak
 * 
 * @version November 15, 2022
 */
public class ColorChoice extends JFrame implements ActionListener {
    /**
     * Instance variables for seemless functionality of the twin initUI methods
     */
    private JFrame f1,f2;
    private JButton buttonP1,buttonP2;
    private JButton buttonN1,buttonN2;
    private JPanel fp1,fp2;
    private Color choice1f;

    /**
     * Non-parameterized constructor which calls the initUI1 method
     */
    public ColorChoice() {
        initUIColCh1();
    }
    /**
     * Mutator to set a new value for choice to the user's new chosen Color
     *
     * @param newCol The new Color value to set choice to
     */
    
    /* 
     public void setColorChoi1(Color newCol) {
        if(newCol!=null){
            choice1 = newCol;
        } else {
            System.err.println("damn it");
        }
    }*/

    /**
     * This method initializes the JFrame in which the user chooses to
     * either use JColorChooser or input a String
     */
    public void initUIColCh1() {
        //initialize our JFrame for first choice
        f1 = new JFrame("First Colour");

        //initialize our JPanel to occupy our JFrame
        fp1 = new JPanel(new GridLayout());

        f1.setSize(400, 400);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //create both buttons
        buttonN1 = new JButton("Give common colour name");
        buttonN1.addActionListener(this);
        buttonN1.setBackground(Color.LIGHT_GRAY);

        buttonP1 = new JButton("Pick a colour");
        buttonP1.addActionListener(this);
        buttonP1.setBackground(Color.CYAN);

        //give newly made buttons to panel
        fp1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        fp1.setBackground(Color.DARK_GRAY);
        fp1.add(buttonN1);
        fp1.add(buttonP1);

        //add panel with buttons to the JFrame and make it visible
        f1.add(fp1);
        f1.setVisible(true);
    }

    /**
     * This method initializes the JFrame in which the user chooses to
     * either use JColorChooser or input a String
     * effectively a clone of initUIColCh1() but for the second colour choice
     */
    public void initUIColCh2() {
        //initialize our JFrame for Second choice
        f2 = new JFrame("Second Colour");
        
        //initialize our JPanel to occupy our JFrame
        fp2 = new JPanel(new GridLayout());

        f2.setSize(400, 400);
        f2.setLocationRelativeTo(null);
        f2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //create both buttons
        buttonN2 = new JButton("Give common colour name");
        buttonN2.addActionListener(this);
        buttonN2.setBackground(Color.LIGHT_GRAY);

        buttonP2 = new JButton("Pick a colour");
        buttonP2.addActionListener(this);
        buttonP2.setBackground(Color.CYAN);

        //give newly made buttons to panel
        fp2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        fp2.setBackground(Color.DARK_GRAY);
        fp2.add(buttonN2);
        fp2.add(buttonP2);

        //add panel with buttons to the JFrame and make it visible
        f2.add(fp2);
        f2.setVisible(true);
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
        if(e.getSource()==buttonP1) {
            f1.dispose();
            Color choice1=null;
            //System.err.println("IN BUTTONP1");
            do {
                choice1 = JColorChooser.showDialog(null, "Pick a Colour", Color.BLACK);
            } while(choice1 == null);
            choice1f = choice1;
            initUIColCh2();
        }
        else if(e.getSource()==buttonN1) {
            f1.dispose();
            Color choice1=null;
            do {
                choice1 = getColor(JOptionPane.showInputDialog ("What Colour did you have in mind?"));
            } while(choice1 == null);
            choice1f = choice1;
            initUIColCh2();
        }
        else if(e.getSource()==buttonP2) {
            f2.dispose();
            Color choice2=null;
            do {
                choice2 = JColorChooser.showDialog(null, "Pick a Colour", Color.BLACK);
            } while(choice2 == null);
            new Calcer(choice1f,choice2);
        }
        else if(e.getSource()==buttonN2) {
            f2.dispose();
            Color choice2=null;
            do {
                choice2 = getColor(JOptionPane.showInputDialog ("What Colour did you have in mind?"));
            } while(choice2 == null);
            new Calcer(choice1f,choice2);
        }
        else{
            System.out.println(e);
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
