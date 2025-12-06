package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private Controller controller = new Controller();
    private final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel panel = new JPanel(new BorderLayout());
        JTextField textField= new JTextField();
        JButton button = new JButton("Browse...");

        textField.setEditable(false);
        textField.setText(controller.getCurrentFile());

        mainPanel.add(panel, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int res = fileChooser.showSaveDialog(null);

                if (res == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(fileChooser.getSelectedFile().getPath());
                    textField.setText(controller.getCurrentFile());
                } else if (res == JFileChooser.CANCEL_OPTION) {
                } else {
                    JOptionPane.showMessageDialog(null,
                                                    "c'è stato un errore",
                                                    "errore",
                                                    JOptionPane.ERROR_MESSAGE);
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
        new SimpleGUIWithFileChooser().display();
    }
}
