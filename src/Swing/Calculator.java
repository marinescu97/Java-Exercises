package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This class represents a basic calculator made in Java Swing.
 */
public class Calculator extends JFrame implements ActionListener {
    JButton add, subtract, multiply, divide;
    JTextField a, b, rez;
    JLabel enter, result;
    JPanel p1, p2, p3, p4;

    Container c;

    /**
     * Creates a new calculator with the given title.
     * @param title The title of the file.
     */
    Calculator(String title) {
        super(title);

        c = getContentPane();
        add = new JButton("Add");
        add.addActionListener(this);
        add.setBorder(BorderFactory.createMatteBorder(0,0,2,2,Color.darkGray));
        add.setPreferredSize(new Dimension(46, 20));

        subtract = new JButton("Subtract");
        subtract.addActionListener(this);
        subtract.setBorder(BorderFactory.createMatteBorder(0,0,2,2,Color.darkGray));
        subtract.setPreferredSize(new Dimension(46, 20));

        multiply = new JButton("Multiply");
        multiply.addActionListener(this);
        multiply.setBorder(BorderFactory.createMatteBorder(0,0,2,2,Color.darkGray));
        multiply.setPreferredSize(new Dimension(75, 20));

        divide = new JButton("Divide");
        divide.addActionListener(this);
        divide.setBorder(BorderFactory.createMatteBorder(0,0,2,2,Color.darkGray));
        divide.setPreferredSize(new Dimension(55, 20));

        a = new JTextField(12);
        b = new JTextField(12);
        rez = new JTextField(10);
        rez.setEditable(false);

        enter = new JLabel("Enter two numbers:");
        result = new JLabel("Result: ");

        p1 = new JPanel();
        p1.add(enter);


        p2 = new JPanel();
        p2.add(a);
        p2.add(b);

        p3 = new JPanel(new GridLayout(1,4, 10, 10));
        p3.add(add); p3.add(subtract); p3.add(multiply); p3.add(divide);


        p4 = new JPanel();
        p4.add(result); p4.add(rez);

        Panel p5 = new Panel();
        p5.add(p3);
        p5.add(p4);
        p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));

        c.add(p1, BorderLayout.NORTH);
        c.add(p2, BorderLayout.CENTER);
        c.add(p5, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent ev){System.exit(0);}});
    }

    /**
     * Adds actions to the buttons.
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e){
        double total = 0;
        try {
            if (add.equals(e.getSource())) {
                if (!a.getText().equals("") && !b.getText().equals("")) {
                    total += Double.parseDouble(a.getText()) + Double.parseDouble(b.getText());
                    if (total == Math.floor(total) && !Double.isInfinite(total)){
                        int t = (int) total;
                        rez.setText("" + t);
                    } else {
                        rez.setText("" + total);
                    }
                    a.setText("");
                    b.setText("");
                }
            }else if (subtract.equals(e.getSource())) {
                if (!a.getText().equals("") && !b.getText().equals("")) {
                    total += Double.parseDouble(a.getText()) - Double.parseDouble(b.getText());
                    if (total == Math.floor(total) && !Double.isInfinite(total)){
                        int t = (int) total;
                        rez.setText("" + t);
                    } else {
                        rez.setText("" + total);
                    }
                    a.setText("");
                    b.setText("");
                }
            } else if (multiply.equals(e.getSource())) {
                if (!a.getText().equals("") && !b.getText().equals("")) {
                    total += Double.parseDouble(a.getText()) * Double.parseDouble(b.getText());
                    if (total == Math.floor(total) && !Double.isInfinite(total)){
                        int t = (int) total;
                        rez.setText("" + t);
                    } else {
                        rez.setText("" + total);
                    }
                    a.setText("");
                    b.setText("");
                }
            } else if (divide.equals(e.getSource())) {
                if (!a.getText().equals("") && !b.getText().equals("")) {
                    total += Double.parseDouble(a.getText()) / Double.parseDouble(b.getText());
                    if (total == Math.floor(total) && !Double.isInfinite(total)){
                        int t = (int) total;
                        rez.setText("" + t);
                    } else {
                        rez.setText("" + Math.round(total*100.0)/100.0);
                    }
                    a.setText("");
                    b.setText("");
                }
            }
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(Calculator.this, "Please enter numbers!","Error", JOptionPane.ERROR_MESSAGE);
            a.setText("");
            b.setText("");
        }
    }
}

/**
 * This class tests the functionality of the {@link Calculator} class.
 */
class Test {
    public static void main(String[] args) {
        Calculator c = new Calculator("Calculator");
    }
}
