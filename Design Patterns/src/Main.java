import abstraction.Animal;
import abstraction.Dog;

public class Main {
    public static void main(String[] args) {

//        ShapeFactory shapeFactory = new ShapeFactory();
//        Shape shape = shapeFactory.getShape("circle");
//        shape.draw();
//
//        shape = shapeFactory.getShape("rectangle");
//        shape.draw();

//        Car car = new Car.CarBuilder("V8", 4)
//                .setAirbags(true)
//                .setSunroof(false)
//                .build();
//
//        System.out.println(car.toString());

//        Coffee coffee = new SimpleCoffee();
//        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
//
//        // Add milk
//        coffee = new MilkDecorator(coffee);
//        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
//
//        // Add sugar
//        coffee = new SugarDecorator(coffee);
//        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        Animal dog = new Dog();
        dog.moveDefault();
        dog.movePublic();
        Animal animal = new Animal() {
            @Override
            public void movePublic() {
                System.out.println("Animal moving on the go..");
            }
        };

        animal.moveDefault();
        animal.movePublic();

        Animal.movePublicStatic();
    }
}