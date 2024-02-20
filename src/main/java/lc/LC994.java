package lc;

import java.util.LinkedList;

/**
 * 2024/1/23
 * lamic
 **/
public class LC994 {
    public int orangesRotting(int[][] grid) {
        int min = 0;
        int good = 0;
        int m = grid.length;
        int n = grid[m-1].length;
        LinkedList<int[]> broken = new LinkedList();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    good++;
                }else if(grid[i][j] == 2){
                    broken.offer(new int[]{i,j});
                }
            }
        }
        //这里面是所有坏掉的橘子，每一轮poll一个出来，能一次感染他的i+1/j+1/i-1/j-1；感染完这4个则step++
        //如果这四个已经被感染过了，则step保持不变
        //直到所有的坏句子都检查一遍没有没有课感染的
        //最后检查好的橘子的数量
        while(!broken.isEmpty()){
            int[] coor = broken.poll();
            boolean needStep = false;
            if(coor[0]<m-1 && grid[coor[0]+1][coor[1]] == 1){
                good--;
                grid[coor[0]+1][coor[1]] = 2;
                broken.offer(new int[]{coor[0]+1,coor[1]});
                needStep = true;
            }
            if(coor[0]>0 && grid[coor[0]-1][coor[1]] == 1){
                good--;
                grid[coor[0]-1][coor[1]] = 2;
                broken.offer(new int[]{coor[0]-1,coor[1]});
                needStep = true;
            }
            if(coor[1]<n-1 && grid[coor[0]][coor[1]+1] == 1){
                good--;
                grid[coor[0]][coor[1]+1] = 2;
                broken.offer(new int[]{coor[0],coor[1]+1});
                needStep = true;
            }
            if(coor[1]>0 && grid[coor[0]][coor[1]-1] == 1){
                good--;
                grid[coor[0]][coor[1]-1] = 2;
                broken.offer(new int[]{coor[0],coor[1]-1});
                needStep = true;
            }

            if(needStep){
                min++;
            }
        }
        return good<=0?min:-1;
    }

    public static void main(String[] args) {
        LC994 lc = new LC994();
        System.out.println(lc.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
