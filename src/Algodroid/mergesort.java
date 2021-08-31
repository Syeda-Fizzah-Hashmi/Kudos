package Algodroid;

public class mergesort extends sortblueprint
{
    private static final String[] algo_steps = new String[]{"Enter unordered array",
            "Declare left and right var which will mark the extreme indices of the array",
            "Left will be assigned to 0 and right will be assigned to n-1",
            "Find mid = (left+right)/2.",
            "Call mergeSort on (left,mid) and (mid+1,rear)",
            "Above will continue till left<right",
            "Then we will call merge on the 2 sub problems"};

    private static final String title = "MERGE SORT";

    public mergesort()
    {
        super(algo_steps,title);
    }
}
