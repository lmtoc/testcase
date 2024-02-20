package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 2023/12/10
 * lamic
 **/
public class LC54 {


    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int right = matrix[0].length-1;
        int depth = matrix.length-1;
        int left = 0;
        int total = (right+1)*(depth+1);
        int i = 0;
        List<Integer> result = new ArrayList();
        while(i<total){
            for(int j = left;j<=right;j++){
                result.add(matrix[top][j]);
                i++;
            }
            top++;
            if(i>=total){
                break;
            }
            for(int j = top;j<=depth;j++){
                result.add(matrix[j][right]);
                i++;
            }
            if(i>=total){
                break;
            }
            right--;
            for(int j = right;j>=left;j--){
                result.add(matrix[depth][j]);
                i++;
            }
            depth--;
            if(i>=total){
                break;
            }

            for(int j = depth;j>=top;j--){
                i++;
                result.add(matrix[j][left]);
            }
            left++;

        }
        return result;
    }


    public static void main(String []args){
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
