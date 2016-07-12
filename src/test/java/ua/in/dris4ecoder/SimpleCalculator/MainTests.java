package ua.in.dris4ecoder.SimpleCalculator;

import org.junit.Test;
import ua.in.dris4ecoder.SimpleCalculator.BinaryOperation;
import ua.in.dris4ecoder.SimpleCalculator.Calculator;
import ua.in.dris4ecoder.SimpleCalculator.CalculatorFactory;
import ua.in.dris4ecoder.SimpleCalculator.UnaryOperation;

/**
 * Created by Alex Korneyko on 05.07.2016 20:32.
 */
public class MainTests {

    @Test
    public void calculatorTest1() {
        Calculator calculator = CalculatorFactory.getCalculator();

        System.out.println(calculator.compute("2 + 3"));
        try {
            System.out.println(calculator.compute("10 * 20"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        calculator.addNewBinaryOperation(new MultiOperation());
        System.out.println(calculator.compute("10 * 20"));
        try {
            System.out.println(calculator.compute("s 20"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        calculator.addNewUnaryOperation(new SquareOperation());
        System.out.println(calculator.compute("s 20"));
    }

    private class MultiOperation implements BinaryOperation {

        @Override
        public double calculate(double operand1, double operand2) {
            return operand1 * operand2;
        }

        @Override
        public char getOperator() {
            return '*';
        }
    }

    private class SquareOperation implements UnaryOperation {

        @Override
        public double calculate(double operand1) {
            return operand1 * operand1;
        }

        @Override
        public char getOperator() {
            return 's';
        }
    }


}
