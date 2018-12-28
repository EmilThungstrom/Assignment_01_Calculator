package se.lexicon.emil.calculator;

import java.util.LinkedList;
import java.util.function.BiFunction;

import se.lexicon.emil.calculator.structures.ArithmeticOperation;
import se.lexicon.emil.calculator.structures.Operation;

public class Arithmeticer {

    public double compute(LinkedList<Operation> operations) throws IllegalArgumentException {

        operations = passTrough(ArithmeticOperation.DIVISION, operations, this::division);
        operations = passTrough(ArithmeticOperation.MULTIPLICATION, operations, this::multiplication);
        operations = passTrough(ArithmeticOperation.ADDITION, operations, this::addition);

        return operations.peek().value;
    }
    public LinkedList<Operation> passTrough(ArithmeticOperation arithmeticOperation, LinkedList<Operation> operations, BiFunction<Double, Double, Double> function)
    {
        LinkedList<Operation> newOperations = new LinkedList<>();
        do
        {
            if(operations.peek().arithmeticOperation == arithmeticOperation)
                newOperations.peekLast().value = function.apply(newOperations.peekLast().value, operations.poll().value);
            else
                newOperations.add(operations.poll());

        }while (!operations.isEmpty());
        return newOperations;
    }
    private double addition(double lhs, double rhs){
        return lhs + rhs;
    }
    private double multiplication(double lhs, double rhs){
        return lhs * rhs;
    }
    private double division(double lhs, double rhs) throws IllegalArgumentException{
        if(rhs == 0)
            throw new IllegalArgumentException("Division by zero is undefined");
        return lhs / rhs;
    }
}
