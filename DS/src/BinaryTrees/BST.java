package BinaryTrees;

class BSTNode
{
	int data;
	BSTNode left;
	BSTNode right;
	BSTNode(int data)
	{
		this.data=data;
	}
}
public class BST {
	BSTNode root;//Root for the Binary Search Tree
	BST()
	{
		root=null;
	}
	BST(int data)
	{
		this.root = new BSTNode(data);
	}
	BSTNode search(BSTNode root, int data)
	{
		if(root==null) return null;
		if(root.data==data) return root; //Either equal
		if(data<root.data) //or smaller
		{
			return search(root.left,data);
		}
		else {
			return search(root.right,data);
		}
	}
	boolean searchItr(BSTNode root, int data)
	{
		if(root==null) return false;
		
		while(root!=null)
		{
			if(data==root.data)
			{
				return true;
			}
			else if(data<root.data)
			{
				root=root.left;
			}
			else
			{
				root=root.right;
			}
		}
		return false;
	}
	BSTNode insert(BSTNode root, int data) //TC equivalent to searching
	{
		if(root==null) 
		{
			return new BSTNode(data);
		}
		if(data<=root.data)
		{
			root.left = insert(root.left,data); //Insert Data to the left sub tree
		}
		else {
			root.right = insert(root.right,data);
		}
		return root; //Return the root
	}
	void preorder(BSTNode root)
	{
		if(root==null) return;
		System.out.print(root.data+" "); //Value
		preorder(root.left); //go to Left Sub Tree
		preorder(root.right); //go to Right Sub Tree
	}
	void inorder(BSTNode root)
	{
		if(root==null) return;
		inorder(root.left); //go to Left Sub Tree
		System.out.print(root.data+" "); //Value
		inorder(root.right); //go to Right Sub Tree
	}
	void postorder(BSTNode root)
	{
		if(root==null) return;
		postorder(root.left); //go to Left Sub Tree
		postorder(root.right); //go to Right Sub Tree
		System.out.print(root.data+" "); //Value
	}
	int getMin(BSTNode root) //Left Most Value
	{
		if(root==null) return -1;
		while(root.left!=null)
		{
			root=root.left;
		}
		return root.data;
	}
	int getMax(BSTNode root) //Right Most Value
	{
		if(root==null) return-1;
		while(root.right!=null)
		{
			root=root.right;
		}
		return root.data;
	}
	BSTNode delete(BSTNode root, int data)
	{
		if(root==null) return null;
		if(data<root.data)
		{
			root.left = delete(root.left,data); //Left  side se delete kro aur left side ko update krdo
		}
		else if(data>root.data)
		{
			root.right = delete(root.right,data); //Right side se delete kro aur Right side ko update krdo
		}
		else{
			//We have found the node to be deleted
			if(root.left == null) //1Child Case && No Child Case
			{
				return root.right;
			}
			if(root.right == null)
			{
				return root.left;
			}
			//2 Child Case
			root.data = getMin(root.right);
			root.right = delete(root.right,root.data);
		}
		return root;
	}
	BSTNode lcaBST(BSTNode root, int n1,int n2)
	{
		if(root==null) return null;
		if(n1<root.data && n2<root.data)
		{
			return lcaBST(root.left,n1,n2);
		}
		if(n1>root.data && n2>root.data)
		{
			return lcaBST(root.right,n1,n2);
		}
		//left is the case of being equal to n1 or n2 or one being on left side and the other being on right side, in that case root will be LCA
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();
		bst.root = bst.insert(bst.root,15);//Receive the updated root
		System.out.println(bst.root.data);
		bst.root = bst.insert(bst.root,10);
		bst.root = bst.insert(bst.root,17);
//		System.out.println(bst.root.right.data);
		System.out.println(bst.searchItr(bst.root, 17));
		System.out.println(bst.searchItr(bst.root, 19));
		System.out.println(bst.search(bst.root, 17).data); //Returns BSTNode
		bst.preorder(bst.root);
		System.out.println();
		bst.inorder(bst.root);
		System.out.println();
		bst.postorder(bst.root);
		System.out.println();
		bst.getMin(bst.root);
		System.out.println("Maximum in BST: "+bst.getMax(bst.root));
		bst.root = bst.delete(bst.root, 15);
		System.out.println(bst.root.data);
		System.out.println(bst.root.left.data);
		System.out.println(bst.lcaBST(bst.root, 10, 17).data);
		
	}

}

