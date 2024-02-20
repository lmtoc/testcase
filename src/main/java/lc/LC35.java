package lc;

/**
 * 2024/1/4
 * lamic
 **/
public class LC35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        if(target > nums[end]){
            return end+1;
        }
        if(target <= nums[0]){
            return 0;
        }
        while(start < end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(mid+1<nums.length && nums[mid+1]>target && mid >=1 && nums[mid-1] < target){//没有这个数字，但是正好卡在前小后大就是这个位置了
                return mid;
            }
            if(nums[mid]>target){
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }
        }
        //star就是第一个小于target的位置
        return start;
    }


    public static void main(String[] args){
        LC35 lc35 = new LC35();
        lc35.searchInsert(new int[]{1,3},2);
    }
}
