class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> mapPS=new HashMap<>();
        HashMap<String, Character> mapSP=new HashMap<>();
        String [] arr=s.split(" ");
        if(arr.length!= pattern.length()) return false;
        for(int i=0;i<arr.length;i++){
            char ch=pattern.charAt(i);
            String word=arr[i];
            if(mapPS.containsKey(ch)){
                if(!mapPS.get(ch).equals(word)) return false;
            }else{
                mapPS.put(ch,word);
            }
            if(mapSP.containsKey(word)){
                if(mapSP.get(word)!=ch) return false;
            }else{
                mapSP.put(word,ch);
            }
        }
        return true;
    }
}