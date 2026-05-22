class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for(int n: nums) {
            int count = countMap.getOrDefault(n, 0);
            countMap.put(n, count+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        countMap.forEach((key, v) -> {
            pq.offer(new int[]{key, v});

            if(pq.size() > k) {
                pq.poll();
            }
        });

        int[] res = new int[k];

        int i = 0;
        while(!pq.isEmpty()) {
            res[i++] = pq.poll()[0];
        }

        return res;
        
    }
}
