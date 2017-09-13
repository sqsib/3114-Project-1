
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
		//System.out.println("wtf");
		if(x == null) {
			System.out.println("x is null");
			return false;
		}

//		if(root.element.compareTo(x) < 0) {
//			root = remove(x, root.left);
//		}
//		else if(root.element.compareTo(x) > 0) {
//			root = remove(x,root.right);
//		}
//		else {
//			root = remove(x, root);
//
//		}
//		return true;
		
		remove(x, root);
		return true;


	}

	private BinaryNode remove(T x, BinaryNode node) {

		if(node == null) {
			System.out.println("node is null");
			return null;
		}

		if(node.element.compareTo(x) < 0) {
			node.right =  remove(x, node.right);
		}
		else if(node.element.compareTo(x) > 0) {
			node.left = remove(x, node.left);
		}
		else { //found node

			if(node.right == null && node.left == null) {
				System.out.println("First if statement");
				node = null;
			}
			else if(node.left == null) {

				node =  node.right;
				System.out.println("2nd if statement");

				//node.right = remove(x, node, node.right, 1);
			}
			else if(node.right == null ) {
				System.out.println("3rd if statement");

				node =  node.left;
				//node.left = remove(x, node, node.left, 0);
			}

			else {
				System.out.println("else  statement");

				//find the node rMin that hold minimum value in right subtree
				//BinaryNode t = node;
				BinaryNode rMin = findRMin(node.right);
				System.out.println("rmin is  " + rMin.element);
				//replace the current node with rMin element
				node.element = rMin.element;
				// node = deleteRMin(node.right);
				node.right = remove(rMin.element, node.right);
			
				//node.left = t.left; 

				//  return node;
				//recursive deletion of the rMin
			}
		}

		return node;
	}


	//Find the minimum value in right subtree
	private BinaryNode findRMin(BinaryNode node) {
		if(node == null) {
			return null;
		}
		else if(node.left == null) {
			return node;
		}
		else {

			return findRMin(node.left);
		}
	}

	public void clear() {

		root = deleteTree(root);


	}


	private BinaryNode deleteTree(BinaryNode node) {
		if(node == null) {
			return null;
		}
		
		node.left = deleteTree(node.left);
		node.right = deleteTree(node.right);
		node = null;

		
		return node;
		


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
	public void printTree() {
		inOrderPrint(root);
	}

	private void inOrderPrint(BinaryNode node) {
		if(node == null) 
			return;
		inOrderPrint(node.left);
		System.out.println(node.element);
		inOrderPrint(node.right);

	}
}


