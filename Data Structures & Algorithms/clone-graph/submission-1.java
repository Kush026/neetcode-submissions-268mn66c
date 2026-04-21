/*
Definition for a Node.
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

        if(node == null) {
            return null;
        }

        Map<Integer, Node> nMap = new HashMap<>();

        Deque<Node> deck = new ArrayDeque<>();
        deck.offer(node);

        while(!deck.isEmpty()) {
            Node polled = deck.poll();

            Node cloned;

            if(!nMap.containsKey(polled.val)) {
                nMap.put(polled.val, new Node(polled.val));
            }

            cloned = nMap.get(polled.val);
            ArrayList<Node> children = new ArrayList<>();

            for(Node child: polled.neighbors) {

                if(!nMap.containsKey(child.val)) {
                    deck.offer(child);
                    nMap.put(child.val, new Node(child.val));
                }
                
                Node nChild = nMap.get(child.val);
                children.add(nChild);
            }

            cloned.neighbors = children;
        }

        return nMap.get(node.val);
    }
}