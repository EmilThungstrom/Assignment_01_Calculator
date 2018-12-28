package se.lexicon.emil.calculator.structures;

public class Operation {
    public ArithmeticOperation arithmeticOperation;
    public double value;

    public Operation() {
        this.arithmeticOperation = ArithmeticOperation.NONE;
        this.value = 0;
    }
    public Operation(Operation operation){
        this.arithmeticOperation = operation.arithmeticOperation;
        this.value = operation.value;
    }
}
