/*
Approach:
Goal: Count unique paths from top-left to bottom-right in a grid with obstacles (1 = obstacle).

Recursive DP:

Define f(i, j) as the number of paths to cell (i, j) from (0, 0).

Base Cases:

Return 0 if cell is an obstacle.

Return 1 if at (0, 0) and not blocked.

Return 0 if out of bounds.

Recurrence:

f(i, j) = f(i-1, j) + f(i, j-1) (from top and left)

Memoization:

Store results in dp[i][j] to avoid recomputation.
*/
//JAVA Code
class Solution {
    static int f(int i,int j,int[][] obstacleGrid,int[][] dp){
        if(i>=0 && j>=0 && obstacleGrid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=f(i-1,j,obstacleGrid,dp);
        int down=f(i,j-1,obstacleGrid,dp);
        return dp[i][j]=up+down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,obstacleGrid,dp);
    }
}
