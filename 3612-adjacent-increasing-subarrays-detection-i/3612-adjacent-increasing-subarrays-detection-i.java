class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n=nums.size();
        int curr=1;
        int prev=0;
        for(int i=1;i<n;i++){
            if(nums.get(i)>nums.get(i-1)){
                curr++;
            }else{
                prev=curr;
                curr=1;
            }
            if(curr>=2*k){
                return true;
            }
            if(Math.min(curr,prev)>=k){
                return true;
            }
        }
        return false;
    }
}