package Algodroid;

public class selectionsort extends sortblueprint
{
    private static final String[] algo_steps = new String[]{"Get a list of unsorted numbers",
            "Set a marker for the unsorted section at the front of the list",
            "Repeat steps until one number remains in the unsorted section",
            "Compare all unsorted numbers in order to select the smallest one",
            "Swap this number with the first number in the unsorted section",
            "Advance the marker to the right one position",
            "Stop"};
    private static final String title = "SELECTION SORT";

    public selectionsort()
    {
        super(algo_steps,title);
    }


}
