package lc;

/**
 * 2024/1/5
 * lamic
 **/
public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        //首先通过2分找到第一个target的位置，再前后逐渐减找完所有位置

        //这里先2分找
        int left = 0;
        int right = nums.length-1;
        int targetIdx = -1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                targetIdx = mid;
                break;
            }else if(target > nums[mid]){
                left = mid+1;
            }else if(target < nums[mid]){
                right = mid-1;
            }
        }

        if(targetIdx == -1){ //说明没有这个target
            return new int[]{-1,-1};
        }
        //这里用双指针扩大命中范围
        left = targetIdx;
        right = targetIdx;
        while(nums[left] == target && nums[right] == target){
            if(left > 0 && nums[left-1] != target && right < nums.length-1 && nums[right+1] !=target){
                break;
            }
            if(left == 0 && right == nums.length-1){ //都走到边界了
                break;
            }
            if(left > 0 && nums[left-1] == target){
                left--;
            }
            if(right < nums.length-1 && nums[right+1] ==target){
                right++;
            }
        }
        return new int[]{left,right};

    }

    public static void main(String[] args){
        LC34 lc = new LC34();
        lc.searchRange(new int[]{1,3},1);
    }
}
