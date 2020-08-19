package BinaryTrees;

package trees;
import java.util.*;
class Node
{
	int data;
	Node left;
	Node right;
	Node(int data)
	{
		this.data=data;
	}
}
public class BinaryTree {
	Node root;//Root for the Binary Tree
	BinaryTree()
	{
		root=null;
	}
	BinaryTree(int data)
	{
		this.root = new Node(data);
	}
	//Find the sum of all Nodes in the tree
	int TreeSum(Node root)
	{
		if(root==null) return 0;
		return root.data+TreeSum(root.left)+TreeSum(root.right);
	}
	//Count total nodes in the tree
	int CountNodes(Node root)
	{
		if(root==null) return 0;
		return 1 + CountNodes(root.left)+CountNodes(root.right);
	}
	//Count Total Leaf Nodes in the tree
	int leafNodes(Node root)
	{
		if(root==null) return 0;
		if(root.left==null && root.right==null) return 1;
		return leafNodes(root.left) + leafNodes(root.right);
	}
	int height(Node root)
	{
		if(root==null) return -1;
		return 1+Math.max(height(root.left), height(root.right));
	}
	void printAtLevel(Node root, int level)
	{
		if(root==null) return;
		if(level==0)
		{
			System.out.print(root.data+" ");
			return;
		}
		printAtLevel(root.left,level-1);
		printAtLevel(root.right,level-1);
	}
	void preorder(Node root)
	{
		if(root==null) return;
		System.out.print(root.data+" "); //Value
		preorder(root.left); //go to Left Sub Tree
		preorder(root.right); //go to Right Sub Tree
	}
	void inorder(Node root)
	{
		if(root==null) return;
		inorder(root.left); //go to Left Sub Tree
		System.out.print(root.data+" "); //Value
		inorder(root.right); //go to Right Sub Tree
	}
	void postorder(Node root)
	{
		if(root==null) return;
		postorder(root.left); //go to Left Sub Tree
		postorder(root.right); //go to Right Sub Tree
		System.out.print(root.data+" "); //Value
	}
	boolean isIdentical(Node root1, Node root2)
	{
		if(root1==null && root2==null) return true; //If both are null then identical
		if(root1==null || root2==null) return false; //If any one null and other not then not identical
		return root1.data==root2.data 
				&& isIdentical(root1.left,root2.left) 
				&& isIdentical(root1.right,root2.right); 
	}
	boolean isMirror(Node root1, Node root2)
	{
		if(root1==null && root2==null) return true;
		if(root1==null || root2==null) return false;
		return root1.data==root2.data
				&& isMirror(root1.left,root2.right)
				&& isMirror(root1.right,root2.left);
	}
	
