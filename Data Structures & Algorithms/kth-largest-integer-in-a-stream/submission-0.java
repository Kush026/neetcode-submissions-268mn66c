class KthLargest {

    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int k;


    public KthLargest(int k, int[] nums) {
        this.k = k;

        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        while(pq.size() > k) {
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);

        while(pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}
