package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private Controller controller = new Controller();
    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;

    public SimpleGUI() {

        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        JButton button = new JButton("button");

        panel.add(textArea, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.saveOnFile("Prova");
                } catch (IOException e1) {
                    e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
                }
            }
            
        });

        frame.add(panel);
    }

    private void display() {
        /*
         * resize the frame to the minimum size
         */
        frame.pack();
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleGUI().display();
    }

}
