package greedy;
import java.util.*;

class Solution {
	
	public ArrayList<Integer> bfsOfGraph(int s, ArrayList<ArrayList<Integer> > adj) {
		
		ArrayList<Integer> bfs = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[adj.size()];
		
		q.add(s);
		visited[s] = true;
		
		while(!q.isEmpty()) {
			Integer node = q.poll();
			bfs.add(node);
			
			for(Integer it: adj.get(node)) {
				if(visited[it] == false) {
					visited[it] = true;
					q.add(it);
				}
			}
		}
		return bfs;
	}
}

public class BFS {
	
	int v;
	static ArrayList<ArrayList<Integer>> adj;
	
	BFS(int v) {
		this.v = v;
		adj = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=v;i++) 
			adj.add(new ArrayList<Integer>());
	}
	
	void addEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	void printList(ArrayList<ArrayList<Integer> > adj) {
		for(int i=1;i<adj.size();i++) {
			for(int j=0;j<adj.get(i).size();j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		BFS g = new BFS(5);
		
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(4, 5);
		
//		g.printList(adj);
		
		Solution obj = new Solution();
		ArrayList<Integer> arr = obj.bfsOfGraph(5, adj);
		
		System.out.println("Breadth first search traversal: ");
		for(Integer i: arr) {
			System.out.print(i + " ");
		}
	}
}


/*
Output:

Breadth first search traversal: 
5 2 4 1 3 
*/