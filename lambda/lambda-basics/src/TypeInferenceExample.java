public class TypeInferenceExample {
    public static void main(String args[]) {
        printLambda(s-> s.length()*2);
    }

    // Basically StringLengthLambda l is an inline implementation of interface StringLengthLambda
    public static void printLambda(StringLengthLambda l) {
        System.out.println(l.getDoubleLength("Hello Lambda"));
    }

    // Interface StringLengthLambda is a functional interface, any interface containing only one abstract method is a functional interface
    interface StringLengthLambda {
        int getDoubleLength(String s);
    }
}
