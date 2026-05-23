class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            char[] arr = s.toCharArray();

            Arrays.sort(arr);

            String key = String.valueOf(arr);

            List<String> anagrams = map.computeIfAbsent(key, k -> new ArrayList<>());
            anagrams.add(s);
        }

        List<List<String>> res = new ArrayList<>(map.values());

        return res;
    }
}
