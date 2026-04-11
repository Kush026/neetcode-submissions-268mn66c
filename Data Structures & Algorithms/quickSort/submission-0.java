// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {

        if(pairs == null || pairs.isEmpty()) {
            return pairs;
        }

        quickSort(pairs, 0, pairs.size()-1);

        return pairs;
    }

    private void quickSort(List<Pair> pairs, int s, int e) {

        if (s >= e) {
            return;
        }

        Pair pivot = pairs.get(e);

        int cur = s;

        for(int i = s; i < e; i++) {

            if (pairs.get(i).key < pivot.key) {

                Pair temp = pairs.get(i);
                pairs.set(i, pairs.get(cur));
                pairs.set(cur, temp);
                cur++;
            }
        }

        pairs.set(e, pairs.get(cur));
        pairs.set(cur, pivot);

        quickSort(pairs, s, cur-1);
        quickSort(pairs, cur+1, e);
    }


}
