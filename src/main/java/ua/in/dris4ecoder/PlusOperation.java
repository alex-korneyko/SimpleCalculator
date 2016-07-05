package ua.in.dris4ecoder;

/**
 * Created by Alex Korneyko on 04.07.2016 16:40.
 */
class PlusOperation implements BinaryOperation {

    @Override
    public double calculate(double operand1, double operand2) {
        return operand1 + operand2;
    }

    @Override
    public char getOperator() {
        return '+';
    }
}
