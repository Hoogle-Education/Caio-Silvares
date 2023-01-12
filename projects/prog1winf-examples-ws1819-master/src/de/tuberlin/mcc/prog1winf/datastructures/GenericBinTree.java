package de.tuberlin.mcc.prog1winf.datastructures;

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

	@Override
	public String toString() {
		return "GenericBinTree []";
	}

	public static void main(String[] args) {
		GenericBinTree<Integer> tree = new GenericBinTree<>(Traversal.INORDER);
		
		System.out.println(tree);
	}
	
}

