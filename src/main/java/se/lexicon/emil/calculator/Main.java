package se.lexicon.emil.calculator;

import se.lexicon.emil.calculator.gui.Calculator;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String [] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });

//        while(true) {
//            System.out.println("Enter a sequence of arithmetic operations, only the character [0-9 + - * /] are supported:");
//            Scanner scanner = new Scanner(System.in);
//
//            LinkedList<Character> temp = new LinkedList<>(scanner.nextLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
//
//            Manager manager = new Manager();
//            manager.addOperations(temp);
//
//            try
//            {
//                System.out.println(manager.compute());
//            }
//            catch (Exception E)
//            {
//                System.out.println(E.getMessage());
//            }
//        }
    }
}
