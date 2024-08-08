package java_study.oop;

public class Rectangle {
    int width;
    int height;



    int calculateArea() {
        return width * height;
    }

    int calculatePerimeter() {
        return 2 * (width + height);
    }

    boolean isSquare() {
        return width == height;
    }

}
