package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This class represents a calculator for the total of a pizza order.
 */
public class PizzaOrder extends Frame {
    Button bOrder, bReset;
    TextField[] t;
    Label[] l;
    int size = 5;
    double[] pret = {15.5, 19.7, 16.5, 15};
    String[] pizza = {"Margherita", "Quattro Formaggi", "Quattro Staggioni", "Primavera"};

    PizzaOrder(){
        super("Pizza Order");
        AscultatorB ab = new AscultatorB();

        Panel p1 = new Panel();
        p1.setLayout(new GridLayout(size,1));

        t = new TextField[size];
        l = new Label[size];

        for (int i=0; i<size; i++){
            t[i] = new TextField(15);
            if (i != size-1){
                l[i] = new Label(pizza[i] + "-" + pret[i] + " lei");
            }
            if (i == size-1){
                l[i] = new Label("Total");
                t[i].setEditable(false);
            }
            p1.add(l[i]); p1.add(t[i]);
        }

        bOrder = new Button("Order");
        bOrder.addActionListener(ab);

        bReset = new Button("Reset");
        bReset.addActionListener(ab);

        Panel p2 = new Panel();
        p2.add(bOrder); p2.add(bReset);

        add(p1, BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent ev){System.exit(0);}});
    }

    class AscultatorB implements ActionListener {
        public void actionPerformed(ActionEvent ev){
            if (ev.getSource() == bOrder){
                double total = 0;
                try {
                    for (int i=0; i<size-1; i++){
                        if (!t[i].getText().equals("")){
                            total+=pret[i]*Integer.parseInt(t[i].getText());
                            t[4].setText("" + total);
                        }
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(PizzaOrder.this, "Eroare! Introduceti cantitatea corect (numar intreg)!","Eroare", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                for (int i = 0; i<size; i++){
                    t[i].setText("");
                }
            }
        }
    }
}

class TestPizza{
    public static void main(String[] args) {
        PizzaOrder pizzaOrder = new PizzaOrder();

    }
}
