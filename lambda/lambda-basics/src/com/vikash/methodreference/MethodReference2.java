package com.vikash.methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


class MethodReference2 {
    public static void main(String args[]) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Vikash", "kumar", 27));
        people.add(new Person("Suraj", "kumar", 27));
        people.add(new Person("Waseem", "Khan", 27));
        people.add(new Person("Ramesh", "Skumar", 27));
        people.add(new Person("Suresh", "Sumant", 27));

        people.stream().
        // here p -> System.out.println(p) can be replaced by System.out.::println
        performConditionally(people, p -> true, System.out::println);

    }

    private static void printAll(List<Person> personList) {
        for(Person p : personList) {
            System.out.println(p);
        }
    }

    // Here instead of hardcoding println in the method we are passing the behavior from the caller
    // We can check all these out of the box functional interfaces in java.util.Function
    // This way java gives the flexibility to use functional interfaces out of the box without actually creating it
    // https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
    private static void performConditionally(List<Person> people, Predicate<Person> condition, Consumer<Person> consumer) {
        for(Person p : people) {
            if(condition.test(p)) {
                consumer.accept(p);
            }
        }
    }

}


