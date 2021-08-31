package Algodroid;

public class insertionsort extends sortblueprint
{
    private static final String[] algo_steps = new String[]{"Insert First value.",
            "If it is the first element, it is already sorted.",
            "Pick the next element",
            "Compare with all the elements in sorted sub-list.",
            "Shift all the the elements in sorted sub-list that is greater than the value to be sorted.",
            "Insert the value.",
            "Repeat until list is sorted."};

    private static final String title = "INSERTION SORT";

    public insertionsort()
    {
        super(algo_steps,title);
    }
}
