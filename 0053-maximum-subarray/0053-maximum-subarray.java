class Solution {
    public int maxSubArray(int[] nums) {
        int currsum=0;
        int maxsum=0;
        for(int i:nums){
            currsum+=i;
            maxsum=Math.max(currsum, maxsum);

            if(currsum<0){
                currsum=0;
            }
        }
        return maxsum;
        
    }
}