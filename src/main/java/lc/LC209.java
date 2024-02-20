package lc;

/**
 * 2023/12/8
 * lamic
 **/
public class LC209 {

    public static  int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int numsLength = nums.length;
        for(int i = 0;i<numsLength;i++){
            sum += nums[i];
            if(nums[i] >= target){
                return 1;
            }

        }
        if(sum < target){
            return 0;
        }
        int left = 0;
        int right = numsLength-1;
        while(left<right ){
            int currentSum = sum-nums[left];
            if(nums[left] > nums[right]){
                currentSum = sum - nums[right];
                right--;
            }else{
                left++;
            }
            if(currentSum == target){//说明就是当前坐标，返回当前坐标的距离
                return right-left+1;
            }
            if(currentSum < target){ //这是弥补少了之后回退一个left/right
                return right-left+2;
            }
            sum = currentSum;
        }
        return 0;
    }

    public int minSubArrayLenChatGpt(int target, int[] nums) {
        int numsLength = nums.length;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        while (right < numsLength) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String [] args){
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
//        System.out.println(minSubArrayLen(11,new int[]{1,2,3,4,5}));
    }
}
