class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 1,1,1
        // 1,2,3
        // 1,0,3

        if(obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[] arr = new int[cols];
        int ways = 1;

        for(int i = 0; i < cols; i++) {

            // obstacle case
            if(obstacleGrid[0][i] == 1) {
                ways = 0;
            }
            arr[i] = ways;
        }

        ways = 1;

        for(int i = 1; i < rows; i++) {

            // obstacle case
            if(obstacleGrid[i][0] == 1) {
                ways = 0;
            }
            arr[0] = ways;

            for(int j = 1; j < cols; j++) {

                // obstacle case
                if(obstacleGrid[i][j] == 1) {
                    arr[j] = 0;
                }
                else {
                    arr[j] += arr[j-1];
                }

            }
        }
        return arr[cols-1];
    }
}