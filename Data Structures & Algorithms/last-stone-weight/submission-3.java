class Solution {
    public int lastStoneWeight(int[] stones) {

        int[] bucket = new int[101];

        // 2 -> 3, 3 -> 1
        // 2 -> 3, // 2 -> 2


        int size = stones.length; // 5

        for(int w: stones) {
            bucket[w]++;
        }

        int ptr = 100;

        while(size > 1) {
            
            if(bucket[ptr] % 2 == 0) {
                size -= bucket[ptr];
                ptr--;
            }
            else if (bucket[ptr] == 1) {

                int j = ptr-1;
                while(bucket[j] == 0) {
                    j--;
                }

                bucket[ptr - j]++;
                bucket[j]--;
                size--;
                ptr--;
            }
            else {
                size -= (bucket[ptr]-1);
                bucket[ptr] = 1;
            }
        }

        int res = 0;

        while(ptr >= 1) {

            if(bucket[ptr] != 0) {
                res = ptr;
                break;
            }
            ptr--;
        }

        return res; 
        
    }
}
