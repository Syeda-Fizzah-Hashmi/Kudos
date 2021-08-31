package Algodroid;

public class bubblesort extends sortblueprint
{
    private static final String[] algo_steps = new String[]
            {"Look at the first number in the list",
            "Compare the current number with next number",
            "If the next number smaller than the current number swap the two numbers",
            "Move to the next number in the list and make this the current number.",
            "Repeat comparison until the last number in the list has been reached.",
            "If any numbers were swapped, repeat again from start.",
            "If the end of the list is reached without any swaps being made,then stop."};

    private static final String title = "BUBBLE SORT";

    public bubblesort()
    {
        super(algo_steps,title);
    }
}
