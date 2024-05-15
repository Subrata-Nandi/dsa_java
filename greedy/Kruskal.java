package greedy;
import java.util.*;
//import greedy.Prims;

class Edge implements Comparable<Edge> {
	int src, dest, wt;
	
	Edge(int src, int dest, int wt) {
		this.src = src;
		this.dest = dest;
		this.wt = wt;
	}

	@Override
	public int compareTo(Edge other) {
		// TODO Auto-generated method stub
		return this.wt - other.wt;
	}
}

public class Kruskal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		int v = 6;
		
		// Create adjacency list representation of the graph
		for(int i=0;i<=v;i++) {
			adj.add(new ArrayList<>());
		}
		
		// Add edges to the graph
		Prims.addEdge(adj, 1, 2, 2);
		Prims.addEdge(adj, 1, 4, 1);
		Prims.addEdge(adj, 1, 5, 4);
		Prims.addEdge(adj, 2, 3, 3);
		Prims.addEdge(adj, 2, 6, 7);
		Prims.addEdge(adj, 2, 4, 3);
		Prims.addEdge(adj, 3, 6, 8);
		Prims.addEdge(adj, 3, 4, 5);
		Prims.addEdge(adj, 4, 5, 9);
		
		List<Edge> edges = new ArrayList<Edge>();
		
		for(int i=0;i<adj.size();i++) {
			for(int j=0;j<adj.get(i).size();j++) {
				int adjNode = adj.get(i).get(j).node;
				int weight = adj.get(i).get(j).wt;
				int node = i;
				Edge temp = new Edge(i, adjNode, weight);
				edges.add(temp);
			}
		}
		
		// Apply Kruskal's algorithm to find MST
		
		DisjointSet ds = new DisjointSet(v);
		Collections.sort(edges);
		
		int mst = 0;
		
		for(int i=0;i<edges.size();i++) {
			int wt = edges.get(i).wt;
			int u = edges.get(i).src;
			int w = edges.get(i).dest;
			
			// Checking if belong to same component, if yes don't add, it will form cycle, else add
			if(ds.findParent(u) != ds.findParent(w)) {
				mst += wt;	// Calculate total weight of the mst
				ds.unionBySize(u, w);
			}
		}
		
		System.out.println("The total weight of the mst is: " + mst);
	}

}


/*

Output:

The total weight of the mst is: 17

*/