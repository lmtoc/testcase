package lcr;

/**
 * 2024/1/29
 * lamic
 **/
public class LCR013 {
    //记录以(i,j)为右下角对应的和
    int[][] sum = null;
    public LCR013(int[][] matrix) {
        int n = matrix[matrix.length-1].length;
        sum = new int[matrix.length][n];
        sum[0][0] = matrix[0][0];
        //先单独计算每一行的横向前缀和
//        for(int i = 1;i<matrix.length;i++){
//            sum[i][0] = sum[i-1][0]+matrix[i][0];
//        }
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<n;j++){
                if(j == 0){
                    sum[i][j] = matrix[i][j];
                }else{
                    sum[i][j] = sum[i][j-1]+matrix[i][j];
                }
            }
        }
        //再计算纵向和
        for(int i = 1;i<matrix.length;i++){
            for(int j = 0;j<n;j++){
                sum[i][j] = sum[i-1][j]+sum[i][j];
            }
        }

    }
    //计算(row2,col2)的和-(row1-1,col2)-(row2,col1-1)+(row1-1,col1-1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sumTotal = sum[row2][col2];
        int minusCnt = 0;
        if(row1>0){
            minusCnt++;
            sumTotal = sumTotal - sum[row1-1][col2];
        }
        if(col1>0){
            minusCnt++;
            sumTotal = sumTotal-sum[row2][col1-1];
        }
        if(minusCnt == 2){
            sumTotal+=sum[row1-1][col1-1];
        }
        return sumTotal;
    }


    public static void main(String[] args) {
        LCR013 lc = new LCR013(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        System.out.println(lc.sumRegion(2,1,4,3));
        System.out.println(lc.sumRegion(1,1,2,2));
    }
}
