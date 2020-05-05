/*=======================================================Interleaved Strings======================================*/
class Solution {
    public boolean isInterLeave(String s1,String s2,String s3)
	{
	    int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                dp[i][j] = -1;
            }
        }
        return solve(s1, s2, s3, dp);
	}
	public boolean solve(String a,String b,String c,int[][] dp)
	{
            //Your code here
            int nc = c.length();
            int nb = b.length();
            int na = a.length();
            if(nc == 0)
            return na == 0 && nb == 0;
			if(dp[na][nb] != -1)
                return dp[na][nb] == 0 ? false:true;
            boolean ans1 = false;
            boolean ans2 = false;
            if(na != 0 && a.charAt(0) == c.charAt(0))
               ans1 = solve(a.substring(1),b,c.substring(1),dp);
            if(nb != 0 && b.charAt(0) == c.charAt(0) )
                ans2 = solve(a,b.substring(1),c.substring(1),dp);
            dp[na][nb] = ans1 || ans2 ? 1:0;
            return ans1 || ans2;
	}
}
