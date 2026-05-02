class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> countMap = new HashMap<>();

        int l = 0, maxCount = 0, out = 0;

        for(int r = 0; r < s.length(); r++) {
            int winL = r - l + 1;
            char c = s.charAt(r);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);

            maxCount = Math.max(maxCount, countMap.get(c));

            while((r - l + 1) -  maxCount > k) {
                char lc = s.charAt(l);
                countMap.put(lc, countMap.get(lc) - 1);
                l++;
            }

            out = Math.max(out, r - l + 1);
        }

        return out;
        
    }
}
