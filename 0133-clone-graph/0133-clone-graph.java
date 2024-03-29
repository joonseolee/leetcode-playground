/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node copy = new Node(node.val);
        Node[] visited = new Node[101];
        dfs(node , copy , visited);
        return copy;
    }
    
    public void dfs(Node node , Node copy , Node[] visited) {
        visited[copy.val] = copy;
        for (Node n : node.neighbors) {
            if (visited[n.val] == null) {
                Node newNode = new Node(n.val);
                copy.neighbors.add(newNode);
                dfs(n , newNode , visited);
            } else {
                copy.neighbors.add(visited[n.val]);
            }
        }
    }
    
    
//     public Node cloneGraph(Node node) {
//         if (node == null) {
//             return null;
//         }
//         Map<Integer, Node> map = new HashMap<>();
//         fillUniqueMap(node, map);
//         addNeighbours(node, map, new HashSet<>());
//         return map.get(node.val);
//     }


//     public void fillUniqueMap(Node node, Map<Integer, Node> map) {
//         if (node == null || map.containsKey(node.val)) {
//             return;
//         }
        
//         map.put(node.val, new Node(node.val));
//         for (Node one : node.neighbors) {
//             fillUniqueMap(one, map);
//         }
//     }


//     public void addNeighbours(Node node, Map<Integer, Node> map, Set<Integer> visited) {
//         if (node == null || visited.contains(node.val)) {
//             return;
//         }
        
//         visited.add(node.val);
//         Node cloneNode = map.get(node.val);
//         for (Node one : node.neighbors) {
//             cloneNode.neighbors.add(map.get(one.val));
//             addNeighbours(one, map, visited);
//         }
//     }
}