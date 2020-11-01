// Any interface with exactly one abstract method is known as functional interface
// @FunctionalInterface annotation does not let you add more than one abstract method in an interface
@FunctionalInterface
public interface Greeting {
    void perform();
}
