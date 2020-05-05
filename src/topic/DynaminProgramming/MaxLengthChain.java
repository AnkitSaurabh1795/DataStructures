/*You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Your task is to complete the function maxChainLen which returns an integer denoting the longest chain which can be formed from a given set of pairs.*/
int maxChainLength(Pair arr[], int n)
    {
       // dp solution
      /*int[] dp = new int[n];
      for(int i = 0; i<n; i++)
        dp[i] = 1;
        
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=i; j++){
                if(arr[i].x > arr[j].y && dp[i] <= dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }
        int max = 0;
        for(int i =0; i<n; i++)
            if(dp[i] > max)
                max = dp[i];
                
        return max;*/
        //greedy solution
     Arrays.sort(arr, (a, b) -> (a.x - b.x));
        int last = Integer.MIN_VALUE;
        int count =0;

        for(Pair pair : arr){
            if( last < pair.x){
                    last = pair.y;
                    count++;
            }
        }
    
        return count;
    }
