// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> output = new LinkedList<>();

        for(int i = 0; i < pairs.size(); i++) {
            int j = i;
            
            while(j > 0) {
                if (pairs.get(j).key >= pairs.get(j-1).key) {
                    break;
                }
                swap(pairs, j, j-1);
                j--;
            }

            output.add(new LinkedList<>(pairs));
        }

        return output;

    }

    private void swap(List<Pair> pairs, int i, int j) {
        Pair temp = pairs.get(i);
        pairs.set(i, pairs.get(j));
        pairs.set(j, temp);
    }
}
