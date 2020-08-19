package Graphs;

import java.util.*;
class Graph
{
	int v;//No of vertices
//	int arr[] = new int[5];
	LinkedList<Integer> arr[];
	Graph(int v)
	{
		this.v = v;
		arr = new LinkedList[v]; //Only created an array to store LL's
		for(int i=0;i<v;i++)
		{
			arr[i] = new LinkedList<>(); //Initializing empty LL's at each array index.
		}
	}
	void addEdge(int start, int end)
	{
		arr[start].add(end);//Edge Created
//		arr[end].add(start); //If we want un/bidirectional Graph
	}
	
	void print()
	{
		for(int i=0;i<v;i++)
		{
			//Print the neighbor list for all vertices
			System.out.println("Neighbors of "+i+" are: ");
			for(Integer x:arr[i]) //One by one neighbors will come in x
			{
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
	void BFS(int s)
	{
		System.out.println("-------BFS-------");
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[v];
		q.add(s);
		visited[s] = true;
		while(!q.isEmpty())
		{
			int temp = q.poll();
			System.out.print(temp+" ");
			for(Integer x:arr[temp])
			{
				if(!visited[x])
				{
					q.add(x);
					visited[x] = true;
				}
			}
		}
		System.out.println();
	}
	void DFS(int s)
	{
		System.out.println("-------DFS-------");
		boolean visited[] = new boolean[v];
		DFSUtil(s,visited); //Utility/Helper - To pass the same array to the recursive function
		System.out.println();
	}
	void DFSUtil(int s, boolean visited[])
	{
		visited[s] = true;
		System.out.print(s+" ");
		for(Integer x:arr[s]) //One by one neighbors come in x
		{
			if(!visited[x])// if neighbor not visited
			{
				DFSUtil(x,visited); //Pass the neighbor but the same visited array
			}
		}
	}
}
public class GraphLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 1); //Duplicate neighbor problem
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.print();
		g.BFS(0); //Start from 0
		g.BFS(1);
		g.BFS(2);
		g.BFS(3);
		g.BFS(4);
		g.DFS(0);
	}

}
