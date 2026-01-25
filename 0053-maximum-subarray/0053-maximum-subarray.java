class Solution {
    public int maxSubArray(int[] nums) {
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;// cant use maxsum=0 because of the case when nums=[-1] its giving answer 0 which is wrong
        /*why? - currsum = -1
                 maxsum = max(-1, 0) = 0
                 return 0 ❌ (wrong)*/
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