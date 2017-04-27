public class MaxProfitII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // greedy approach, if the profit drops, sell immediately
        int profit = 0;
        int min = prices[0];
        int oneSell = 0;
        for (int price : prices) {
            if (oneSell < price - min) {
                oneSell = price - min;
            } else {
                min = price;
                profit += oneSell;
                oneSell = 0;
            }
        }
        return profit + oneSell;
    }
}
