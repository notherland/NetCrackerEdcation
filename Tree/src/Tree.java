import java.util.ArrayList;
import java.util.List;

public class Tree {
    private ArrayList<Object> order = new ArrayList<>();

    public int height(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(height(root.getLeftChild()), height(root.getRightChild())) + 1;
    }

    public void preOrder(TreeNode root) {
        TreeNode curNode = root;
        if (curNode != null) {
            order.add(curNode.getData());
            preOrder(curNode.getLeftChild());
            preOrder(curNode.getRightChild());
        }
    }

    public void inOrder(TreeNode root) {
        TreeNode curNode = root;
        if (curNode != null) {
            inOrder(curNode.getLeftChild());
            order.add(curNode.getData());
            inOrder(curNode.getRightChild());
        }
    }

    public void postOrder(TreeNode root) {
        TreeNode curNode = root;
        if (curNode != null) {
            postOrder(curNode.getLeftChild());
            postOrder(curNode.getRightChild());
            order.add(curNode.getData());
        }
    }

    public ArrayList<Object> getOrder(){
        return order;
    }

    public void clearList(){
        order.clear();
    }
}
