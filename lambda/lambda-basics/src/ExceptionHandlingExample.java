import java.util.function.BiConsumer;

/**
 * Problem: There will be a list of numbers and a key, the lambda expression will be applied for each number with the key
 * For example key should be added to each element
 */
public class ExceptionHandlingExample {
    public static void main(String args[]) {
        int[] someNumbers = {1, 2, 3, 4, 5};
        int key = 0;

        process(someNumbers, key, (v, k) -> System.out.println(v + k));
        process(someNumbers, key, (v, k) ->
                {
                    try {
                        System.out.println(v / k);
                    } catch (Exception e) {
                        System.out.println("Exception occurred");
                    }

                }
        );
    }

    private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : numbers) {
            consumer.accept(i, key);
        }
    }
}
