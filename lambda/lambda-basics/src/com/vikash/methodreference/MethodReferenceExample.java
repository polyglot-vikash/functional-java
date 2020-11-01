package com.vikash.methodreference;

public class MethodReferenceExample {

    public static void main(String args[]) {
        Thread t = new Thread(MethodReferenceExample::printMessage); // Equivalent lambda  new Thread(() -> printMessage());
        t.start();
        // Tips and trick
        // Whenever we are just executing a method in a lambda expression then we could simply convert it to method reference

    }
    public static void printMessage() {
        System.out.println("Hello");
    }
}
