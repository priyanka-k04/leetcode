class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxEl = Arrays.stream(nums).max().getAsInt() + k;

        int[] freq = new int[maxEl + 1];

        // frequency count
        for (int num : nums) {
            freq[num]++;
        }

        // cumulative sum of freq nikal lo
        for (int i = 1; i <= maxEl; i++) {
            freq[i] += freq[i - 1];
        }

        int result = 0;

        for (int target = 0; target <= maxEl; target++) {
            if (freq[target] == 0)
                continue;

            int leftNum = target - k; // left boundary
            int rightNum = target + k; // right boundary

           int totalCount = freq[Math.min(rightNum, maxEl)] - (leftNum > 0 ? freq[leftNum - 1] : 0);


            int targetCount = freq[target] - (target > 0 ? freq[target - 1] : 0);
            int needConversion = totalCount - targetCount;

            int maxPossibleFreq = targetCount + Math.min(needConversion, numOperations);

            result = Math.max(result, maxPossibleFreq);
        }

        return result;
        
    }
}