package structures;

import enums.Traversal;

public class GenericBinTree<T extends Comparable<T>> {

    private BTreeNode<T> root;
    private Traversal traversal;

    public GenericBinTree(Traversal traversal) {
        super();
        this.traversal = traversal;
    }

    public void insert(T value){
        if(root==null){
            this.root = new BTreeNode<T>(value);
            return;
        }

        insert(root,value);
    }

    private void insert(BTreeNode<T> node, T value) {
        if (node.value.compareTo(value) > 0) {
            // links
            if (node.left == null) {
                // hier einfuegen
                node.left = new BTreeNode<T>(value);
                return;
            } else {
                // an Kindknoten delegieren
                insert(node.left, value);
            }

        } else if (node.value.compareTo(value) < 0) {
            // rechts
            if (node.right == null) {
                node.right = new BTreeNode<T>(value);
                return;
            } else {
                insert(node.right, value);
            }

        } else {
            return;
        }
    }

    private void printInOrder(BTreeNode<T> node) {

        if (node == null)
            return;

        // to the left
        printInOrder(node.left);

        // middle!
        System.out.print(node);

        // to the rigth
        printInOrder(node.right);
    }

    private void printPreOrder(BTreeNode<T> node) {
        if (node == null)
            return;

        // middle!
        System.out.print(node);

        // to the left
        printPreOrder(node.left);

        // to the rigth
        printPreOrder(node.right);
    }

    private void printPostOrder(BTreeNode<T> node) {

        if (node == null)
            return;

        // to the left
        printPostOrder(node.left);

        // to the rigth
        printPostOrder(node.right);

        // middle!
        System.out.print(node);
    }


    @Override
    public String toString() {
        String aux = "\nPrinting in " + traversal + ":\n";

        switch (traversal) {
            case INORDER -> printInOrder(root);
            case PREORDER -> printPreOrder(root);
            case POSTORDER -> printPostOrder(root);
        }

        return aux;
    }

    public static void main(String[] args) {
        GenericBinTree<Integer> tree = new GenericBinTree<>(Traversal.PREORDER);

        tree.insert(2);
        tree.insert(1);
        tree.insert(3);

        System.out.println(tree);

    }

}

