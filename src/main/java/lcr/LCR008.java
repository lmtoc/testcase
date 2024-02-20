package lcr;

/**
 * 2024/1/26
 * lamic
 **/
public class LCR008 {
    public int minSubArrayLen(int target, int[] nums) {
        int total = 0;
        int result = Integer.MAX_VALUE;
        int leftIndex = 0;
        int currentResult = 0;
        for(int i = 0;i<nums.length;i++){
            total+=nums[i];
            currentResult+=nums[i];

            while(target <= currentResult-nums[leftIndex]){
                currentResult -= nums[leftIndex++];
            }
            if(target <= currentResult){
                result = Math.min(i-leftIndex+1,result);
                currentResult -= nums[leftIndex++]; //找下一个组合
            }
            System.out.println("currentResult:["+currentResult+"];leftIndex:["+leftIndex+"];i:["+i+"];num:["+nums[i]);

        }
        if(total<target){
            return 0;
        }
        return result;

    }


    public static void main(String[] args) {
        LCR008 lc = new LCR008();
        System.out.println(lc.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
