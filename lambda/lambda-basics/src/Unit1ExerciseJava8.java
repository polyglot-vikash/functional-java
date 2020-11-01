import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;


// This example solves the problem in Java8
class Unit1ExerciseSolutionJava8 {
    public static void main(String args[]) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Vikash", "kumar", 27));
        people.add(new Person("Suraj", "kumar", 27));
        people.add(new Person("Waseem", "Khan", 27));
        people.add(new Person("Ramesh", "Skumar", 27));
        people.add(new Person("Suresh", "Sumant", 27));


        // step1 : sort List by last name
        Collections.sort(people,( p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        // step 2: create a method which prints all elements in the list
        printAll(people);
        // Step 3: Create a method that prints all people whose last name start with a S

        System.out.println("Person whose last name start with S");
        performConditionally(people, (p) -> p.getLastName().startsWith("S"), p -> System.out.println(p));


        // Step 3: Create a method that prints first name all people whose first name start with a V
        System.out.println("Person whose first name starts with V");
        performConditionally(people, p -> p.getFirstName().startsWith("V"), p-> System.out.println(p.getFirstName()));

    }

    private static void printAll(List<Person> personList) {
        for(Person p : personList) {
            System.out.println(p);
        }
    }

    // Predicate is a generic functional interface it takes an object and returns boolean
    // Here, we don't need to create a separate interface unlike in Exercise7
    private static void printConditionally(List<Person> people, Predicate<Person> condition) {
        for(Person p : people) {
            if(condition.test(p)) {
                System.out.println(p);
            }
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


