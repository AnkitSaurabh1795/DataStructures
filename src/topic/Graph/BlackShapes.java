/*======================================Black Shapes
Given N x M character matrix A of O's and X's, where O = white, X = black.
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)=======================*/
public class Solution {
    void dfs(String[] A,int i,int j,boolean[][] visit,int r,int c){
        if(i < 0 || i > r-1)
            return;
        if(j <0|| j>c-1)
            return;
        if(A[i].charAt(j) =='O' || visit[i][j]==true)
            return;
        visit[i][j] = true;
        dfs(A,i+1,j,visit,r,c);
        dfs(A,i-1,j,visit,r,c);
        dfs(A,i,j+1,visit,r,c);
        dfs(A,i,j-1,visit,r,c);
    }
    public int black(String[] A) {
        int n = A.length;
        int m = A[0].length();
        boolean[][] visit = new boolean[n][m];
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0;j<m; j++){
                if(A[i].charAt(j) == 'X' && !visit[i][j]){
                    dfs(A,i,j,visit,n,m);
                    cnt += 1;
                }
                    
            }
        }
        return cnt;
    }
}
