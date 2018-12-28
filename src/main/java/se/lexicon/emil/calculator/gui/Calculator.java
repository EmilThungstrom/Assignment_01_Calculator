package se.lexicon.emil.calculator.gui;

import se.lexicon.emil.calculator.Manager;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Calculator extends JFrame {
    private JTextArea mainOutputArea;
    private JPanel rootPanel;
    private JButton calculate;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton zero;
    private JButton clearButton;
    private JButton addition;
    private JButton subtraction;
    private JButton multiplication;
    private JButton division;

    private static Manager manager = new Manager();

    public Calculator()
    {
        ActionListener symbolListener = e -> mainOutputArea.insert(((JButton)e.getSource()).getText(), mainOutputArea.getText().length());
        ActionListener arithmeticSymbolListener = e -> {
            if(     mainOutputArea.getText().length() > 0 &&
                    mainOutputArea.getText().charAt(mainOutputArea.getText().length() - 1) != '+' &&
                    mainOutputArea.getText().charAt(mainOutputArea.getText().length() - 1) != '-' &&
                    mainOutputArea.getText().charAt(mainOutputArea.getText().length() - 1) != '*' &&
                    mainOutputArea.getText().charAt(mainOutputArea.getText().length() - 1) != '/'){
                symbolListener.actionPerformed(e);
            }
        };
        add(rootPanel);

        setTitle("Calculator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Adding listener for equal sign button
        calculate.addActionListener(e -> {
            manager.addOperations(new LinkedList<>(mainOutputArea.getText().chars().mapToObj(c -> (char) c).collect(Collectors.toList())));

            try {
                mainOutputArea.setText(Double.toString(manager.compute()));
            }
            catch(Exception exp)
            {
                mainOutputArea.setText(exp.getMessage());
            }
        });
        //Adding listener for clear button
        clearButton.addActionListener(e -> mainOutputArea.setText(""));
        //Adding listeners for all number buttons
        one.addActionListener(symbolListener);
        two.addActionListener(symbolListener);
        three.addActionListener(symbolListener);
        four.addActionListener(symbolListener);
        five.addActionListener(symbolListener);
        six.addActionListener(symbolListener);
        seven.addActionListener(symbolListener);
        eight.addActionListener(symbolListener);
        nine.addActionListener(symbolListener);
        zero.addActionListener(symbolListener);
        //Adding listeners for all arithmetic operator buttons
        addition.addActionListener(arithmeticSymbolListener);
        subtraction.addActionListener(arithmeticSymbolListener);
        multiplication.addActionListener(arithmeticSymbolListener);
        division.addActionListener(arithmeticSymbolListener);
    }
}
