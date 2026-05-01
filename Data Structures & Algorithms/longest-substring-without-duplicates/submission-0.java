class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int l = 0;
        int len = 0;

        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if(!set.contains(c)) {
                set.add(c);
                len = Math.max(len, r-l+1);
                continue;
            }

            char lc = s.charAt(l);

            while(lc != c) {
                set.remove(lc);
                l++;
                lc = s.charAt(l);
            }

            l++;
        }

        return len;
    }
}
