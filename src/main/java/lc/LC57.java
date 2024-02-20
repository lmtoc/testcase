package lc;

import java.util.Arrays;

/**
 * 2023/12/13
 * lamic
 **/
public class LC57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        //合并分为三个区域 重叠区域前，重叠区域合并，重叠区域后合并
        int intervalLength = intervals.length;
        int [][]result = new int[intervalLength+1][2];

        if(intervalLength ==0){
            result[0] = newInterval;
            return result;
        }

        //非重叠区 将原数组直接赋值即可，同时记录非重叠区的最后index
        int intervalIndex = 0;
        while(intervalIndex < intervalLength && intervals[intervalIndex][1] < newInterval[0]){
            result[intervalIndex] = intervals[intervalIndex];
            intervalIndex++;

        }

        //如果重叠区域超出原数组长度，则直接赋值即可
        if(intervalIndex >= intervalLength){
            result[intervalIndex] = newInterval;
            return result;
        }

        //下面处理重叠区域，我们只需要得到一个重叠后的新的interval[]，直接加入结果集，之后再处理尾部的非重叠区域
        int[] mergeResult = new int[2];
        mergeResult[0] = Math.min(intervals[intervalIndex][0],newInterval[0]);
        //先假设合并[1]结果为新数组
        mergeResult[1] = newInterval[1];
        //下面开始真正找边界最大值
        int currentResultIndex = intervalIndex;
        while(intervalIndex < intervalLength && intervals[intervalIndex][0]<= newInterval[1]){
            mergeResult[1] = Math.max(intervals[intervalIndex][1],newInterval[1]);
            intervalIndex++;
        }
        result[currentResultIndex] = mergeResult;
        //处理最后一节非重叠区域
        if(intervalIndex >= intervalLength){
            return Arrays.copyOf(result,currentResultIndex+1);
        }

        while(intervalIndex < intervalLength){
            result[++currentResultIndex] = intervals[intervalIndex++];
        }
        return  Arrays.copyOf(result,currentResultIndex+1);

    }

    public static void main(String[] args){
        System.out.println(insert(new int[][]{{1,5}},new int[]{2,3}));
    }
}
