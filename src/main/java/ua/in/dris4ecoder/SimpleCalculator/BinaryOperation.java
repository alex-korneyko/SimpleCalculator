package ua.in.dris4ecoder.SimpleCalculator;

/**
 * Created by Alex Korneyko on 04.07.2016 15:50.
 */
public interface BinaryOperation {

    double calculate(double operand1, double operand2);

    char getOperator();
}
