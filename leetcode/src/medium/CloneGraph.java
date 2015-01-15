package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

	@Override
	public String toString() {
		return "UndirectedGraphNode [label=" + label + ", neighbors=" + neighbors + "]";
	}
}

public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Map<Integer, UndirectedGraphNode> map = new HashMap<>();

		queue.add(node);
		
		while (queue.isEmpty() == false) {
			UndirectedGraphNode n = queue.poll();
			for (UndirectedGraphNode nn : n.neighbors) {
				if (map.containsKey(nn.label)) continue;
				map.put(nn.label, new UndirectedGraphNode(nn.label));
				queue.add(nn);
			}
			map.put(n.label, new UndirectedGraphNode(n.label));
		}		
		queue.clear();
		queue.add(node);
		UndirectedGraphNode copy = map.get(node.label);
		
		Set <Integer> visited = new HashSet <>();
		while (queue.isEmpty() == false) {
			UndirectedGraphNode n = queue.poll();
			List <UndirectedGraphNode> list = new ArrayList<>();
			for (UndirectedGraphNode nn : n.neighbors) {
				list.add(map.get(nn.label));
				if (visited.contains(nn.label) == false) {
					visited.add(nn.label);
					queue.add(nn);
				} 
			}	
			for (UndirectedGraphNode cks : list) {
				map.get(n.label).neighbors.add(cks);
			}	
		}
		return copy;
	}

	private void printBFS(UndirectedGraphNode copy) {
		Queue <UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(copy);
		Set <Integer> set = new HashSet<>();
		
		while (queue.isEmpty() == false) {
			UndirectedGraphNode node = queue.poll();
			for (UndirectedGraphNode n : node.neighbors) {
				if (set.contains(node.label) == false) {
					System.out.println(node.label + "  => " + n.label);
				}
				if (set.contains(n.label) == false) {
					queue.add(n);
				}
			}	
			
			set.add(node.label);
		}
	}
	
	public static void main(String[] args) {
		UndirectedGraphNode zer = new UndirectedGraphNode(0);
		UndirectedGraphNode one = new UndirectedGraphNode(0);
		UndirectedGraphNode two = new UndirectedGraphNode(0);

		List<UndirectedGraphNode> l0 = new ArrayList<>(Arrays.asList(one, two));
		//List<UndirectedGraphNode> l1 = new ArrayList<>(Arrays.asList(two));
		//List<UndirectedGraphNode> l2 = new ArrayList<>(Arrays.asList(two));
		zer.neighbors = l0;
		//one.neighbors = l1;
		//two.neighbors = l2;
		
		CloneGraph sol = new CloneGraph();
		UndirectedGraphNode copy = sol.cloneGraph(zer);
		sol.printBFS(copy);
		
		
		
	}
}
