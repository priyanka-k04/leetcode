class Solution {
    public int minCost(String colors, int[] neededTime) {
        int prev=neededTime[0];
        int res=0;
        for(int i = 1; i < colors.length(); i++){
           if (colors.charAt(i)==colors.charAt(i-1)){
            res+=Math.min(prev,neededTime[i]);
            prev=Math.max(neededTime[i],0);
           }
           else prev=neededTime[i];
        }
        return res;
        
    }
}