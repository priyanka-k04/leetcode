class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=nums[0];
        int currmax=nums[0];
        int maxsum=nums[0];
        int currmin=nums[0];
        int minsum=nums[0];
        for(int i=1;i<nums.length;i++){
            total+=nums[i];
            currmin=Math.min(currmin+nums[i],nums[i]);
            minsum=Math.min(minsum,currmin);
            currmax=Math.max(currmax+nums[i],nums[i]);
            maxsum=Math.max(maxsum,currmax);
        }
        if(maxsum<0){
            return maxsum;
        }
        int circularsum=total-minsum;
        return Math.max(maxsum,circularsum);
        
    }
}
