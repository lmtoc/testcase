package lcr;

import java.util.Arrays;

/**
 * 2024/2/14
 * lamic
 **/
public class LCR047 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(v1, v2)->(v1[0]-v2[0]));
        int[][] result = new int[2][intervals.length];
        int resultCurIdx = 0;
        result[0] = intervals[0];
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0]>=result[resultCurIdx][1]){ //不需要喝冰的情况
                result[++resultCurIdx] = intervals[i];
            }else{//有交叉值
                result[resultCurIdx][0] = Math.min(intervals[i][0],result[resultCurIdx][0]);
                result[resultCurIdx][1] = Math.max(intervals[i][1],result[resultCurIdx][1]);
            }
        }
        return Arrays.copyOf(result,resultCurIdx+1);
    }

    public static void main(String[] args) {
        LCR047 lcr047 = new LCR047();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(lcr047.merge(intervals)));
    }
}
