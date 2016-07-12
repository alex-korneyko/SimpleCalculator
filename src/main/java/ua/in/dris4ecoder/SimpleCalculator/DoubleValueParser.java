package ua.in.dris4ecoder.SimpleCalculator;

/**
 * Created by Alex Korneyko on 12.07.2016 11:07.
 */
public class DoubleValueParser implements ValueParser {

    private int precision;

    @Override
    public double parse(String stringValue) throws NumberFormatException {
        return Double.parseDouble(stringValue);
    }

    @Override
    public String getString(double value) {
        return Double.toString(value);
    }

    @Override
    public void setPrecision(int precision) {
        this.precision = precision;
    }
}
