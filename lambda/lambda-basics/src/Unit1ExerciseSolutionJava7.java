import java.util.*;


// This example solves the problem in Java7 anonymus inner class way, we will have a separate class in Java 8 way
public class Unit1ExerciseSolutionJava7 {
    public static void main(String args[]) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Vikash", "kumar", 27));
        people.add(new Person("Suraj", "kumar", 27));
        people.add(new Person("Waseem", "Khan", 27));
        people.add(new Person("Ramesh", "Skumar", 27));
        people.add(new Person("Suresh", "Sumant", 27));


        // step1 : sort List by last name
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getLastName().compareTo(p2.getLastName());
            }
        });
        // step 2: create a method which prints all elements in the list
        printAll(people);
        // Step 3: Create a method that prints all people whose last name start with a S

        System.out.println("Person whose last name start with S");
        printConditionally(people, new PrintCondition() {
            @Override
            public boolean test(Person p) {
                return p.getLastName().startsWith("S");
            }
        });


        // Step 3: Create a method that prints all people whose first name start with a V
        System.out.println("Person whose first name starts with V");
        printConditionally(people, new PrintCondition() {
            @Override
            public boolean test(Person p) {
                return p.getFirstName().startsWith("V");
            }
        });

    }

    private static void printAll(List<Person> personList) {
        for(Person p : personList) {
            System.out.println(p);
        }
    }

    private static void printConditionally(List<Person> people, PrintCondition condition) {
        for(Person p : people) {
            if(condition.test(p)) {
                System.out.println(p);
            }
        }
    }


}

interface PrintCondition {
    boolean test(Person p);
}

