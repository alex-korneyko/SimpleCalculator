package ua.in.dris4ecoder.SimpleCalculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring java-based config file
 * Created by Alex Korneyko on 05.07.2016 16:01.
 */
@Configuration
class AppConfigSimpleCalculator {

    @Bean
    public Calculator calculator(UnaryOperationProvider unaryOperationProvider, BinaryOperationProvider binaryOperationProvider, Parser parser) {

        Calculator calculator = new Calculator();
        calculator.setBinaryOperationsSet(binaryOperationProvider.getBinaryOperations());
        calculator.setUnaryOperationsSet(unaryOperationProvider.getUnaryOperations());
        calculator.setParser(parser);

        return calculator;
    }

    @Bean
    public UnaryOperationProvider unaryOperationProvider() {
        SimpleUnaryOperationProvider simpleUnaryOperationProvider = new SimpleUnaryOperationProvider();
        simpleUnaryOperationProvider.init();

        return simpleUnaryOperationProvider;
    }

    @Bean
    public BinaryOperationProvider binaryOperationProvider() {

        SimpleBinaryOperationProvider simpleBinaryOperationProvider = new SimpleBinaryOperationProvider();
        simpleBinaryOperationProvider.init();

        return simpleBinaryOperationProvider;
    }

    @Bean
    public Parser parser() {

        OneOrTwoOperandsNormalNotationParser oneOrTwoOperandsNormalNotationParser = new OneOrTwoOperandsNormalNotationParser();
        oneOrTwoOperandsNormalNotationParser.addNewValueParser(new DoubleValueParser());
        oneOrTwoOperandsNormalNotationParser.addNewValueParser(new BinaryValueParser());

        return oneOrTwoOperandsNormalNotationParser;
    }

    @Bean
    public OneOrTwoOperandsNormalNotationParser oneOrTwoOperandsNormalNotationParser() {
        return new OneOrTwoOperandsNormalNotationParser();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
