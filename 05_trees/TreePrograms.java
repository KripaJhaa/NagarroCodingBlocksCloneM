import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
class VMap{
	HashMap<Integer, ArrayList<Integer>> map;
	public VMap() {
		map = new HashMap<>();
	}
}
class ParentArrayTree {
	class Node {
		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}

		
	Node root;

	void createNode(int parent[], int i, Node created[]) {
		if (created[i] != null)
			return;

		created[i] = new Node(i);

		if (parent[i] == -1) {
			root = created[i];
			return;
		}

		if (created[parent[i]] == null)
			createNode(parent, parent[i], created);

		Node p = created[parent[i]];

		if (p.left == null)
			p.left = created[i];
		else // If second child

			p.right = created[i];
	}

	Node createTree(int parent[], int n) {
		Node[] created = new Node[n];
		for (int i = 0; i < n; i++)
			created[i] = null;

		for (int i = 0; i < n; i++)
			createNode(parent, i, created);

		return root;
	}

	void preOrder(Node node) {
		if (node == null)
			return;

		System.out.print(node.key + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	void verticalOrder(Node node, VMap vm, int v) {
		if(node == null)
			return;
		ArrayList<Integer> al = vm.map.get(v);
		if(al == null) {
			al = new ArrayList<>();
			al.add(node.key);
		}
		else
			al.add(node.key);
		vm.map.put(v, al);
		verticalOrder(node.left, vm, v - 1);
		verticalOrder(node.right, vm, v + 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			ParentArrayTree bst = new ParentArrayTree();
			int parent[] = new int[n];
			for (int i = 0; i < n; i++)
				parent[i] = sc.nextInt();
			Node node = bst.createTree(parent, n);
			//bst.preOrder(node);
			//System.out.println();
			VMap vm = new VMap();
			bst.verticalOrder(node, vm, 0);
			Map<Integer, ArrayList<Integer>> map = new TreeMap<>(vm.map);
			
			for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			/*	entry.getValue().sort(new Comparator<Integer>() {
					public int compare(Integer a, Integer b) {
						return a.compareTo(b);
					}
				});*/
	            for(int i = 0; i < entry.getValue().size(); i++) {
	            	System.out.print(entry.getValue().get(i) + " ");
	            }
	            System.out.println();
	        }
		}
	}
}
