package drawing;

import drawing.shapes.Line;
import drawing.shapes.Shape;
import drawing.writing.JPEGWriter;
import drawing.writing.PNGWriter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Refactor Task 3: (Mis-)Shaped
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Drawing {

    private List<Shape> shapes;

    public Drawing(List<Shape> shapes) {
        this.shapes = shapes;
    }

    /**
     * Draw shapes to a file with given file format.
     *
     * @param format   file format
     * @param filename file name
     */
    public void draw(String format, String filename) {
        // TODO: Do you notice any issues here?
        /*
         * Issue 1: Duplicated Functionality in the "draw" Function for Different File Types
         * Problem:
         * The draw function duplicates its logic for different file formats (JPEG, PNG, etc.).
         * This is inefficient and violates the DRY (Don't Repeat Yourself) principle, making the code harder to maintain and extend.
         * Solution:
         * Use the Strategy Pattern. 
         * Create a WriterStrategy interface with a method for drawing, and implement this interface in different classes for each file format (e.g., JPEGWriterStrategy, PNGWriterStrategy).
         * This way, we can pass the appropriate strategy to the draw method, reducing duplication.
         */
        if (format.equals("jpeg")) {
            try (Writer writer = new JPEGWriter(filename + ".jpeg")) {
                for (Shape shape : this.shapes) {
                    // TODO: What is the issue of the behavior here?
                    /*
                     * Issue 2: Encapsulation Violation
                     * Problem:
                     * It currently creates an array of lines from each shape and passes it to the draw method.
                     * It exposes the internal information of the Shape.
                     * Solution:
                     * Encapsulate the drawing logic inside the Shape class.
                     * For each Shape, it should be responsible for converting itself to an array of lines and drawing itself.
                     * Each Shape should have a draw method that takes a Writer and draws itself.
                     */
                    Line[] lines = shape.toLines();
                    shape.draw(writer, lines);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (format.equals("png")) {
            try (Writer writer = new PNGWriter(filename + ".png")) {
                for (Shape shape : this.shapes) {
                    Line[] lines = shape.toLines();
                    shape.draw(writer, lines);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

