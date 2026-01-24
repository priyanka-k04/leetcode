class Solution {

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int operations = 0;

        while (!isSorted(nums, n)) {
            int minIndex = 0;
            int minSum = Integer.MAX_VALUE;

            // find adjacent pair with minimum sum
            for (int i = 0; i < n - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    minIndex = i;
                }
            }

            // merge the pair
            nums[minIndex] = nums[minIndex] + nums[minIndex + 1];

            // shift elements left
            for (int i = minIndex + 1; i < n - 1; i++) {
                nums[i] = nums[i + 1];
            }

            n--;
            operations++;
        }
        return operations;
    }

    private boolean isSorted(int[] nums, int n) {
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
