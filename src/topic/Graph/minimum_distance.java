//====================================minimum distance of 1 from each cell in 2d matrix======================
public class Solution {
    public int[][] solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int ans[][] = new int[N][M]; 
      
        // Initialize the answer matrix with INT_MAX. 
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < M; j++) 
                ans[i][j] = Integer.MAX_VALUE; 
      
        // For each cell 
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < M; j++) 
            { 
                // Traversing the whole matrix 
                // to find the minimum distance. 
                for (int k = 0; k < N; k++) 
                    for (int l = 0; l < M; l++) 
                    { 
                        // If cell contain 1, check 
                        // for minimum distance. 
                        if (A[k][l] == 1) 
                            ans[i][j] = 
                              Math.min(ans[i][j], 
                                   Math.abs(i-k) 
                                   + Math.abs(j-l)); 
                    } 
            }
            return ans;
    }
}
