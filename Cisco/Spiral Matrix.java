/*
Approach
1.Track Directions: Use a directions array to move right → down → left → up in a loop.
2.Track Visited: Use a visited[][] matrix to avoid revisiting cells.
3.Traverse: Start from (0, 0), move in the current direction.
4.Turn: If the next cell is out of bounds or already visited, turn right (rotate direction).
5.Repeat for all rows × cols elements.

Leetcode Link-
https://leetcode.com/problems/spiral-matrix/description/
*/
//JAVA Code
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        boolean[][] visited=new boolean[row][col];
        List<Integer> res=new ArrayList<>();
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        int dir=0,x=0,y=0;
        for(int i=0;i<row*col;i++){
        res.add(matrix[x][y]);
        visited[x][y]=true;
        int nextX=x+directions[dir][0];
        int nextY=y+directions[dir][1];
        if(nextX<0 || nextX>=row || nextY<0 || nextY>=col || visited[nextX][nextY]){
            dir=(dir+1)%4;
            nextX=x+directions[dir][0];
            nextY=y+directions[dir][1];
        }
        x=nextX;
        y=nextY;
        }
        return res;
    }
}
