package sample;

public class TreeNode {
    public Integer element;
    public TreeNode left=null;
    public TreeNode right=null;
    public TreeNode parent;
    public Integer elementNumber;

    public TreeNode(Integer e, Integer Number, TreeNode parent) {
        element = e;
        elementNumber=Number;
        this.parent=parent;
    }
}
