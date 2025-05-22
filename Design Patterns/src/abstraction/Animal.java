package abstraction;

public interface Animal {
    String name = "Animal Interface";

    default void moveDefault() {
        System.out.println("Animal moving by Default..");
        this.movePrivate();
        movePublicStatic();
    }

    private void movePrivate() {
        System.out.println("Animal moving by Private..");
    }

    void movePublic();

    static void movePublicStatic() {
        System.out.println("Animal moving by Static Public..");
    }
}
