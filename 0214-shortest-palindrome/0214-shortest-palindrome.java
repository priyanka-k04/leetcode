class Solution {
    public String shortestPalindrome(String s) {
        int n=s.length();
        String rev=new StringBuilder(s).reverse().toString();
        String combined=s+"#"+rev;

        int[] lps=new int[combined.length()];
        computelps(combined, lps);
        int lps1=lps[combined.length()-1];
        String toAdd = rev.substring(0, s.length() - lps1);

        return toAdd + s;
        
    }
    void computelps(String combined, int[] lps){
        int i=1;
        int len=0;
        lps[0]=0;
        while(i<combined.length()){
            if(combined.charAt(i)==combined.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{if(len!=0){
                len=lps[len-1];
                
            }else{
                lps[i]=0;
                i++;
            }
        }
    }
}
}