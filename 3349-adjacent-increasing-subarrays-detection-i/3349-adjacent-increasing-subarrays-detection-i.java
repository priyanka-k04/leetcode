

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int cl = 1;   // current length of increasing subarray
        int pl = 0;   // previous increasing length
        int result = 0; // store max of valid subarray pair length

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cl += 1; // increasing, extend current length
            } else {
                pl = cl; // store previous length
                cl = 1;  // reset current length
            }

            // Update result based on both lengths
            result = Math.max(result, Math.max(cl / 2, Math.min(cl, pl)));
        }

        return result >= k;
    }
}
