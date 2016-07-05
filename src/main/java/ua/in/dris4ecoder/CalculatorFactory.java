package ua.in.dris4ecoder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alex Korneyko on 05.07.2016 17:21.
 */
class CalculatorFactory {

    static Calculator getCalculator(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");

        return applicationContext.getBean("calculator", Calculator.class);
    }
}
