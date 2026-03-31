// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        mergeSort(pairs, 0, pairs.size()-1);
        return pairs;
    }

    private void mergeSort(List<Pair> pairs, int start, int end) {
        if(end <= start) return;

        int mid = start + (end - start)/2;

        mergeSort(pairs, start, mid);
        mergeSort(pairs, mid+1, end);

        merge(pairs, start, mid, end);
    }

    private void merge(List<Pair> pairs, int start, int mid, int end) {
        int size = end-start+1;
        Pair[] temp = new Pair[size];

        int sptr = start;
        int ptr = mid+1;
        int i = 0;

        while(sptr <= mid && ptr <= end) {
            if(pairs.get(sptr).key <= pairs.get(ptr).key) {
                temp[i++] = pairs.get(sptr++);
            }
            else {
                temp[i++] = pairs.get(ptr++);
            }
        }

        while(sptr <= mid) {
            temp[i++] = pairs.get(sptr++);
        }

        while(ptr <= end) {
            temp[i++] = pairs.get(ptr++);
        }

        for (int j = start; j <= end; j++) {
            pairs.set(j, temp[j-start]);
        }
    }
}
