public class Program {
    public static void main(String[] argv){
        TreeNode root = new TreeNode();
        root.setData('F');

        TreeNode l = new TreeNode();
        l.setData('B');
        root.setLeftChild(l);

        TreeNode ll = new TreeNode();
        ll.setData('A');
        l.setLeftChild(ll);

        TreeNode lr = new TreeNode();
        lr.setData('D');
        l.setRightChild(lr);

        TreeNode lrl = new TreeNode();
        lrl.setData('C');
        lr.setLeftChild(lrl);

        TreeNode lrr = new TreeNode();
        lrr.setData('E');
        lr.setRightChild(lrr);

        TreeNode r = new TreeNode();
        r.setData('G');
        root.setRightChild(r);

        TreeNode rr = new TreeNode();
        rr.setData('I');
        r.setRightChild(rr);

        TreeNode rrl = new TreeNode();
        rrl.setData('H');
        rr.setLeftChild(rrl);

        Tree tree = new Tree();
        tree.preOrder(root);
        System.out.println(tree.getOrder());
        tree.clearList();

        tree.inOrder(root);
        System.out.println(tree.getOrder());
        tree.clearList();

        tree.postOrder(root);
        System.out.println(tree.getOrder());
        tree.clearList();

        System.out.println("height : " + tree.height(root));
    }
}
