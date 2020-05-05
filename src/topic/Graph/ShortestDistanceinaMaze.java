/*===============================================Shortest Distance in a Maze
Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls. 
1 represents a wall in a matrix and 0 represents an empty location in a wall. There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops,
 it could choose the next direction. Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.=======*/
 public class Solution {
    public int solve(int[][] A, int[] start, int[] end) {
        int[][] distance = new int[A.length][A[0].length];
        for(int[] row:distance)
            Arrays.fill(row,Integer.MAX_VALUE);
        
        distance[start[0]][start[1]] = 0;
        dfs(A,start,distance);
        return distance[end[0]][end[1]] == Integer.MAX_VALUE ? -1 :distance[end[0]][end[1]];
    
    }
    public void dfs(int[][] A, int[] start,int[][] distance) {
        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
        for(int[] dir:dirs){
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int cnt = 0;
            while(x >= 0 && y >= 0 && x < A.length && y<A[0].length && A[x][y] ==0){
                x += dir[0];
                y += dir[1];
                cnt++;
            }
            if(distance[start[0]][start[1]] + cnt < distance[x-dir[0]][y-dir[1]]){
                distance[x-dir[0]][y-dir[1]] = distance[start[0]][start[1]] + cnt;
                dfs(A,new int[] {x-dir[0],y-dir[1]},distance);
            }
        }
    }
}
