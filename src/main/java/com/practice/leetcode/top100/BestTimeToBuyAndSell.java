package com.practice.leetcode.top100;

// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the
// stock at any time. However, you can buy it then immediately sell it on the same day.

// Find and return the maximum profit you can achieve.

public class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {5, 4, 3, 2, 1};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maximumProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] <= prices[i+1])
                maximumProfit += prices[i+1] - prices[i];
        }

        return maximumProfit;
    }
}
