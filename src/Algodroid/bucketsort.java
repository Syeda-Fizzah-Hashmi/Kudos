package Algodroid;

public class bucketsort extends sortblueprint
{
    private static final String[] algo_steps = new String[]{"Find maximum element and minimum of the array",
            "Calculate the range of each bucket",
            "Create n buckets of calculated range",
            "Scatter the array elements to these buckets",
            "Sort each bucket individually",
            "Gather the sorted elements from buckets to original array",
            "Display the sorted list."};

    private static final String title = "BUCKET SORT";

    public bucketsort()
    {
        super(algo_steps,title);
    }
}
