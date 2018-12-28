package se.lexicon.emil.calculator;

import se.lexicon.emil.calculator.structures.ArithmeticOperation;
import se.lexicon.emil.calculator.structures.Operation;

import java.util.LinkedList;

public class Manager {
    private static Arithmeticer arithmeticer = new Arithmeticer();
    private LinkedList<Operation> operations;

    public Manager(){
        this.operations = new LinkedList<>();
    }
    private boolean isOperator(char character)
    {
        boolean retValue = false;

        switch (character) {
            case '+':
                retValue = true;
                break;
            case '*':
                retValue = true;
                break;
            case '/':
                retValue = true;
                break;
            case '-':
                retValue = true;
                break;
        }
        return retValue;
    }

    public void addOperations(LinkedList<Character> operationsList) {
        if(this.operations.isEmpty()){
            this.operations.add(new Operation());
            int i = 10;
            operations.peekLast().value = Character.getNumericValue(operationsList.poll());
            while(!operationsList.isEmpty() && !isOperator(operationsList.peek())){
                operations.peekLast().value = operations.peekLast().value * i + Character.getNumericValue(operationsList.poll());
                //increment order of magnitude
            }
        }
        while(!operationsList.isEmpty())
        {
            char tempChar = operationsList.poll();

            this.operations.add(new Operation());
            int i = 10;
            operations.peekLast().value = Character.getNumericValue(operationsList.poll());
            while(!operationsList.isEmpty() && !isOperator(operationsList.peek())){
                operations.peekLast().value = operations.peekLast().value * i + Character.getNumericValue(operationsList.poll());
                //increment order of magnitude
            }

            switch (tempChar) {
                case '+':
                    this.operations.peekLast().arithmeticOperation = ArithmeticOperation.ADDITION;
                    break;
                case '*':
                    this.operations.peekLast().arithmeticOperation = ArithmeticOperation.MULTIPLICATION;
                    break;
                case '/':
                    this.operations.peekLast().arithmeticOperation = ArithmeticOperation.DIVISION;
                    break;
                case '-':
                    this.operations.peekLast().arithmeticOperation = ArithmeticOperation.ADDITION;
                    this.operations.peekLast().value = -this.operations.peekLast().value;
                    break;

                default :
                    System.err.println("Malformed arithmetic sequence, this should not be possible");
                    return;
            }
        }
    }
    public double compute(){
        return arithmeticer.compute(operations);
    }
    public void clearOperations(){
        this.operations = new LinkedList<>();
    }
}
