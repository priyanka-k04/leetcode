
        class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        int gcd = nums[0];

        // Find GCD of entire array and count numbers already equal to 1
        for (int i = 0; i < n; i++) {
            gcd = gcd(gcd, nums[i]);
            if (nums[i] == 1) {
                count++;
            }
        }

        // If total GCD > 1, it’s impossible to make all elements 1
        if (gcd != 1) {
            return -1;
        }

        // If there’s already at least one '1', we just need to make others 1
        if (count > 0) {
            return n - count;
        }

        // Otherwise, find the minimum subarray whose GCD becomes 1
        int mini = (int) 1e9;
        for (int i = 0; i < n; i++) {
            int currentGcd = nums[i];
            for (int j = i + 1; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    mini = Math.min(mini, j - i + 1);
                    break;
                }
            }
        }

        // Return the total minimum operations
        return (n - 1) + (mini - 1);
    }

    // Helper GCD function (Euclidean algorithm)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

    
