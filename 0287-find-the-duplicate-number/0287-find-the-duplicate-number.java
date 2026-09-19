class Solution {
    public int findDuplicate(int[] nums) {
      int arr[] = new int[nums.length+1];
      for(int i:nums){
        arr[i]++;
      }
      for(int i:nums){
        if(arr[i]>=2){
            return i;
        }
      }
      return -1;
    }
}
