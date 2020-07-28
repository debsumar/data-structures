package SinglyLL;

class Node{
	int data;
	Node next;
	Node (int data)
	{
		this.data = data;
		this.next = null;
	}
}

public class MyLL {
	
	static void print(Node head)
	{
		while(head!=null)
		{
			System.out.println(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	static Node insertAtHead(Node head, int data)
	{
		Node temp= new Node(data);
		temp.next = head;
		head = temp;
		return head;
	}
	static Node insertAtEnd(Node head, int data)
	{
		if(head == null)
		{
//			Node temp = new Node(data);
//			head = temp;
//			return head;
//			Node temp = new Node(data);
//			return temp; //Head will change hence return type Node
			return new Node(data);
		}
		Node temp = new Node(data);
		Node last = head;
		while(last.next != null)
		{
			last = last.next;
		}
		//LAst node found
		last.next = temp;
		return head;	//  No change but return required because of return type.
	}
	static Node insertAtPos(Node head, int data, int pos)
	{
		if(pos==1)
		{
			Node newNode = new Node(data);
			newNode.next = head;
//			head = newNode;
//			return head;
			return newNode;
		}
		Node newNode = new Node(data);
		Node temp = head;
		for(int i = 0;i<pos-2;i++)
		{
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}
	static Node deleteLL()
	{
		return null;
	}
	static Node deleteFromHead(Node head)
	{
		if(head.next == null)	//Only 1 element present
		{
			return null;
		}
		head = head.next;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = null;
		head = insertAtEnd(head,1);
		head = insertAtEnd(head,2);
		head = insertAtEnd(head,3);
		
		Node temp = head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
		print(head);
		

	}

}
