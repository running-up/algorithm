public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minmum = prices[0];
        for(int i = 1 ; i < prices.length ; i++){
            if(minmum > prices[i]){
                minmum = prices[i];
            }else {
                if(prices[i] - minmum > max) {
                    max = prices[i] - minmum;
                }
            }
        }
        return max;
    }
}
