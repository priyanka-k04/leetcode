class Solution {
    public int[] twoSum(int[] nums, int target) {
          HashMap<Integer, Integer> map = new HashMap<>();
        // number → index

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // if required number already exists
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // store current number
            map.put(nums[i], i);
        }

        return new int[] {}; 
    }
}