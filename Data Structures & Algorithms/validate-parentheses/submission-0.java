class Solution {
    private static final Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
    public boolean isValid(String s) {

        if (s == null || s.isEmpty()) {
            return true;
        }

        Deque<Character> stack = new LinkedList<Character>();

        for(char c: s.toCharArray()) {
            if(!map.containsKey(c)) {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char popped = stack.pop();

            if(popped != map.get(c)) {
                return false;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
        
    }
}
