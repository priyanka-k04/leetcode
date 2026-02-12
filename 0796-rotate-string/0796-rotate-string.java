class Solution {
    public boolean rotateString(String s, String goal) {
        String doubled=s+s;
        return doubled.contains(goal);
    }
}