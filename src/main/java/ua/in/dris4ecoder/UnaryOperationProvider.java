package ua.in.dris4ecoder;

import java.util.List;

/**
 * Created by Alex Korneyko on 05.07.2016 20:22.
 */
public interface UnaryOperationProvider {

    List<UnaryOperation> getUnaryOperations();

    void init();
}
