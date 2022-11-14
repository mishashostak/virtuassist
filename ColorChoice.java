import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChoice extends JFrame implements ActionListener {
    private JColorChooser jcc = null;
    private JButton button = null;
    private JLabel label;
    private Color choice;

    public ColorChoice() {
        initializeUI();
    }

    public Color getColorChoi() {
        return choice;
    }

    public void setColorChoi(Color newCol) {
        choice = newCol;
    }
    private void initializeUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        button = new JButton("Pick a colour");
        button.addActionListener(this);

        this.add(button);
        jcc = new JColorChooser();
        jcc.getSelectionModel().addActionListener(new ColorSelection());
        getContentPane().add(jcc, BorderLayout.PAGE_START);
        this.pack();
    }

    /**
     * A ChangeListener implementation for listening the color
     * selection of the JColorChooser component.
     */
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==button) {
            Color color = jcc.getColor();

            setColorChoi(color);
        } //https://www.youtube.com/watch?v=zEw8xObSWNA
    }
}