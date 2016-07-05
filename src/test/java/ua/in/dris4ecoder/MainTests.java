package ua.in.dris4ecoder;

import org.junit.Test;

/**
 * Created by Alex Korneyko on 05.07.2016 20:32.
 */
public class MainTests {

    @Test
    public void calculatorTest1(){
        Calculator calculator = CalculatorFactory.getCalculator();

        System.out.println(calculator.compute("2+3"));
        System.out.println(calculator.compute("10*20"));
        calculator.addNewBinaryOperation(new MultiOperation());
        System.out.println(calculator.compute("10*20"));
        System.out.println(calculator.compute("s20"));
        calculator.addNewUnaryOperation(new SquareOperation());
        System.out.println(calculator.compute("s20"));
    }

    private class MultiOperation implements BinaryOperation{

        @Override
        public double calculate(double operand1, double operand2) {
            return operand1 * operand2;
        }

        @Override
        public char getOperator() {
            return '*';
        }
    }

    private class SquareOperation implements UnaryOperation{

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
