class PrefixTree {

    private Node root = new Node();

    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord;

        public Node(boolean isWord) {
            this.isWord = isWord;
        }

        public Node() {
            this.isWord = false;
        }
    }

    public PrefixTree() {
         
    }

    public void insert(String word) {

        Node cur = root;

        for(char c: word.toCharArray()) {

            Node temp = cur.children.computeIfAbsent(c, k -> new Node());
            cur = temp;
        }

        cur.isWord = true;
    }

    public boolean search(String word) {

        Node cur = root;

        for(char c: word.toCharArray()) {

            cur = cur.children.get(c);

            if(cur == null) {
                return false;
            }
        }

        return cur.isWord;

    }

    public boolean startsWith(String prefix) {

        Node cur = root;

        for(char c: prefix.toCharArray()) {

            cur = cur.children.get(c);

            if(cur == null) {
                return false;
            }
        }

        return true;

    }
}
