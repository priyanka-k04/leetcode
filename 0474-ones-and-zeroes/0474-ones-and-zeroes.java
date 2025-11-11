class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][m][n] = max number of strings we can form from i to end
        // using at most m zeros and n ones
        Integer[][][] dp = new Integer[strs.length + 1][m + 1][n + 1];
        return helper(strs, m, n, 0, dp);
    }

    private int helper(String[] strs, int m, int n, int i, Integer[][][] dp) {
        // Base condition: no more strings to process
        if (i == strs.length) {
            return 0;
        }

        // If already computed
        if (dp[i][m][n] != null) {
            return dp[i][m][n];
        }

        // Option 1: don't take current string
        int notPick = helper(strs, m, n, i + 1, dp);

        // Count zeros and ones in current string
        int zeros = 0, ones = 0;
        for (char c : strs[i].toCharArray()) {
            if (c == '0') zeros++;
            else ones++;
        }

        // Option 2: take current string if possible
        int pick = 0;
        if (m >= zeros && n >= ones) {
            pick = 1 + helper(strs, m - zeros, n - ones, i + 1, dp);
        }

        // Take max of picking or not picking
        int result = Math.max(pick, notPick);

        dp[i][m][n] = result;  // memoize result
        return result;
    }
}
