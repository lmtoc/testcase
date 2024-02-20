package lc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2023/12/14
 * lamic
 **/
public class LC452 {


    //这道题可以转换为，选取选取重叠最大的区间范围intervals集合，使得所有point[]都在里面
    public static int findMinArrowShots(int[][] points) {
        int length = points.length;
        if(length <=1){
            return length;
        }
        int [][] resultInterval = new int[length][2];
        Arrays.sort(points, Comparator.comparingInt(v -> v[0]));

        resultInterval[0] = points[0];
        int resultIntervalIndex = 0;
        for(int i = 1;i<length;i++){
            if(points[i][0] > resultInterval[resultIntervalIndex][1]){
                resultInterval[++resultIntervalIndex] = points[i];
            }else{
                resultInterval[resultIntervalIndex][0] = Math.max(resultInterval[resultIntervalIndex][0],points[i][0]);
                resultInterval[resultIntervalIndex][1] = Math.min(resultInterval[resultIntervalIndex][1],points[i][1]);
            }
        }
        return resultIntervalIndex+1;

    }


    public static void  main(String [] args){
        String[] result = "///home//ho/".split("/");
        System.out.println(findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
    }
}
