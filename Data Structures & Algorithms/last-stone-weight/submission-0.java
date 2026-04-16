class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int weight: stones) {
            pq.add(weight);
        }

        while(pq.size() > 1) {
            int w1 = pq.poll();
            int w2 = pq.poll();

            int diff = Math.abs(w1 - w2);

            if(diff != 0) {
                pq.add(diff);
            }

        }

        return pq.size() == 1 ? pq.peek() : 0;
    }
}