	boolean isIsomorphic(Node root1, Node root2)
	{
		if(root1==null && root2==null) return true;
		if(root1==null || root2==null) return false;
		return root1.data==root2.data
				&&(isIsomorphic(root1.left,root2.right)
				&& isIsomorphic(root1.right,root2.left)) ||
				(isIsomorphic(root1.left,root2.left) 
				&& isIsomorphic(root1.right,root2.right));
	}
	void toMirror(Node root)
	{
		if(root==null) return;
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		toMirror(root.left);
		toMirror(root.right);
	}
	boolean isSymmetric(Node root1, Node root2)
	{
		if(root1==null && root2==null) return true; //If both are null then Symmetric
		if(root1==null || root2==null) return false; //If any one null and other not then not Symmetric
		return isSymmetric(root1.left,root2.left) 
				&& isSymmetric(root1.right,root2.right); 
	}
	void bfsRec(Node root) //Not that efficient
	{
//		int height = height(root);
//		int levels = height+1;
		int levels = height(root)+1;
		System.out.println("-----BFS-----");
		for(int i=0;i<levels;i++) //Print all Levels
		{
			printAtLevel(root, i);
			System.out.println();
		}
	}
	void bfsIterative(Node root)
	{
		if(root==null) return;
		Queue<Node> q = new LinkedList<>();
		q.add(root); //Necessary to add the root first
		while(!q.isEmpty())
		{
			Node temp = q.poll(); //Uppar wala element uthaya
			System.out.print(temp.data+" "); //Print kiya usko
			if(temp.left!=null)
			{
				q.add(temp.left); //agar left bacha hai to queue mein daaldia
			}
			if(temp.right!=null)
			{
				q.add(temp.right); //agar right bacha hai to queue mein daaldia
			}
		}
		System.out.println();
	}
	Node findLCA(Node root, int n1,int n2)
	{
		if(root==null) return null;
		if(root.data==n1 || root.data==n2) return root;
		
		//If one node lies on left side and the other lies on right side then current root is LCA
		
		Node leftLCA = findLCA(root.left,n1,n2);
		Node rightLCA = findLCA(root.right,n1,n2);
		if(leftLCA!=null && rightLCA!=null) 
		{
			return root;
		}
		if(leftLCA!=null) return leftLCA; //agar sirf left se aya to vahi answer hai
		return rightLCA; //agar sirf right se aya to vahi answer hai
	}
	int levelToBePrinted = 0; //Single value for all function calls
	void leftView(Node root,int level)
	{
		if(root==null) return;
		if(level==levelToBePrinted)
		{
			System.out.print(root.data+" ");
			levelToBePrinted++;
		}
		leftView(root.left,level+1); //Same level for the children (level+1)
		leftView(root.right, level+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree(2);//Create a tree with 2 as the root.
		bt.root.left=new Node(3);
		bt.root.right=new Node(5);
		bt.root.left.right=new Node(9);
		bt.root.right.left = new Node(7);
		System.out.println("Sum of all Nodes: "+bt.TreeSum(bt.root));
		System.out.println("Total number of Nodes: "+bt.CountNodes(bt.root));
		System.out.println("Total Leaf Nodes:"+bt.leafNodes(bt.root));
		System.out.println("Height of Tree: "+bt.height(bt.root));
		bt.printAtLevel(bt.root, 0);
		System.out.println();
		bt.printAtLevel(bt.root, 1);
		System.out.println();
		bt.printAtLevel(bt.root, 2);
		System.out.println();
		bt.preorder(bt.root);
		System.out.println();
		bt.inorder(bt.root);
		System.out.println();
		bt.postorder(bt.root);
		System.out.println();
		
		//Creating same tree as bt
		
		BinaryTree bt2 = new BinaryTree(2);//Create a tree with 2 as the root.
		bt2.root.left=new Node(3);
		bt2.root.right=new Node(5);
		bt2.root.left.right=new Node(9);
		bt2.root.right.left = new Node(7);
		
		//Same tree created
		System.out.println(bt.isIdentical(bt.root, bt2.root));
		
		//Creating Mirror tree as bt
		BinaryTree bt3 = new BinaryTree(2);
		bt3.root.left=new Node(5);
		bt3.root.right=new Node(3);
		bt3.root.left.right=new Node(7);
		bt3.root.right.left = new Node(9);
		//Mirror tree created
		
		System.out.println(bt.isMirror(bt.root, bt3.root)); //Checking Mirror bt && bt 3
		System.out.println(bt.isMirror(bt.root, bt2.root)); //Checking Mirror bt && bt 2
		
		//Converting bt3 into its mirror
		bt3.toMirror(bt3.root);
		//If successfully converted to mirror then now bt3 and bt should be equal
		System.out.println(bt.isIdentical(bt.root, bt3.root));
		
		System.out.println(bt.isIdentical(bt.root, bt3.root)); //Checking if Symmetric
		//Changing structure of bt3
		System.out.println(bt.isIsomorphic(bt.root, bt3.root))
		
		bt3.root.right.left.right = new Node(10);
		System.out.println(bt.isIdentical(bt.root, bt3.root)); //Checking if Symmetric
		
		bt.bfsRec(bt.root);
		bt.bfsIterative(bt.root);
		System.out.println(bt.findLCA(bt.root, 3, 2).data);
		System.out.println(bt.findLCA(bt.root, 5, 7).data);
		System.out.println(bt.findLCA(bt.root, 2, 9).data);
		bt.leftView(bt.root, 0);
		System.out.println();
		bt.levelToBePrinted = 0; //Needs to be re-initialized
		bt.leftView(bt.root, 0);
		
	}

}
