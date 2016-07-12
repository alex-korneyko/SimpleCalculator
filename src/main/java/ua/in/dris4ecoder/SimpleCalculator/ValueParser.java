package ua.in.dris4ecoder.SimpleCalculator;

/**
 * Created by Alex Korneyko on 12.07.2016 10:43.
 */
public interface ValueParser {

    double parse(String stringValue) throws NumberFormatException;

    String getString(double value);

    void setPrecision(int precision);

    char dataTypeIdentitySymbol();
}
