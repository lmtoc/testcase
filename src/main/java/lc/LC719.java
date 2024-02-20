package lc;

import java.util.Arrays;

/**
 * 2024/1/10
 * lamic
 **/
public class LC719 {

    public int smallestDistancePair(int[] nums, int k) {
        //这里我们会有定式，第k小就用堆（优先队列）,这题其实是可以的，但是用队列其实就是暴力解法，而且内存超了嘿嘿
        //距离对最小肯定产生在有序队列的相邻元素之间，最大的距离肯定产生在有序队列的最小与最大元素之间
        //题解推荐二分法，那我们可以根据距离二分，找到每个距离对的数量；以此来找到第一个积累数量为k的距离对
        Arrays.sort(nums);//排序好找最大距离对的值
        int length = nums.length;
        int right = nums[length-1]-nums[0];
        int left = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            int cnt = 0;
            //检查符合的数量
            for(int i = 0;i < length;i++){
                for(int j = 0;j<length;j++){
                    if(nums[j]-nums[i] <= mid){
                        cnt++;
                    }
                }
            }

            if(cnt >= k){ //等于也不代表找到了，因为mid可能是不存在数组中的差值对，要找到第一个满足k的差值对，所以要继续缩小右边界去找
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left; //二分是使left right mid 都指向结尾 所以这仨都行
    }

    public static void main(String [] args){
        LC719 lc = new LC719();
        lc.smallestDistancePair(new int[]{1,6,1},3);
    }
}
