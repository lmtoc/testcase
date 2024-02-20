package lcr;

/**
 * 2024/1/29
 * lamic
 **/
public class LCR10 {
    public int subarraySum(int[] nums, int k) {
        int left = 0;
        int result = 0;
        int curSum = 0;
        for(int i = 0;i<nums.length;i++){
            curSum = curSum+nums[i];
            if(curSum == k) {
                result++;
            }

                //固定右端点试探有没有更多子集
            while(left<i){ //小于i是为了避免把自己剪掉了
                curSum = curSum-nums[left];
                left++;
                if(curSum == k){//缩小完范围要再检查一次
                    result++;
                }
            }


            }

        return result;
    }

    public static void main(String[] args) {
        LCR10 lc = new LCR10();
        System.out.println(lc.subarraySum(new int[]{1,-1,0},0));
    }
}
