package factory;

public class ShapeFactory {

    public Shape getShape(String shape) {
        if(shape.equals("circle")) {
            return new Circle();
        } else if(shape.equals("rectangle")) {
            return new Rectangle();
        } else {
            return null;
        }
    }
}
