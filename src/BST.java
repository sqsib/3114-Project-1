
public class BST<T extends Comparable<? super T>> {


	class BinaryNode {

		// Constructors
		public BinaryNode( T elem) {
			this.element = elem;
			this.right = null;
			this.left = null;

		}
		public BinaryNode( T elem, BinaryNode lt, BinaryNode rt ) {
			this.element = elem;
			this.left = lt;
			this.right = rt;

		}

		// The node class and the following members have package access:
		T element; // The data in the node
		BinaryNode left; // Pointer to the left child
		BinaryNode right; // Pointer to the right child
	}

	BinaryNode root; // pointer to root node, if present
	public BST( ) {  
		this.root = null;
	}

	public boolean isEmpty( ) {  
		return (root == null);
	}

	public T find( T x ) { 

		return x;
	}
	public boolean insert( T x ) { 

		return false;
	}

	public boolean remove( T x ) { 
		return false;
	}

	public void clear( ) { 
	}

	public boolean equals(Object other) { 
		return false;
	}
	// private methods follow

}