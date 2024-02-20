package lc;

/**
 * 2023/12/12
 * lamic
 **/
public class LC219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //滑动窗口：left与left+i 1<i<k之内的数比较，如果没有相同的left = left+1重复上一轮

        int length = nums.length;
        for(int left = 0;left<length;left++){
            for(int i = 1;i<=k;i++){
                if(nums[left +i] == nums[left]){
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String [] args){
        System.out.println(containsNearbyDuplicate(new int[]{99,99},3));
    }
}
