class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int gola_index=-1;
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                gola_index=i-1;
                break;
            }
        }
        if(gola_index!=-1){
            int swap_index=-1;
            for(int j=n-1;j>gola_index;j--){
                if(nums[j]>nums[gola_index])
                {
                    swap_index=j;
                    break;
                }
            }
        swap(nums,gola_index,swap_index);
        }
    reverse(nums,gola_index+1,n-1);
        
    }
    private void swap(int[] nums, int i,int j){
        nums[i]=(nums[i]+nums[j])-(nums[j]=nums[i]);
    }
    private void reverse(int[] nums, int left, int right){
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}