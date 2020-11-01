public class RunnableExample {
    public static void main(String args[]) {
        // anonymous inner class example, this is a classic case to use lambda
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside Runnable");
            }
        });
        // Let's use lambda instead of inline anonymous inner class
        Thread myLambdaThread = new Thread(() -> System.out.println("Printed inside lambda thread"));

        myThread.start();
        System.out.println("Main thread");
        myLambdaThread.start();
    }
}
