package greedy;
import java.util.*;

class DisjointSet {
	ArrayList<Integer> size = new ArrayList<Integer>();
	ArrayList<Integer> parent = new ArrayList<Integer>();
	
	public DisjointSet(int n) {
		for(int i=0;i<=n;i++) {
			size.add(1);
			parent.add(i);
		}
	}
	
	public int findParent(int node) {
		if(node == parent.get(node)) 
			return node;
		
		int ulp = findParent(parent.get(node));
		parent.set(node, ulp);
		return parent.get(node);
	}
	
	public void unionBySize(int u, int v) {
		int ulp_u = findParent(u);
		int ulp_v = findParent(v);
		
		if(ulp_u == ulp_v) return;
		
		if(size.get(ulp_u) < size.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
 		}
		else {
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
		}
	}
}

public class UnionBySize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointSet ds = new DisjointSet(7);
		
		ds.unionBySize(1, 2);
		ds.unionBySize(2, 3);
		ds.unionBySize(4, 5);
		ds.unionBySize(6, 7);
		ds.unionBySize(5, 6);
		
		// if 3 and 7 are same or not
		if(ds.findParent(3) == ds.findParent(7))
			System.out.println("Same");
		else
			System.out.println("Not same");
		
		ds.unionBySize(3, 7);
		
		if(ds.findParent(3) == ds.findParent(7))
			System.out.println("Same");
		else
			System.out.println("Not same");
	}

}
