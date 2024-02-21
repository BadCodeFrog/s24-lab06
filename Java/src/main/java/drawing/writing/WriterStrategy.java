package drawing.writing;

import java.io.IOException;

import drawing.shapes.Shape;

public interface WriterStrategy {
    void draw(Shape shape) throws IOException;
}

