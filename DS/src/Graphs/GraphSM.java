package Graphs;

import java.util.*;
class GraphImp
{
	HashMap<Integer, HashSet<Integer>> graph = new HashMap<>(); //Structure created
	void addVertex(int data)
	{
		if(graph.containsKey(data))
		{
			System.out.println("Error: Vertex "+data+" already Exists");
			return;
		}
		graph.put(data,new HashSet<>());
	}
	void addEdge(int start, int end)
	{
		graph.get(start).add(end);
	}
	void print()
	{
		System.out.println("Vertices are: "+graph.keySet());
		for(Integer x:graph.keySet())
		{
			System.out.print("Neighbours of "+x+" are: ");
			System.out.println(graph.get(x));//Printing the set containing neighbours
		}
	}
	void BFS(int s) 
	{
		System.out.println("-------BFS-------");
		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		visited.add(s);
		q.add(s);
		while(!q.isEmpty())
		{
			int temp =q.poll();
			System.out.print(temp+" ");
			for(Integer x:graph.get(temp))
			{
				if(!visited.contains(x))
				{
					
					visited.add(x);
					q.add(x);
				}
			}
			
		}
		System.out.println();
	}
	void DFS(int s)
	{
		System.out.println("-------DFS-------");
		HashSet<Integer> visited = new HashSet<>();
		DFSUtil(s,visited); //Utility/Helper - To pass the same array to the recursive function
		System.out.println();
	}
	void DFSUtil( int s, HashSet<Integer> visited)
	{
		visited.add(s);
		System.out.print(s+" ");
		for(Integer x:graph.get(s))
		{
			if(!visited.contains(x))
			{
				
				DFSUtil(x,visited);
			}
		}
	}
}
public class GraphSM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphImp g = new GraphImp();
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addEdge(0, 1);
		g.addEdge(0, 1); //Duplicate neighbour problem
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addVertex(0);
		g.print();
		g.BFS(0); //Start from 0
		g.BFS(1);
		g.BFS(2);
		g.BFS(3);
		g.BFS(4);
		g.DFS(0);
	}

}
