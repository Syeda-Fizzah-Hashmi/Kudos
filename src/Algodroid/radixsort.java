package Algodroid;

public class radixsort extends sortblueprint {
    private static final String[] algo_steps = new String[]
            {"Get a list of unsorted numbers",
                    "Finding the maximum element.",
                    "Count the number of digits of the maximum number",
                    "Arrange the numbers on the basis of the least significant digit",
                    "Arrange the numbers according to the next significant digit",
                    "Keep performing the process until the most significant digit",
                    "The list is ordered and the algorithm can stop."};

    private static final String title = "RADIX SORT";

    public radixsort() {
        super(algo_steps, title);
    }
}
