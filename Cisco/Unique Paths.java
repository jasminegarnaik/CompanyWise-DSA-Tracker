/* 
Approach
Goal: Count the number of unique paths from the top-left (0, 0) to bottom-right (m-1, n-1) in a grid, moving only right or down.
1.Recursive Function f(i, j):
   *Represents the number of ways to reach cell (i, j) from (0, 0).
2.Base Cases:
   *f(0, 0) = 1 → Start point.
   *If i < 0 || j < 0, return 0 → Invalid cell.
3.Recursive Relation:
   *f(i, j) = f(i-1, j) + f(i, j-1)
(Paths from the top and left)
4.Memoization:
   *Use a 2D dp array to cache results and avoid recomputation.

   Leetcode Link:
   https://leetcode.com/problems/unique-paths/
*/
//JAVA Code
class Solution {
    static int f(int i,int j,int[][] dp){
        if(i==0 && j==0){
            return 1;
        }
        else if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
      int up=f(i-1,j,dp);
      int left=f(i,j-1,dp);
      return dp[i][j]=up+left;
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
       return f(m-1,n-1,dp); 
    }
}
