public class TreeNode {
    private TreeNode parent = null;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private Object data = null;

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
        leftChild.setParent(this);
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
        rightChild.setParent(this);
    }

    public TreeNode getRoot() {
        if (parent == null)
            return null;
        else
            return parent.getRoot();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
