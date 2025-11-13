class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int cand1=0, cand2=0;
        int vote1=0, vote2=0;
        for(int num:nums){
            if(vote1>0 && num==cand1){
                vote1++;
            }else if(vote2> 0 && num==cand2){
                vote2++;
            }else if(vote1==0){
                cand1=num;
                vote1=1;
            }else if(vote2==0){
                cand2=num;
                vote2=1;
            }else{
                vote1--;
                vote2--;
            }
        }
        int freq1=0, freq2=0;
        for(int num:nums){
            if(num==cand1) freq1++;
            else if(num==cand2) freq2++;
        }

        List<Integer> result=new ArrayList<>();
        if(freq1 > n/3) result.add(cand1);
        if(freq2 > n/3) result.add(cand2);

        return result;
        
    }
}