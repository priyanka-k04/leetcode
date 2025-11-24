class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> ps=new HashMap<>();        
        HashMap<String, Character> sp=new HashMap<>();
        String[] arr=s.split(" ");
        if(pattern.length() != arr.length) return false;

        for(int i=0;i<arr.length;i++){
            char ch=pattern.charAt(i);
            String word=arr[i];
            if(ps.containsKey(ch)){
                if(!ps.get(ch).equals(word)) return false;
            }else{
                ps.put(ch,word);
            }
            if(sp.containsKey(word)){
                if(sp.get(word)!=ch) return false;
            }else{
                sp.put(word,ch);
            }

        }
        return true;       
    }
}