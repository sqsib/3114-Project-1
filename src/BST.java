
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

		return findHelper(x, root);
	}

	private T findHelper(T x, BinaryNode sRoot) {
		if ( sRoot == null )
			return null;
		int compareResult = x.compareTo( sRoot.element );

		if ( compareResult < 0 )
			return findHelper( x, sRoot.left );
		else if ( compareResult > 0 )
			return findHelper( x, sRoot.right );
		else
			return sRoot.element; // Match

	}
	public boolean insert( T x ) { 

		T temp = find(x);
		if(temp == null) {
			root = insertHelper(x, root);
			return true;
		}
		else {
			return false;
		}
	}

	private BinaryNode insertHelper(T x, BinaryNode sRoot) {
		if ( sRoot == null )
			return new BinaryNode( x, null, null );
		int compareResult = x.compareTo( sRoot.element );
		if ( compareResult < 0 )
			sRoot.left = insertHelper( x, sRoot.left );
		else if ( compareResult > 0 )
			sRoot.right = insertHelper( x, sRoot.right );
		else
			;
		return sRoot;
	}

	public boolean remove( T x ) { 
		return false;
	}

	public void clear( ) { 
	}

	public boolean equals(Object other) { 
		if(other == null) {
			return false;
		}

		if(!this.getClass().equals(other.getClass())) {
			return false;
		}

		BST<T> obj = (BST<T>)other;
		BinaryNode otherRoot = obj.root;
		return equalsHelper(root, otherRoot);
	}

	//Binary Search Trees are equal if the roots are equal
	// and the roots' children are equal, each child can be 
	// a root
	public boolean equalsHelper(BinaryNode n1, BinaryNode n2) {
		//check if n1 and n2 are the same thing
		if(n1 == n2) {
			return true;
		}
		//if either of the roots are null return false
		if(n1 == null) {
			return false;
		}
		if(n2 == null) {
			return false;
		}

		// check actual data of the root, then 
		// recursively check the left and right chlild
		// as they are the root of their own 
		// respective subtree
		if(!(n1.element.equals(n2.element))) {
			return false;
		}
		else {
			if((equalsHelper(n1.right, n2.right) && equalsHelper(n1.left, n2.left))) {
				return true;
			}
			else {
				return false;
			}
		}



	}
	// private methods follow

}