package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller controller = new SimpleController();

    public SimpleGUI(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        panel.add(textArea, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        panel.add(buttonPanel, BorderLayout.SOUTH);

        JButton printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setNextString(textArea.getText());
                controller.printCurrentString();
                textArea.setText(null);
            }
            
        });
        buttonPanel.add(printButton);

        JButton showHistoryButton = new JButton("Show history");
        showHistoryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String res = "";
                for (String s : controller.getHistory()) {
                    res = res + " || " + s;
                }
                textArea.setText(res);
            }
        });
        buttonPanel.add(showHistoryButton);

        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String[] args) {
        new SimpleGUI();
    }
}
