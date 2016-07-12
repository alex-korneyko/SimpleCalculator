package ua.in.dris4ecoder.SimpleCalculator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Alex Korneyko on 04.07.2016 16:22.
 */
public class OneOrTwoOperandsNormalNotationParserTest {

    private Parser parser = new OneOrTwoOperandsNormalNotationParser();

    @Test
    public void parse1() throws Exception {

        parser.addNewValueParser(new DoubleValueParser());
        parser.parse("1.5 + 2.8");
        Assert.assertEquals("Test for operands", new ArrayList<>(Arrays.asList(1.5, 2.8)), parser.getOperands());
        Assert.assertEquals("Test for operator", '+', parser.getOperator());
    }

    @Test
    public void parse2() throws Exception {

        parser.addNewValueParser(new DoubleValueParser());
        parser.parse("1254.545247 - 42242.80001");
        Assert.assertEquals("Test for operands", new ArrayList<>(Arrays.asList(1254.545247, 42242.80001)), parser.getOperands());
        Assert.assertEquals("Test for operator", '-', parser.getOperator());
    }

    @Test
    public void parse3() throws Exception {

        parser.addNewValueParser(new DoubleValueParser());
        parser.parse("1000000.00 p 0.0001");
        Assert.assertEquals("Test for operands", new ArrayList<>(Arrays.asList(1000000D, 0.0001)), parser.getOperands());
        Assert.assertEquals("Test for operator", 'p', parser.getOperator());
    }

    @Test
    public void parse4() throws Exception {

        parser.addNewValueParser(new DoubleValueParser());
        parser.parse("25000050000 * 0.0002000001");
        Assert.assertEquals("Test for operands", new ArrayList<>(Arrays.asList(2.500005E10, 2.000001E-4)), parser.getOperands());
        Assert.assertEquals("Test for operator", '*', parser.getOperator());
    }

    @Test
    public void parse5() throws Exception {

        parser.addNewValueParser(new DoubleValueParser());
        parser.parse("#d25000050000 * #d0.0002000001");
        Assert.assertEquals("Test for operands", new ArrayList<>(Arrays.asList(2.500005E10, 2.000001E-4)), parser.getOperands());
        Assert.assertEquals("Test for operator", '*', parser.getOperator());
    }

    @Test
    public void parse6() throws Exception {

        parser.addNewValueParser(new DoubleValueParser());
        parser.addNewValueParser(new BinaryValueParser());
        parser.parse("#b1010 * #d0.12");
        Assert.assertEquals("Test for operands", new ArrayList<>(Arrays.asList(10.0, 0.12)), parser.getOperands());
        Assert.assertEquals("Test for operator", '*', parser.getOperator());
    }
}