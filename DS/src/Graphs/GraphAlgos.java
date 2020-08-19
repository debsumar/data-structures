//Adjacency Matrix Implementation
package Graphs;
import java.util.*;
public class GraphAlgos {
	static void dijkstras(int adjMatrix[][], int source)
	{
		int v = adjMatrix.length; //No of vertices
		boolean visited[] = new boolean[v];
		int distance[] = new int[v];
		for(int i=0;i<v;i++)
		{
			distance[i] = Integer.MAX_VALUE;
		}
		distance[source] = 0;
		for(int i=0;i<v-1;i++)
		{
			int minVertex = findMinVertex(distance,visited); //Pick the minimum unvisited vertex
			visited[minVertex] = true;//Visit it
			for(int j=0;j<v;j++) //Traverse neighbors of minVertex in that row
			{
				if(adjMatrix[minVertex][j]!=0 && !visited[j])//Not Zero means neighbor
				{
					int newDistance = distance[minVertex] + adjMatrix[minVertex][j];
					if(newDistance<distance[j])
					{
						distance[j] = newDistance;
					}
				}
			}
		}
		System.out.println("Shortest paths from "+source+" are: ");
		for(int i=0;i<v;i++)
		{
			System.out.print(distance[i]+ " ");
		}
		System.out.println();
	}
	static int findMinVertex(int distance[], boolean visited[])
	{
		int minVertex = -1;//In case 0th element already visited so we dont have to consider it.
		for(int i=0;i<distance.length;i++)
		{
			if(!visited[i] && (minVertex==-1 || distance[i]<distance[minVertex]))
			{
				minVertex = i;
			}
		}
		return minVertex;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Vertices: ");
		int v = sc.nextInt();
		System.out.println("Enter number of Edges: ");
		int e = sc.nextInt();
		int adjMatrix[][] = new int[v][v];
		System.out.println("Enter each Edge: ");
		for(int i=0;i<e;i++)
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int w = sc.nextInt();
			adjMatrix[v1][v2] = w;
			adjMatrix[v2][v1] = w;
		}
		//Graph Created.
		dijkstras(adjMatrix,0);
	}

}
