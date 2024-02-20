package lc;

import java.util.Arrays;

/**
 * 2023/12/11
 * lamic
 **/
public class LC73 {

    public void setZeroes(int[][] matrix) {
        //常数级别空间消耗思路：用矩阵首航/首列记录该行/该列是否需要置0，如果置0则整行/整列置0
        //但是这样会丢失 首行/首列的置0情况，所以我们用两个变量分别记录 首行/首列是否需要置0
        boolean rowZero = false;
        boolean columnZero = false;
        for(int i = 0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                columnZero = true;
                break;
            }
        }

        for(int j = 0;j<matrix[0].length;j++){
            if(matrix[0][j] == 0){
                rowZero = true;
                break;
            }
        }

        for(int i = 1;i<matrix.length;i++){
            for(int j = 1;j<matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }


        for(int i = 1;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                Arrays.fill(matrix[i],0);
            }
        }


        for(int j = 1;j<matrix[0].length;j++){
            if(matrix[0][j] == 0){
                for(int i = 0;i<matrix.length;i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(rowZero){
            Arrays.fill(matrix[0],0);
        }
        if(columnZero){
            Arrays.fill(matrix[0], 0);
        }
    }
}
