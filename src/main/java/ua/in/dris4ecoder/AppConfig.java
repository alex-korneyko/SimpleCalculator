package ua.in.dris4ecoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Alex Korneyko on 05.07.2016 16:01.
 */
@Configuration
public class AppConfig {

    @Bean
    public Calculator calculator(UnaryOperationProvider unaryOperationProvider, BinaryOperationProvider binaryOperationProvider, Parser parser) {

        Calculator calculator = new Calculator();
        calculator.setBinaryOperationsSet(binaryOperationProvider.getBinaryOperations());
        calculator.setUnaryOperationsSet(unaryOperationProvider.getUnaryOperations());
        calculator.setParser(parser);

        return calculator;
    }

    @Bean
    public UnaryOperationProvider unaryOperationProvider(){
        SimpleUnaryOperationProvider simpleUnaryOperationProvider = new SimpleUnaryOperationProvider();
        simpleUnaryOperationProvider.init();

        return simpleUnaryOperationProvider;
    }

    @Bean
    public BinaryOperationProvider binaryOperationProvider(){

        SimpleBinaryOperationProvider simpleBinaryOperationProvider = new SimpleBinaryOperationProvider();
        simpleBinaryOperationProvider.init();

        return simpleBinaryOperationProvider;
    }

    @Bean
    public Parser parser(){

        return new OneOrTwoOperandsNormalNotationParser();
    }
}
