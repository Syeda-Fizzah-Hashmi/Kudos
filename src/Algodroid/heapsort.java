package Algodroid;

public class heapsort extends sortblueprint
{
    private static final String[] algo_steps = new String[]{"Enter unordered array",
            "Construct a Binary Tree with given list of Elements.",
            "Transform the Binary Tree into Min Heap.",
            "Delete the root element from Min Heap using Heapify method.",
            "Put the deleted element into the Sorted list.",
            "Repeat the same until Min Heap becomes empty.",
            "Display the sorted list."};

    private static final String title = "HEAP SORT";

    public heapsort()
    {
        super(algo_steps,title);
    }
}
