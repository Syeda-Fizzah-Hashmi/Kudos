package Algodroid;

public class quicksort extends sortblueprint
{

    private static final String[] algo_steps = new String[]{"Consider the first element of the list as pivot",
            "Define two variables i and j. Set i and j to first and last elements of the list respectively",
            "Increment i until list [i] > pivot then stop",
            "Decrement j until list[j] < pivot then stop",
            "If i < j then exchange list[i] and list[j]",
            "Repeat steps 3,4 & 5 until i > j",
            "Exchange the pivot element with list[j] element."};

    private static final String title = "QUICK SORT";

    public quicksort()
    {
        super(algo_steps,title);
    }
}
