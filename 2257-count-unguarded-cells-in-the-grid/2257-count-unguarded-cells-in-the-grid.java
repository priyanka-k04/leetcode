class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
       int[][] grid= new int[m][n];
       for(int[] wall:walls) grid[wall[0]][wall[1]]=1;
       for(int[] guard:guards) grid[guard[0]][guard[1]]=2;
       int [][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
       for(int[] guard:guards){
        for(int[]dir:dirs){
            dfs(grid,dir,guard[0]+dir[0],guard[1]+dir[1]);
        }
       }
       int count=0;
       for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
        if(grid[i][j]==0) count++;
        return count;

    }
    private void dfs(int[][] grid,int[] dir,int r,int c){
        int m=grid.length, n=grid[0].length;
        if(r<0||r>=m||c<0||c>=n||grid[r][c]==1||grid[r][c]==2) return;
        if(grid[r][c]==0) grid[r][c]=3;
        dfs(grid,dir,r+dir[0],c+dir[1]);
    }
}