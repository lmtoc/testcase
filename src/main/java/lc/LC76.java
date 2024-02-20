package lc;

/**
 * 2024/1/4
 * lamic
 **/
public class LC76 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while(i>=0 && i< matrix.length && j>=0 && j< matrix[0].length){
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] < target){
                j--;
            }else if(matrix[i][j] > target){
                i++;
            }
        }
        return false;

    }

    public static void main(String[] args){
        LC76 lc = new LC76();
        System.out.println(lc.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,17}},3));
    }
}
