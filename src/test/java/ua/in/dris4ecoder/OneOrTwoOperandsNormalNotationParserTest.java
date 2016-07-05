package ua.in.dris4ecoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Alex Korneyko on 04.07.2016 16:22.
 */
public class OneOrTwoOperandsNormalNotationParserTest {

    Parser parser = new OneOrTwoOperandsNormalNotationParser();

    @Test
    public void parse1() throws Exception {

        parser.parse("1.5+2.8");
        Assert.assertEquals("Test for operands", new ArrayList<>(Arrays.asList(1.5, 2.8)), parser.getOperands());
        Assert.assertEquals("Test for operator", '+', parser.getOperator());
    }

    @Test
    public void parse2() throws Exception {

        parser.parse("1254.545247 - 42242.80001");
        Assert.assertEquals("Test for operands", new ArrayList<>(Arrays.asList(1254.545247, 42242.80001)), parser.getOperands());
        Assert.assertEquals("Test for operator", '-', parser.getOperator());
    }

    @Test
    public void parse3() throws Exception {

        parser.parse("1000000.00p 0.0001");
        Assert.assertEquals("Test for operands", new ArrayList<>(Arrays.asList(1000000D, 0.0001)), parser.getOperands());
        Assert.assertEquals("Test for operator", 'p', parser.getOperator());
    }

}