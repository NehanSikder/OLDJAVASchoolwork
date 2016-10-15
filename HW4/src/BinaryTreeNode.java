
public class BinaryTreeNode<T> {

	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;

	public BinaryTreeNode() {
		this(null, null, null);
	}

	public BinaryTreeNode(T theData) {
		this(theData, null, null);
	}

	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	public int size() {
		int size = 0; // the size of the tree

		// The size of the tree rooted at this node is one more than the
		// sum of the sizes of its children.
		if (left != null) {
			size = size + left.size();
		}
		if (right != null) {
			size = size + right.size();
		}
		return size + 1; // add one to account for the current node
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> deepCopy() {
		BinaryTreeNode<T> copy = new BinaryTreeNode<T>(this.data);
		BinaryTreeNode<T> newLeft = null;
		BinaryTreeNode<T> newRight = null;
		// if (this.left != null && this.right != null) {
		// newLeft = (this.left.deepCopy());
		// newRight = (this.right.deepCopy());
		// copy.setLeft(newLeft);
		// }
		// if (this.right != null) {
		// newRight.setRight(this.right.deepCopy());
		// // copy.setRight(newRight);
		// }

		if (this.left != null) {
			newLeft = (this.left.deepCopy());
		}
		if (this.right != null) {
			newRight = (this.right.deepCopy());
		}
		copy.setLeft(newLeft);
		copy.setRight(newRight);
		return copy;
	}

	// done
	@Override
	public boolean equals(Object o) {
		if (o instanceof BinaryTreeNode<?>) {
			@SuppressWarnings("unchecked")
			BinaryTreeNode<T> x = (BinaryTreeNode<T>) o;
			// base case
			if (this.left == null && this.right == null) {
				return this.data.equals(x.data);
			} else if (this.left != null && this.right == null) {
				return this.left.equals(x.left) && this.data.equals(x.data);
			} else if (this.right != null && this.left == null) {
				return this.right.equals(x.right) && this.data.equals(x.data);
			} else {
				return this.left.equals(x.left) && this.right.equals(x.right) && this.data.equals(x.data);

			}
		}
		return false;

	}

	// done
	public int height() {
		int rheight = 0;
		int lheight = 0;
		if (left != null) {
			lheight = lheight + left.height();
		}
		if (right != null) {
			rheight = rheight + right.height();
		}
		if (rheight > lheight) {
			return rheight + 1;
		} else {
			return lheight + 1;
		}
	}

	// done
	public boolean full() {
		return left != null && right != null;

	}

	public void mirror() {
		BinaryTreeNode<T> temp = this.left;
		if (this.left != null) {
			this.left.mirror();
			this.left = this.right;
		}
		if (this.right != null) {
			this.right.mirror();
			this.right = temp;
		}
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [left=" + left + ", right=" + right + ", data=" + data + "]";
	}

	public String inOrder() {
		String output = "";
		if (this.left != null) {
			output += this.left.inOrder();
		}
		if (this.data != null) {
			output += "(" + this.data + ")";
		}
		if (this.right != null) {
			output += this.right.inOrder();
		}
		return output;
	}

	private static void indent(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(' '); // print a space
		}
	}

	/*
	 * Prints the tree with indentation corresponding to level - fancy pre-order
	 */
	/* Using depth level of this node, for indentation */
	public void printIndented(int depth) {
		System.out.println(this.data);
		depth++;
		if (this.left != null) {
			indent(2 * depth);
			System.out.print("Left:  ");
			this.left.printIndented(depth);
		}
		if (this.right != null) {
			indent(2 * depth);
			System.out.print("Right:  ");
			this.right.printIndented(depth);
		}
	}

	public static void main(String[] args) {
		// BinaryTree<Integer> testTree = new BinaryTree<Integer>();
		// BinaryTreeNode<Integer> testLChild = new BinaryTreeNode<>();
		// testLChild.setData(2);
		// BinaryTreeNode<Integer> testRChild = new BinaryTreeNode<>();
		// testRChild.setData(3);
		// BinaryTreeNode<Integer> testLChild2 = new BinaryTreeNode<>();
		// testLChild2.setData(4);
		// BinaryTreeNode<Integer> testRChild2 = new BinaryTreeNode<>();
		// testRChild2.setData(5);
		// BinaryTreeNode<Integer> testNode = new BinaryTreeNode<>();
		// testTree.setRoot(testNode);
		// testNode.setData(1);
		// testNode.setLeft(testLChild);
		// testNode.setRight(testRChild);
		// testLChild.setRight(testRChild2);
		// testLChild.setLeft(testLChild2);
		// testRChild.setRight(testRChild2);
		// testRChild.setLeft(testLChild2);
		// BinaryTreeNode<Integer> copyTestNode = testNode.deepCopy();
		// // System.out.println(testNode.inOrder());
		// BinaryTreeNode<Integer> data8 = new BinaryTreeNode<>(8);
		// BinaryTreeNode<Integer> data4 = new BinaryTreeNode<>(4);
		// BinaryTreeNode<Integer> data2 = new BinaryTreeNode<>(2);
		// BinaryTreeNode<Integer> data5 = new BinaryTreeNode<>(5);
		// BinaryTreeNode<Integer> data1 = new BinaryTreeNode<>(1);
		// BinaryTreeNode<Integer> data3 = new BinaryTreeNode<>(3);
		// BinaryTreeNode<Integer> data7 = new BinaryTreeNode<>(7);
		// BinaryTreeNode<Integer> data9 = new BinaryTreeNode<>(9);
		// BinaryTreeNode<Integer> data10 = new BinaryTreeNode<>(10);
		//
		// BinaryTreeNode<Integer> testNode2 = new BinaryTreeNode<>(6);
		//
		// testNode2.setLeft(data4);
		// testNode2.setRight(data8);
		// data4.setLeft(data2);
		// data4.setRight(data5);
		// data2.setLeft(data1);
		// data2.setRight(data3);
		// data8.setLeft(data7);
		// data8.setRight(data9);
		// data9.setRight(data10);
		// System.out.println(testNode2.inOrder());
	}

}
