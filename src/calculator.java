import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class calculator extends JFrame{
    private JPanel mainPanel;
    private JTextArea inputTextField;
    private JButton computeButton;
    private JTextPane results;
    private double computedResult;

    public calculator(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputLine = (String) ((inputTextField.getText()));
                try {
                    Double resultsDouble = Parser.eval(inputLine);
                    String  finalComputation = resultsDouble.toString();
                    results.setText(finalComputation);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new calculator("Computational Device");
        frame.setVisible(true);
    }



}
