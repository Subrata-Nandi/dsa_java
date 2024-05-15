package greedy;
import java.util.*;

class Pair {
	int node;
	int wt;
	Pair(int node, int wt) {
		this.node = node;
		this.wt = wt;
	}
}



public class Prims {
	
	// Utility method to add edge to adjacency list
	public static void addEdge(ArrayList<ArrayList<Pair>> adj, int src, int dest, int wt) {
		adj.get(src).add(new Pair(dest, wt));
		adj.get(dest).add(new Pair(src, wt));
	}
	
	public static ArrayList<Pair> MST(ArrayList<ArrayList<Pair>> adj, int v) {
		ArrayList<Pair> arr = new ArrayList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.wt - y.wt);
		boolean visited[] = new boolean[v+1];
		
		// Start from vertex 0
		pq.add(new Pair(0, 0));
		
		while(!pq.isEmpty()) {
			Pair minEdge = pq.poll();
			int vertex = minEdge.node;
			
			// Skip if vertex is already visited
			if(visited[vertex]) continue;
			
			// Mark vertex as visited
			visited[vertex] = true;
			
			// Add the minimum weight edge to MST
			arr.add(minEdge);
			
			// Explore adjacent vertices
			for(Pair adjNode: adj.get(vertex)) {
				int edge = adjNode.node;
				if(!visited[edge]) {
					pq.add(adjNode);
				}
			}
		}
		
		return arr;
	}
	
	public static void main(String args[]) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		int v = 6;
		
		// Create adjacency list representation of the graph
		for(int i=0;i<=v;i++) {
			adj.add(new ArrayList<>());
		}
		
		// Add edges to the graph
		addEdge(adj, 0, 1, 2);
		addEdge(adj, 0, 3, 6);
		addEdge(adj, 3, 1, 8);
		addEdge(adj, 1, 2, 3);
		addEdge(adj, 1, 4, 5);
		addEdge(adj, 4, 2, 7);
		
		
		// Apply Prim's algorithm to find MST
		ArrayList<Pair> arr = MST(adj, v);
		
		// Calculate total weight of the mst
		int totalWeight = 0;
		for(Pair it: arr) {
			totalWeight += it.wt;
		}
		
		System.out.println("The total weight of the mst is: " + totalWeight);
	}
}


/*

Output:

The total weight of the mst is: 16

*/




/*

import java.util.*;

class Pair {
    int vertex, weight;

    Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Prims1 {
    public static void main(String[] args) {
        // Number of vertices
        int V = 4;

        // Create adjacency list representation of the graph
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(adjList, 0, 1, 10);
        addEdge(adjList, 0, 2, 6);
        addEdge(adjList, 0, 3, 5);
        addEdge(adjList, 1, 3, 15);
        addEdge(adjList, 2, 3, 4);

        // Apply Prim's algorithm to find MST
        List<Pair> mst = primMST(adjList, V);

        // Print MST
        System.out.println("Minimum Spanning Tree (MST):");
        int totalCost = 0;
        for (Pair edge : mst) {
            //System.out.println("0 - " + edge.vertex + " : " + edge.weight);
            totalCost += edge.weight;
        }
        System.out.println("Total Cost: " + totalCost);
    }

    // Utility method to add edge to adjacency list
    private static void addEdge(ArrayList<ArrayList<Pair>> adjList, int src, int dest, int weight) {
        adjList.get(src).add(new Pair(dest, weight));
        adjList.get(dest).add(new Pair(src, weight)); // For undirected graph
    }

    // Prim's algorithm to find MST
    private static List<Pair> primMST(ArrayList<ArrayList<Pair>> adjList, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        boolean[] visited = new boolean[V];
        List<Pair> mst = new ArrayList<>();

        // Start from vertex 0
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair minEdge = pq.poll();
            int vertex = minEdge.vertex;

            // Skip if vertex is already visited
            if (visited[vertex]) continue;

            // Mark vertex as visited
            visited[vertex] = true;

            // Add the minimum weight edge to MST
            mst.add(minEdge);

            // Explore adjacent vertices
            for (Pair adjEdge : adjList.get(vertex)) {
                if (!visited[adjEdge.vertex]) {
                    pq.offer(adjEdge);
                }
            }
        }

        return mst;
    }
}

*/