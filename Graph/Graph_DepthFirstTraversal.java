package algorithm.graph;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

/* 
 *   <0 -------> 1
 * 	| |       /
 *  | |      / 
 *  | |    /
 *   <2--------> 3
 *  	
*/	  	
public class Graph_DepthFirstTraversal {
	
	private int V; // no of vertices
	
	// Array of Lists for Adjacency List Representation
	private LinkedList<Integer> adj[];
	
	public Graph_DepthFirstTraversal(int v) {
		this.V = v;
		adj = new LinkedList[v];
		
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList();
		}
	}
	
	
	// Function to add an edge into the graph
	public void addEdge(int v, int w){
			adj[v].add(w); // Add w to v's list;
	}
	
	// Function used by DFS
	void DFSUtil(int v, boolean visited[]) {
			// Mark the current node as visited and print it
			visited[v] = true;
			System.out.println(v+" ");
			
			// Recur for all the vertices adjacent to this vertex
			Iterator<Integer> i = adj[v].listIterator();
			
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					DFSUtil(n,visited);
				}
			}
	}
	
	// The function to do DFS traversal. It uses recursive DFSUtil();
	void DFS(int v){
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];
				
		// Call the recursive helper function to print DFS traversal
		DFSUtil(v,visited);
	}
	
	public static void main(String ar[]){
			Graph_DepthFirstTraversal g_dfs = new Graph_DepthFirstTraversal(4);
			
			g_dfs.addEdge(0, 1);
			g_dfs.addEdge(0, 2);
			g_dfs.addEdge(1, 2);
			g_dfs.addEdge(2, 0);
			g_dfs.addEdge(1, 3);
			g_dfs.addEdge(3, 3);
			
			System.out.println("Following is the Depth first traversal" +
					" starting from vertex 2");
			
			g_dfs.DFS(2);
	}
		
	
}
