class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0){
            return 0;
        }
        if(k>= prices.length/2){
             int profit=0;
             int valley = prices[0];
             int peak = prices[0];
             int i=0;

             while(i<prices.length-1){
                 while(i<prices.length-1  && prices[i]>=prices[i+1]){
                   i++;
                }
            valley=prices[i];
            while(i<prices.length-1  && prices[i]<=prices[i+1]){
                i++;
             }
            peak=prices[i];
            profit+= peak-valley;
          
        }
        return profit;
        }
        int[][] dp = new int[k+1][prices.length];
        int tempMax = 0;
        for(int j=1;j<=k;j++){
            tempMax=dp[j-1][0]-prices[0];
            for(int i=1;i<=prices.length-1;i++){
                dp[j][i]=Math.max(dp[j][i-1],tempMax+prices[i]);
                tempMax = Math.max(tempMax, dp[j-1][i]-prices[i]);
                
            }
        }
       return dp[k][prices.length-1]; 
    }
}
