class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int size = matrix.length * matrix[0].length; // 12

        return search(matrix, target, 0, size-1); // 0, 11
    }

    /**

    i,j

    k = i * cols + j

    rows * cols = size


    i = k/rows

    i = k / cols;

    j = k % cols;

    3 = 1*3+0

    0, 1, 2
    3, 4, 5



    **/

    private boolean search(int[][] matrix, int target, int s, int e) {
        if (s > e) {
            return false;
        }

        int mid = s + (e - s)/2; // 2

        int rows = matrix.length; // 3
        int cols = matrix[0].length; // 4

        int i = mid / cols; // 0
        int j = mid % cols; // 0

        int val = matrix[i][j]; // 1

        if (target == val) {
            return true;
        }
        else if (target < val) {
            return search(matrix, target, s, mid-1); // 0, 4
        }
        else {
            return search(matrix, target, mid+1, e);
        }

    }
}
