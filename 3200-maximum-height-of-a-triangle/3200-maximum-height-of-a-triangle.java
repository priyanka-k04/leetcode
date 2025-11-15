class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        int startred=build(red,blue);
        int startblue=build(blue,red);
        return Math.max(startred, startblue);
    }
    private int build(int firstcolor, int secondcolor){
        int totalrow=0;
        int neededcolor=1;
        boolean usingc=true;

        while(firstcolor>=neededcolor || secondcolor>=neededcolor){
            if(usingc){
                if(firstcolor<neededcolor) break;
                firstcolor-=neededcolor;
            }else{
                if(secondcolor<neededcolor) break;
                secondcolor-=neededcolor;
            }
            totalrow++;
            neededcolor++;
            usingc=!usingc;
        }
        return totalrow;
    }
}
