//Arham Sikder ans2ur
public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof BinaryTree) {
			@SuppressWarnings("unchecked")
			BinaryTree<T> x = (BinaryTree<T>) o;
			return this.root.equals(x.root);
		} else {
			return false;
		}

	}

	public BinaryTree<T> deepCopy() {
		BinaryTree<T> copy = new BinaryTree<T>();
		BinaryTreeNode<T> newRoot = null;
		if (this.root != null) {
			copy.setRoot(this.root.deepCopy());
		}
		// copy.setRoot(newRoot);
		return copy;
	}

	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t, boolean left) {
		BinaryTree<T> newTree = new BinaryTree<T>();
		BinaryTreeNode<T> newRootNode = newRoot.deepCopy();
		newTree.setRoot(newRootNode);
		if (left == true) {
			newTree.getRoot().setLeft(this.root);
			newTree.getRoot().setRight(t.root);
		} else {
			newTree.getRoot().setLeft(t.root);
			newTree.getRoot().setRight(this.root);
		}

		return newTree;

	}

	public int size() {
		// To do
		int size = 0;
		if (this.root == null) {
			return 0;
		} else {
			if (root.getLeft() != null) {
				size = size + root.getLeft().size();
			}
			if (root.getRight() != null) {
				size = size + root.getRight().size();
			}
			return size + 1;
		}
	}

	public int height() {
		if (this.root == null) {
			return 0;
		} else {
			int maxL = this.root.getLeft().height();
			int maxR = this.root.getRight().height();
			if (maxL > maxR) {
				return 1 + maxL;
			} else {
				return 1 + maxR;
			}
		}
	}

	public boolean full() {
		int k = this.root.height();
		int maxNodes = (int) (Math.pow(2, k) - 1);
		int size = this.root.size();
		return maxNodes == size;
	}

	public void mirror() {
		// To do
		BinaryTreeNode<T> tempL = this.root.getLeft();
		if (this.root != null) {
			if (this.root.getLeft() != null) {
				this.root.getLeft().mirror();
				this.root.setLeft(this.root.getRight());
			}
			if (this.root.getRight() != null) {
				this.root.getRight().mirror();
				this.root.setRight(tempL);
			}
		}
	}

	public String inOrder() {
		return this.root.inOrder();
	}

	public static void main(String[] args) {
		/*
		 * BinaryTree<Integer> testTree = new BinaryTree<Integer>();
		 * BinaryTreeNode<Integer> testLChild = new BinaryTreeNode<>();
		 * testLChild.setData(2); BinaryTreeNode<Integer> testRChild = new
		 * BinaryTreeNode<>(); testRChild.setData(3); BinaryTreeNode<Integer>
		 * testNode = new BinaryTreeNode<>(); testTree.setRoot(testNode);
		 * testNode.setData(1); testNode.setLeft(testLChild);
		 * testNode.setRight(testRChild); //System.out.println(testNode);
		 * BinaryTreeNode<Integer> CopyTestNode = testNode.deepCopy();
		 * //System.out.println(CopyTestNode);
		 * System.out.println(testTree.inOrder());
		 * //System.out.println(testLChild);
		 */

	}
}
