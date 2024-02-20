package lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 2024/1/18
 * lamic
 **/
public class LC2171 {

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        //目标要使剩下的非0的index的值相等，使得删除的数最少
        //要找到大家一致到达的值,假设为m,m一定与beans中的元素相等，那么当前数组小于m的要删除到0，大于m的要删除到m，求改动最小值
        //前缀和数组表示当前与前面的豆子的差距，后缀同样
        int [] prefix = new int[beans.length];
        prefix[0] = 0;
        long total = beans[0];
        for(int i = 1;i<beans.length;i++){
            prefix[i] = prefix[i-1]+beans[i-1];
            total +=  beans[i];
        }

        //假设i之前的都变成0，i之后的都变成i相等的数值，计算出数据变化量
        long result = Long.MAX_VALUE;
        for(int i = 0;i<beans.length;i++){
            //前缀和是贴移除量，剩下要求后缀和以及变化量，变化在于后缀和要变成beans[i]*后缀长度
            long current = prefix[i]+(total-prefix[i]-beans[i]-beans[i]*(beans.length-i-1));
            result = Math.min(result,current);
        }
        return result;



    }

    public static void main(String[] args) {
        int maxHeigth = Arrays.stream(new int[5]).max().getAsInt();
        LC2171 lc = new LC2171();
        System.out.println(lc.minimumRemoval(new int[]{4,1,6,5}));
    }
}
