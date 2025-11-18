class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxEnding = nums[0], maxSoFar = nums[0];
        int minEnding = nums[0], minSoFar = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            total += x;

            // Kadane for max subarray
            if (i == 0) { // already initialized above
                maxEnding = maxSoFar = x;
                minEnding = minSoFar = x;
                continue;
            }
            maxEnding = Math.max(x, maxEnding + x);
            maxSoFar = Math.max(maxSoFar, maxEnding);

            // Kadane for min subarray (similar but for minimum)
            minEnding = Math.min(x, minEnding + x);
            minSoFar = Math.min(minSoFar, minEnding);
        }

        // If all numbers are negative, maxSoFar == total (because minSoFar == total)
        if (maxSoFar < 0) {
            return maxSoFar;
        }

        // Otherwise, max of non-wrapping (maxSoFar) and wrapping (total - minSoFar)
        return Math.max(maxSoFar, total - minSoFar);
    }
}
