public class Greeter {
    private static void greet(Greeting greeting) {
        greeting.perform();
    }
    public static void main(String args[]) {
        HelloWorldGretting helloWorldGretting = new HelloWorldGretting();
        Greeting lambdaGreeting = () -> System.out.println("Hello world!!");

        greet(helloWorldGretting);
        lambdaGreeting.perform();

        // Third technique anonymous  inner class, with the inner classes we provide inline implementation to an interface
        // and the implementation does not have a name that's why it is called as anonymous 
        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello world!!");
            }
        };
        innerClassGreeting.perform();

        // Debate: is lambda just a syntactic sugar on top of anonymous  inner classes ?
        // Answer : for the most part we can say that lambda is just a syntactic sugar on top of anonymous inner classes
        // however this is not entirely true.


        // greet will take everything
        greet(lambdaGreeting);
        greet(innerClassGreeting);

        greet(() -> System.out.println("Inline lambda to greet"));
        greet(new Greeting() {
            @Override
            public void perform() {
                System.out.println("Inline anonymous inner class to greet");
            }
        });

    }
}
