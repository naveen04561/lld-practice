package abstraction;

public class Dog implements Animal{

    @Override
    public void movePublic() {
        System.out.println("Dog moving by Public.." + name);
    }

    @Override
    public void moveDefault() {

    }
}
